package com.api.hospital.constant;


public class ExceptionConstants {

    /**
     * 正常返回/操作成功
     **/
    public static final int SERVICE_SUCCESS_CODE = 200;
    public static final String SERVICE_SUCCESS_MSG = "操作成功";
    /**
     * 数据查询异常
     */
    public static final int DATA_READ_FAIL_CODE = 300;
    public static final String DATA_READ_FAIL_MSG = "数据查询异常";
    /**
     * 数据写入异常
     */
    public static final int DATA_WRITE_FAIL_CODE = 301;
    public static final String DATA_WRITE_FAIL_MSG = "数据写入异常";

    /**
     * 系统运行时未知错误
     **/
    public static final int SERVICE_SYSTEM_ERROR_CODE = 500;
    public static final String SERVICE_SYSTEM_ERROR_MSG = "未知异常";

}
