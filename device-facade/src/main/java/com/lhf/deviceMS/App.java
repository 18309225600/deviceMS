package com.lhf.deviceMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
@MapperScan(basePackages = {"com.lhf.deviceMS.repository.mapper", "com.lhf.deviceMS.repository.mapper.*"})
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
