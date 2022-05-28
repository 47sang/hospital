package com.api.hospital.service.impl;

import com.api.hospital.mapper.NavMapper;
import com.api.hospital.model.entity.Nav;
import com.api.hospital.service.intf.NavService;
import com.api.hospital.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class NavServiceImpl implements NavService {

    @Resource
    private NavMapper navMapper;

    @Value("${file.path}")
    private String uploadPath;

    @Override
    public String uploadIcon(MultipartFile file) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        //后缀名：文件格式
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取当前时间戳
        String time = String.valueOf(System.currentTimeMillis());
        //新文件名
        String newFileName = time + suffixName;
        try {
            //保存文件
            FileUtils.SaveFileFromInputStream(file.getInputStream(), uploadPath, newFileName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传失败");
        }
        return newFileName;
    }

    @Override
    public String addNav(Nav nav) {
        //排序和状态设置默认值
        if (nav.getNav_sort() == null) nav.setNav_sort();
        if (nav.getNav_status() == null) nav.setNav_status();
        //判断文章标题是否为空
        if (nav.getNav_title() == null || nav.getNav_title().equals("")) throw new RuntimeException("导航标题不能为空");
        //检查文章存在不
        if (navMapper.findNavByTitle(nav.getNav_title()) != null) throw new RuntimeException("该标题已存在");
        //写入数据库中
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
