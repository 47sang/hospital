package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Nav;

import java.util.List;

public interface NavService {

    String addNav(Nav nav);

    String deleteNav(Integer nav_id);

    String updateNav(Nav nav);

    Nav findNavById(Integer nav_id);

    List<Nav> findNavByType(String nav_type);

    List<Nav> findNavAll();
}
