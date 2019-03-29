package com.lhf.deviceMS.service;

import com.lhf.deviceMS.domain.entity.User;

public interface TestService {
    String search();

    void insert(User user);

    void update(User user);
}
