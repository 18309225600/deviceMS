package com.lhf.deviceMS.repository.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.utils.TimeUtils;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.domain.enums.DeviceStatus;
import com.lhf.deviceMS.repository.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Author lhf
 * @Description
 * @Date 2019/4/3 10:14
 * @Version 1.0
 **/
@Repository
public class DeviceDao {

    @Autowired
    private DetailMapper detailMapper;

    public Integer queryTotalByStatus(DeviceStatus status) {
        Weekend<Detail> weekend = new Weekend<>(Detail.class);
        weekend.weekendCriteria().andIsNull(Detail::getDeletedAt).andEqualTo(Detail::getStatus,status.getCode());
        return detailMapper.selectCountByExample(weekend);
    }

    public PageInfo<Detail> list(DeviceStatus status,Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Weekend<Detail> weekend = new Weekend<>(Detail.class);
        weekend.weekendCriteria().andIsNull(Detail::getDeletedAt).andEqualTo(Detail::getStatus,status);
        return new PageInfo<>(detailMapper.selectByExample(weekend));
    }

    public void merge(List<Detail> devices) {
        Objects.requireNonNull(devices);
        devices.stream().forEach(device->merge(device));
    }

    private void merge(Detail device) {
        Objects.requireNonNull(device);
        if (device.getId()==null){
            device.setCreatedAt(TimeUtils.currentTime());
            detailMapper.insertSelective(device);
        }else{
            detailMapper.updateByPrimaryKeySelective(device);
        }
    }
}
