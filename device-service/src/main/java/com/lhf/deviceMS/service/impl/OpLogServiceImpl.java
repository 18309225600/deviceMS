package com.lhf.deviceMS.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.domain.entity.Log;
import com.lhf.deviceMS.repository.dao.OpLogDao;
import com.lhf.deviceMS.service.OpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpLogServiceImpl implements OpLogService {

    @Autowired
    private OpLogDao opLogDao;

    @Override
    public PageInfo<Log> list(Integer pageNo, Integer pageSize) {
        return opLogDao.list(pageNo,pageSize);
    }
}
