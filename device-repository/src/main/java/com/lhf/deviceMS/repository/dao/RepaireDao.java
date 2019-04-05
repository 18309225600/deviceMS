package com.lhf.deviceMS.repository.dao;

import com.lhf.deviceMS.common.utils.TimeUtils;
import com.lhf.deviceMS.domain.entity.RepairDetail;
import com.lhf.deviceMS.repository.mapper.RepairDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class RepaireDao {

    @Autowired
    private RepairDetailMapper repairDetailMapper;

    public void merge(RepairDetail detail){
        Objects.requireNonNull(detail);

        if (detail.getId()==null){
            detail.setCreatedAt(TimeUtils.currentTime());
            repairDetailMapper.insertSelective(detail);
        }else{
            repairDetailMapper.updateByPrimaryKeySelective(detail);
        }
    }
}
