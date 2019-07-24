package com.yancey.smmall.management.thirdpartybrands.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 16:45
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yancey.smmall.management.thirdpartybrands.web.controller"))
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("神马商城后台管理系统")
                .description("神马商城后台管理配置系统")
                .contact(new Contact("zyb",null,"zyb284629791@outlook.com"))
                .version("1.0.0")
                .build();
    }
}
