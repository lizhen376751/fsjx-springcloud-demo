package fegin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
//开启客户端调用工具
@EnableFeignClients
public class FeginApp {
    public static void main(String[] args) {
        SpringApplication.run(FeginApp.class, args);
    }

}