package com.cn.fms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cn.fms.mapper")
public class FmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsApplication.class, args);
    }

}
