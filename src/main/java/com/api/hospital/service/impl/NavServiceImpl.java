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
        if (navMapper.addNav(nav) == 1) {
            return "success";
        } else {
            return "添加成功";
        }
    }

    @Override
    public String deleteNav(Integer nav_id) {
        if (navMapper.deleteNav(nav_id) == 1) {
            return "success";
        } else {
            return "删除失败";
        }
    }

    @Override
    public String updateNav(Nav nav) {
        if (navMapper.updateNav(nav) == 1) {
            return "success";
        } else {
            return "更新失败";
        }
    }

    @Override
    public Nav findNavById(Integer nav_id) {
        Nav data = navMapper.findNavById(nav_id);
        if ( data != null) {
            return data;
        } else {
            throw new RuntimeException("未找到对应数据");
        }
    }

    @Override
    public List<Nav> findNavByType(String nav_type) {
        List<Nav> data = navMapper.findNavByType(nav_type);
        if ( data != null) {
            return data;
        } else {
            throw new RuntimeException("未找到对应数据");
        }
    }

    @Override
    public List<Nav> findNavAll() {
        List<Nav> data = navMapper.findNavAll();
        if ( data != null) {
            return data;
        } else {
            throw new RuntimeException("无数据");
        }
    }
}
