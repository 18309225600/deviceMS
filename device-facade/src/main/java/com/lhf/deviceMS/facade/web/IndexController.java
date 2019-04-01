package com.lhf.deviceMS.facade.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String toIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "login/login";
    }
}
