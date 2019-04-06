package com.lhf.deviceMS.service.impl;

import com.lhf.deviceMS.domain.entity.Log;
import com.lhf.deviceMS.repository.dao.OpLogDao;
import com.lhf.deviceMS.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private OpLogDao opLogDao;

    @Override
    public void save(Log log) {
        opLogDao.merge(log);
    }


}
