package com.lhf.deviceMS.service;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.domain.entity.User;

public interface UserService {
    void regist(User inputUser) throws WebException;
}
