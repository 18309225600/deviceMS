package com.lhf.deviceMS.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.utils.RandomUtils;
import com.lhf.deviceMS.common.utils.SessionUtils;
import com.lhf.deviceMS.common.utils.TimeUtils;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.domain.entity.RepairDetail;
import com.lhf.deviceMS.domain.enums.DeviceStatus;
import com.lhf.deviceMS.domain.enums.RepaireStatus;
import com.lhf.deviceMS.repository.dao.DeviceDao;
import com.lhf.deviceMS.repository.dao.RepaireDao;
import com.lhf.deviceMS.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private RepaireDao repaireDao;

    @Autowired
    private ThreadPoolTaskExecutor pool;

    @Override
    public PageInfo<Detail> list(DeviceStatus status,Integer pageNo, Integer pageSize) {
        return deviceDao.list(status,pageNo,pageSize);
    }

    Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

    @Override
    public void add(String name, String price, Integer number, String description, String source) {

        //pack Details list
        pool.submit(()->{
            List<Detail> devices = packDevices(name,price,number,description,source);
            deviceDao.merge(devices);
        });

    }

    @Override
    public Detail queryDeviceById(Long deviceId) {
        return deviceDao.queryDeviceById(deviceId);
    }

    @Override
    public void updateDeviceStatus(Long deviceId, DeviceStatus status, String remark) {
        Detail exist = deviceDao.queryDeviceById(deviceId);
        Objects.requireNonNull(exist);

        Detail detail = new Detail();
        detail.setId(deviceId);
        detail.setOpUserId(SessionUtils.getUserId());
        detail.setOpUserName(SessionUtils.getUsername());

        if (status==DeviceStatus.DUMPED){
            detail.setStatus(status.getCode());
            detail.setRemark(remark);
        }else if (status==DeviceStatus.REPAIRING){
            detail.setStatus(status.getCode());
            detail.setRemark(remark);

            //repair recored
            RepairDetail repairDetail = new RepairDetail();
            repairDetail.setUserId(SessionUtils.getUserId());
            repairDetail.setUserName(SessionUtils.getUsername());
            repairDetail.setDeviceId(deviceId);
            repairDetail.setDeviceCode(exist.getCode());
            repairDetail.setDeviceName(exist.getName());
            repairDetail.setStatus(RepaireStatus.UNREPAIR.getCode());
            repairDetail.setRemark(remark);
            repaireDao.merge(repairDetail);

        }else if (status==DeviceStatus.LOST){
            detail.setStatus(status.getCode());
            detail.setRemark(remark);
        }

        deviceDao.merge(Arrays.asList(detail));
    }

    private List<Detail> packDevices(String name, String price, Integer number, String description, String source) {
        List<Detail> details = new ArrayList<>();

        for (int i=0;i<number;i++){
            Detail detail = new Detail();
            detail.setCode(RandomUtils.randomOrderId(15));
            detail.setName(name);
            detail.setDumped("FALSE");
            detail.setStatus(DeviceStatus.NOMAL.getCode());
            detail.setPrice(Long.valueOf(Objects.toString(new BigDecimal(price).multiply(new BigDecimal("100")).intValue(), "0")));
            detail.setDescription(description);
            detail.setSource(source);
            detail.setNumber(number);
            details.add(detail);
        }
        return details;
    }
}
