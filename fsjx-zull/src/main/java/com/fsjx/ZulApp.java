package com.fsjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 接口项目
 * Created by lizhen on 2018\5\30 0030.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZulApp.class,args);
    }
}
