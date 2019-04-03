package com.lhf.deviceMS.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.repository.dao.DeviceDao;
import com.lhf.deviceMS.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public PageInfo<Detail> list(Integer pageNo, Integer pageSize) {
        return deviceDao.list(pageNo,pageSize);
    }
}
