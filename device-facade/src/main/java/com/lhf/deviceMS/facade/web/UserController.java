package com.lhf.deviceMS.facade.web;


import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.std.PageIn;
import com.lhf.deviceMS.common.std.enums.WebErrCode;
import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.facade.config.oplog.annotations.OpLog;
import com.lhf.deviceMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


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

    /**
     * 用户列表
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/list")
    public String list(Map model, PageIn page){
        PageInfo<User> pageInfo = userService.list(page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "modules/user/list";
    }

    @ResponseBody
    @OpLog("更改用户角色")
    @GetMapping("/changeRole/{userId}")
    public String changeRole(@PathVariable("userId")Long userId,String role){
        String s = userService.changeRole(userId, role);
        return s;
    }
}
