package com.lhf.deviceMS.service;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.domain.enums.DeviceStatus;

public interface DeviceService {
    PageInfo<Detail> list(DeviceStatus status,Integer pageNo, Integer pageSize);

    void add(String name, String price, Integer number, String description, String source);
}
