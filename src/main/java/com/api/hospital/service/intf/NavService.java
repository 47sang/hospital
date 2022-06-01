package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Nav;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NavService {

    String uploadIcon(MultipartFile file);

    void addNav(Nav nav);

    void deleteNav(Integer nav_id);

    void updateNav(Nav nav);

    Nav findNavById(Integer nav_id);

    List<Nav> findNavByType(String nav_type);

    List<Nav> findNavAll();
}
