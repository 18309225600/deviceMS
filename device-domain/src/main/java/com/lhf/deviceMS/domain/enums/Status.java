package com.lhf.deviceMS.domain.enums;

public enum Status {
    NOMAL("正常"),
    ABNOMAL("异常");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
