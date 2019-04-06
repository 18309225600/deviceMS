package com.lhf.deviceMS.service;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.domain.entity.RepairDetail;
import com.lhf.deviceMS.domain.enums.DeviceStatus;

public interface DeviceService {
    PageInfo<Detail> list(DeviceStatus status,Integer pageNo, Integer pageSize);

    void add(String name, String price, Integer number, String description, String source);

    Detail queryDeviceById(Long deviceId);

    void updateDeviceStatus(Long deviceId, DeviceStatus status, String remark);

    void delDevice(Long deviceId, String remark);

    PageInfo<RepairDetail> repairList(Integer pageNo, Integer pageSize);
}
