package com.lhf.deviceMS.facade.web;


import com.lhf.deviceMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 个人信息
     * @return
     */
    @GetMapping("/myInfo")
    public String myInfo(){
        return "/modules/user/myInfo";
    }
}
