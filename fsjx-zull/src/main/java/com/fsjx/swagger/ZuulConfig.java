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
                //标记一个子表达式的开始和结束位置。
                //匹配前面的子表达式零次或一次。

                //匹配输入字符串的开始位置，除非在方括号表达式中使用，此时它表示不接受该字符集合。要匹配 ^ 字符本身，请使用 \^。
                "(?<project>^.+)-(?<subProject>.+$)",
                "${project}/${subProject}");
    }
}
