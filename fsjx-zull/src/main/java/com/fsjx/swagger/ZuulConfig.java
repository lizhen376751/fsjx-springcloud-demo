package com.fsjx.swagger;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018\5\31 0031.
 */
//修改 serviceId 与 路由之间的相互映射
//@Configuration
public class ZuulConfig {
    //自定义 serviceId 和路由之间的相互映射
//    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<project>^.+)-(?<subProject>.+$)",
                "${project}/${subProject}");
    }
}
