package com.lhf.deviceMS.service.impl;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.common.std.enums.WebErrCode;
import com.lhf.deviceMS.common.utils.EncryptionUtils;
import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.repository.dao.UserDao;
import com.lhf.deviceMS.service.MailService;
import com.lhf.deviceMS.service.UserService;
import com.lhf.deviceMS.service.task.RepassMailTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.UnknownHostException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MailService mailService;

    @Autowired
    private ThreadPoolTaskExecutor pool;

    @Value("${server.port}")
    private Integer port;

    @Override
    public void regist(User inputUser) throws WebException {
        //check email unique
        if (!singleEmail(inputUser.getEmail())){
            throw new WebException(WebErrCode.DEVICE_USER_EMAIL_REPEAT);
        }

        inputUser.setPassword(EncryptionUtils.md5(inputUser.getPassword()));
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

    @Override
    public String repassCheck(String email) throws UnknownHostException {
        List<User> users = userDao.queryUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return WebErrCode.DEVICE_USER_NOT_EXIST.getMsg();
        }

        pool.submit(new RepassMailTask(email,mailService,port,users.get(0).getId()));
        return WebErrCode.DEVICE_OP_SUCC.getMsg();
    }

    @Override
    public String realRepass(Long userId, String password) {
        User user = userDao.queryUserById(userId);
        if (user==null){
            return WebErrCode.DEVICE_USER_NOT_EXIST.getMsg();
        }

        User repass = new User();
        repass.setId(userId);
        repass.setPassword(EncryptionUtils.md5(password));
        userDao.merge(repass);

        return WebErrCode.DEVICE_OP_SUCC.getMsg();
    }


    private boolean singleEmail(String email) {
        List<User> users = userDao.queryUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return true;
        }
        return false;
    }
}
