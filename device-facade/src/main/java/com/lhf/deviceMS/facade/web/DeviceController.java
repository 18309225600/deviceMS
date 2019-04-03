package com.lhf.deviceMS.facade.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @GetMapping("/list")
    public String list(Map model){
        model.put("list",null);
        return "modules/deviceList/list";
    }


    public String addPage(){
        return "";
    }
}
