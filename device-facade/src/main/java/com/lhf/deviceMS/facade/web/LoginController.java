package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.facade.data.input.UserRegistInputDto;
import com.lhf.deviceMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public String regist(UserRegistInputDto input, Map model) throws WebException {
        User inputUser = input.verify().transform();
        userService.regist(inputUser);
        model.put("msg","regist succ");
        return "regist/succ";
    }
}
