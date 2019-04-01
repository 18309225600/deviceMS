package com.lhf.deviceMS.service.impl;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.common.std.enums.WebErrCode;
import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.repository.dao.UserDao;
import com.lhf.deviceMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void regist(User inputUser) throws WebException {
        //check email unique
        if (!singleEmail(inputUser.getEmail())){
            throw new WebException(WebErrCode.DEVICE_USER_EMAIL_REPEAT);
        }

        userDao.merge(inputUser);
    }

    private boolean singleEmail(String email) {
        List<User> users = userDao.queryUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return true;
        }
        return false;
    }
}
