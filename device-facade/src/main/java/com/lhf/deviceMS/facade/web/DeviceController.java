package com.lhf.deviceMS.facade.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @GetMapping("/list")
    public String list(){
        return "modules/deviceList/list";
    }
}
