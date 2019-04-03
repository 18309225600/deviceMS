package com.lhf.deviceMS.repository.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.domain.enums.DeviceStatus;
import com.lhf.deviceMS.repository.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

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

    public PageInfo<Detail> list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Weekend<Detail> weekend = new Weekend<>(Detail.class);
        weekend.weekendCriteria().andIsNull(Detail::getDeletedAt).andEqualTo(Detail::getStatus,DeviceStatus.NOMAL);
        return new PageInfo<>(detailMapper.selectByExample(weekend));
    }
}
