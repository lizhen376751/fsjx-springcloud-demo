package fegin.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 获取用户信息
 */
@FeignClient(name = "sysapi", url = "localhost:8381")
@RequestMapping(value = "/sys/user")
public interface SysClient {
    @PostMapping(value = "/login")
    String getUser(@RequestParam("userName") String userName, @RequestParam("plainPassword") String plainPassword);
}
