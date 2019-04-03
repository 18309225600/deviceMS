package com.lhf.deviceMS.domain.enums;

/**
 * @Author lhf
 * @Description
 * @Date 2019/4/3 10:24
 * @Version 1.0
 **/
public enum DeviceStatus {
    //'NOMAL','DUMPED','LOST','REPAIRING'
    NOMAL("NOMAL","正常"),
    DUMPED("DUMPED","报废"),
    LOST("LOST","丢失"),
    REPAIRING("REPAIRING","维修中"),

    ;

    private String code;
    private String msg;

    DeviceStatus(String code, String msg) {
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
