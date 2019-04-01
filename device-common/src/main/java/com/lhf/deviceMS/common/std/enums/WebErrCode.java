package com.lhf.deviceMS.common.std.enums;

/**
 * @author zuochi
 * @version 1.0.0
 * @date 17/8/19
 */
public enum WebErrCode {
    DEVICE_SYS_ERROR("5000001","网络繁忙"),
    DEVICE_SYS_OPTION_NOT_EXSIT("5000002","操作信息不存在"),
    DEVICE_COMMON_OPERATION_FAIL("5000003","操作失败"),
    DEVICE_COMMON_INVALID_PARAM("5000004","参数错误"),
    DEVICE_USER_AUTH_NOT_EXIST("5000005","用户登录凭证不存在"),


    DEVICE_USER_EMAIL_REPEAT("1000001","用户邮箱已存在"),


    ;

    private String code;
    private String msg;

    WebErrCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
