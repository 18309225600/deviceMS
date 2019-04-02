package com.lhf.deviceMS.service;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.domain.entity.User;

import javax.servlet.http.HttpServletRequest;


public interface UserService {
    void regist(User inputUser) throws WebException;

    String login(HttpServletRequest request,String email, String password) throws WebException;
}
