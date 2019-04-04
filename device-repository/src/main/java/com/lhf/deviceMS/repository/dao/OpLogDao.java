package com.lhf.deviceMS.repository.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.utils.TimeUtils;
import com.lhf.deviceMS.domain.entity.Log;
import com.lhf.deviceMS.repository.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Objects;

@Repository
public class OpLogDao {

    @Autowired
    private LogMapper logMapper;


    public void merge(Log log) {
        Objects.requireNonNull(log);
        if (log.getId()==null){
            log.setCreatedAt(TimeUtils.currentTime());
            logMapper.insertSelective(log);
        }else{
            logMapper.updateByPrimaryKeySelective(log);
        }
    }

    public PageInfo<Log> list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Weekend<Log> weekend = new Weekend<>(Log.class);
        weekend.setOrderByClause(" created_at desc,id desc ");
        weekend.weekendCriteria().andIsNull(Log::getDeletedAt);
        return new PageInfo<>(logMapper.selectByExample(weekend));
    }
}
