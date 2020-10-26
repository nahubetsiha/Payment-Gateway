package com.pm.paymentgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Payment Gateway")
                        .description("Credit card verification and payment transaction service")
                        .version("0.1")
                        .license("MIU Project Management")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pm.paymentgateway.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
