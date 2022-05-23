package com.api.hospital.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.hospital"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().contact(new Contact("周士钰", "http://localhost/", "568261517@qq.com"))
                        .title("医院API接口 - 在线文档")
                        .description("欢迎使用API接口访问Json数据内容，如果有问题，请联系我们。")
                        .version("1.0.0")
                        .build();
    }
}