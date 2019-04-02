package com.lhf.deviceMS.service.impl;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.common.std.enums.WebErrCode;
import com.lhf.deviceMS.common.utils.EncryptionUtils;
import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.repository.dao.UserDao;
import com.lhf.deviceMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Override
    public String login(HttpServletRequest request,String email, String password) throws WebException {
        //check user exist
        List<User> users = userDao.queryUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return WebErrCode.DEVICE_USER_NOT_EXIST.getMsg();
        }

        if (users.size()>1){
            return WebErrCode.DEVICE_USER_INFO_ERR.getMsg();
        }

        User user = users.get(0);
        if (!EncryptionUtils.md5(password).equalsIgnoreCase(user.getPassword())){
            return WebErrCode.DEVICE_USER_EMAIL_OR_EMAIL_INVALID.getMsg();
        }

        if (user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }

        return null;
    }


    private boolean singleEmail(String email) {
        List<User> users = userDao.queryUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return true;
        }
        return false;
    }
}
