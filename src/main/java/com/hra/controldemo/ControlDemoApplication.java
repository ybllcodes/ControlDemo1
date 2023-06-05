package com.hra.controldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hra.controldemo.mapper")
public class ControlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlDemoApplication.class, args);
    }

}
