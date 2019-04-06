package com.lhf.deviceMS.service;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.domain.entity.Menu;
import com.lhf.deviceMS.domain.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.List;


public interface UserService {
    void regist(User inputUser) throws WebException;

    String login(HttpServletRequest request,String email, String password) throws WebException;

    String repassCheck(String email) throws UnknownHostException;

    String realRepass(Long userId, String password);

    PageInfo<User> list(Integer pageNo, Integer pageSize);

    String changeRole(Long userId, String role);

    List<Menu> menuListByRole(String role);

    String updateRoleMenus(String role, Long[] menus);
}
