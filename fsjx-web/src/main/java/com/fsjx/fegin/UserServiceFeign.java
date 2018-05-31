package com.fsjx.fegin;


import com.fsjx.hystrixfallbackmethod.HystrixFallBack;
import com.fsjx.user.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;


/**
 * 客户端调用工具
 * Created by lizhen on 2018\5\29 0029.
 */
//value需要指定服务名称，fallback服务不可用的情况下，走的方法
@FeignClient(value = "service-user", fallback = HystrixFallBack.class)
public interface UserServiceFeign extends UserService {

}
