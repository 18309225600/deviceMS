package com.lhf.deviceMS.domain.enums;

public enum  RepaireStatus {
    REPAIRED("REPAIRED","已维修"),
    UNREPAIR("UNREPAIR","待维修")
    ;

    private String code;
    private String msg;

    RepaireStatus(String code, String msg) {
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
