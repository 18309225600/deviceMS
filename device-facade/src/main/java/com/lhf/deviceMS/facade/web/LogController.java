package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;
}
