package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.domain.entity.TestUser;
import com.lhf.deviceMS.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
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
        TestUser testUser = new TestUser();
        testUser.setEmail("18309225600@163.com");
        testUser.setUsername("刘宏飞");
        testUser.setPhone("18309225600");
        testUser.setPassword("123456");
        testUser.setCreated(new Date());
        testUser.setUpdated(new Date());

        testService.insert(testUser);
    }



    @PostMapping("/update")
    public void update(){
        TestUser testUser = new TestUser();
        testUser.setId(5L);
        testUser.setPassword("1234567");
        testService.update(testUser);
    }


    @GetMapping("/hello2")
    public String hello(Map model){
        model.put("hello","234;");
        return "hello";
    }

}
