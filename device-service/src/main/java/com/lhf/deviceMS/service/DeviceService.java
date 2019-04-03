package com.lhf.deviceMS.service;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.domain.entity.Detail;

public interface DeviceService {
    PageInfo<Detail> list(Integer pageNo, Integer pageSize);
}
