package com.api.hospital.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseInfo<T> {

    private Integer code;
    private String message;
    private T data;

    public ResponseInfo() {
        this.code = 200;
        this.message = "success";
    }
}
