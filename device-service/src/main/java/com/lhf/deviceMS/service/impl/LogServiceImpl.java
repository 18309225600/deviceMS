package com.lhf.deviceMS.service.impl;

import com.lhf.deviceMS.domain.entity.Log;
import com.lhf.deviceMS.repository.dao.LogDao;
import com.lhf.deviceMS.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void save(Log log) {
        logDao.merge(log);
    }
}
