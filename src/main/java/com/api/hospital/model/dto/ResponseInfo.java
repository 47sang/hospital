package com.api.hospital.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseInfo {

    private Integer code;
    private String message;
    private Object data;

    public ResponseInfo() {
        this.code = 200;
        this.message = "success";
    }
}
