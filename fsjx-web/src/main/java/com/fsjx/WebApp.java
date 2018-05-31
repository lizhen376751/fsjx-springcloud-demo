package com.fsjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 服务调用
 * Created by lizhen on 2018\5\29 0029.
 */
//启动项目
@SpringBootApplication
//开启注册中心获取地址
@EnableEurekaClient
//开启客户端调用工具
@EnableFeignClients
@EnableHystrix
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class,args);
    }
}
