package com.api.hospital.service.impl;

import com.api.hospital.mapper.NavMapper;
import com.api.hospital.model.entity.Nav;
import com.api.hospital.service.intf.NavService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NavServiceImpl implements NavService {

    @Resource
    private NavMapper navMapper;

    @Override
    public String addNav(Nav nav) {
        if (nav.getNav_sort() == null) nav.setNav_sort();
        if (nav.getNav_status() == null) nav.setNav_status();
        if (nav.getNav_title() == null || nav.getNav_title().equals("")) throw new RuntimeException("导航标题不能为空");
        if (navMapper.findNavByTitle(nav.getNav_title()) != null) throw new RuntimeException("该标题已存在");
        if (navMapper.addNav(nav) == 1) return "success";
        else throw new RuntimeException("添加失败");
    }

    @Override
    public String deleteNav(Integer nav_id) {
        if (navMapper.deleteNav(nav_id) == 1) return "success";
        else throw new RuntimeException("删除失败，请检查数据是否存在");
    }

    @Override
    public String updateNav(Nav nav) {
        if (navMapper.updateNav(nav) == 1) return "success";
        else throw new RuntimeException("未能更新数据");
    }

    @Override
    public Nav findNavById(Integer nav_id) {
        Nav data = navMapper.findNavById(nav_id);
        if (data != null) return data;
        else throw new RuntimeException("未找到对应数据");
    }

    @Override
    public List<Nav> findNavByType(String nav_type) {
        List<Nav> data = navMapper.findNavByType(nav_type);
        if (data.size() > 0) return data;
        else throw new RuntimeException("未找到对应数据");
    }

    @Override
    public List<Nav> findNavAll() {
        List<Nav> data = navMapper.findNavAll();
        if (data.size() > 0) return data;
        else throw new RuntimeException("Nav数据库中无数据");
    }
}
