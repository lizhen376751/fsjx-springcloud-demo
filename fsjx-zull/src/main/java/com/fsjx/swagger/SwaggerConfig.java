package com.fsjx.swagger;


import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by lizhen on 2018/5/3.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.fsjx"))
//                .paths(PathSelectors.any())
//                .build();
//    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("福生佳信  接口API文档")
                .description("公共数据服务接口文档说明")
                .termsOfServiceUrl("http://localhost:8081")
                .contact(new Contact("lizhen", "", "724577807@qq.com"))
                .version("1.0")
                .build();
    }


}
