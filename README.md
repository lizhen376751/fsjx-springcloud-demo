# fsjx springcloud.demo文档说明

# QuickStart

基于SpringCloud体系实现，简单实现查询用户的demo，满足基本功能。
初期考虑用到如下组件：
1.服务注册、发现: eureka
2.断路器: hystrix
3.API网关: zuul
4.服务负载:feign+ribbon
5.api文档输出:swagger2


# 各模块介绍

| 模块名称        | 端口    |  简介   |
| --------        | -----:  | :----:  |
|fsjx-eureka      |	 9000	|  服务注册中心，提供服务注册、发现功能
|fsjx-zull	      |  9003	|  API网关模块
|fsjx-api	      |  无	    |  提供服务接口，无具体实现
|fsjx-common      |	 无 	|  基础组件
|fsjx-userservice |	 9001	|  用户服务接口具体实现
|fsjx-web	      |  9002	|  服务调用，以及页面展示

# 快速上手

- 1、先启动fsjx-eureka/fsjx-zull基础服务
- 2、再启动fsjx-userservice/fsjx-web基础业务服务
- 3、输入http://localhost:9003/swagger-ui.html ，根据API文档可使用功能

# 源码地址
![image](https://github.com/lizhen376751/fsjx-springcloud-demo.git)



       
     
      