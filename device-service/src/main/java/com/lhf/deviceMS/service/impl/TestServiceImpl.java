package com.lhf.deviceMS.service.impl;

import com.lhf.deviceMS.domain.entity.TestUser;
import com.lhf.deviceMS.repository.dao.TestDao;
import com.lhf.deviceMS.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public String search() {
        return testDao.search();
    }

    @Override
    public void insert(TestUser testUser) {
        testDao.insert(testUser);
    }

    @Override
    public void update(TestUser testUser) {
        testDao.update(testUser);
    }
}
