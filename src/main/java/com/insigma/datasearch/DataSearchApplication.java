package com.insigma.datasearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.insigma.datasearch.business.*.mapper")
public class DataSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSearchApplication.class, args);
    }

}
