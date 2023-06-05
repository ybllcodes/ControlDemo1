package com.hra.controldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hra.controldemo.mapper")

//@ComponentScan(basePackages = {"com.hra.controldemo"})
public class ControlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlDemoApplication.class, args);
    }

}
