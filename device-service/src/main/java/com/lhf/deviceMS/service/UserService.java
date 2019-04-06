package com.lhf.deviceMS.service;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.domain.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;


public interface UserService {
    void regist(User inputUser) throws WebException;

    String login(HttpServletRequest request,String email, String password) throws WebException;

    String repassCheck(String email) throws UnknownHostException;

    String realRepass(Long userId, String password);
}
