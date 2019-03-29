package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/search")
    public String search(){
        return testService.search();
    }

    @PostMapping("/insert")
    public void insert(){
        User user = new User();
        user.setEmail("18309225600@163.com");
        user.setUsername("刘宏飞");
        user.setPhone("18309225600");
        user.setPassword("123456");
        user.setCreated(new Date());
        user.setUpdated(new Date());

        testService.insert(user);
    }



    @PostMapping("/update")
    public void update(){
        User user = new User();
        user.setId(5L);
        user.setPassword("1234567");
        testService.update(user);
    }


}
