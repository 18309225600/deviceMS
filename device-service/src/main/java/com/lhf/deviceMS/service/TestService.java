package com.lhf.deviceMS.service;

import com.lhf.deviceMS.domain.entity.TestUser;

public interface TestService {
    String search();

    void insert(TestUser testUser);

    void update(TestUser testUser);
}
