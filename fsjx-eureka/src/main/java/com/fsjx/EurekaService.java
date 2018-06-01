package com.fsjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心eureka
 * Created by lizhen on 2018\5\29 0029.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaService {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService.class, args);
    }
}

