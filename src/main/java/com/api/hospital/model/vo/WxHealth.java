package com.api.hospital.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WxHealth implements Serializable {
    private List<Health> health;
}

