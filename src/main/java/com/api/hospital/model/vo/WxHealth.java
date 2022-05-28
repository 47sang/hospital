package com.api.hospital.model.vo;

import com.api.hospital.model.entity.Health;
import lombok.Data;

import java.util.List;

@Data
public class WxHealth {
    private List<Health> health;
}

