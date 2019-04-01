package com.lhf.deviceMS.facade.config.common.interceptors;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.common.std.enums.WebErrCode;
import com.lhf.deviceMS.common.utils.SessionUtils;
import com.lhf.deviceMS.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    protected Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //check session invalid
        User user = (User)session.getAttribute("user");

        if (user==null){
            logger.info("用户凭证不存在,跳转登录页。。");
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
        }

        logger.info("current login username is : {}",user.getName());
        SessionUtils.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
