package com.lhf.deviceMS.domain.vo;

/**
 * @Author lhf
 * @Description
 * @Date 2019/4/3 10:09
 * @Version 1.0
 **/
public class IndexTotalVo {
    private Integer deviceNum;
    private Integer dumpNum;
    private Integer repairNum;
    private Integer userNum;

    public Integer getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(Integer deviceNum) {
        this.deviceNum = deviceNum;
    }

    public Integer getDumpNum() {
        return dumpNum;
    }

    public void setDumpNum(Integer dumpNum) {
        this.dumpNum = dumpNum;
    }

    public Integer getRepairNum() {
        return repairNum;
    }

    public void setRepairNum(Integer repairNum) {
        this.repairNum = repairNum;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }
}
