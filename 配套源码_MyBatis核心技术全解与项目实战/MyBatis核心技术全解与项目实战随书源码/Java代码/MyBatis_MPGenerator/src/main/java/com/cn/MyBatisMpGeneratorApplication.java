package com.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cn.mpg.mapper")
public class MyBatisMpGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisMpGeneratorApplication.class, args);
    }

}
