package com.example.ToDoApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Config {
    @Bean
    public PageRequest rolePageable() {
        return PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "roleName"));
    }

    @Bean
    public PageRequest userPageable() {
        return PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "username"));
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.ToDoApp.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo Book API")
                .description("API for managing books")
                .version("1.0")
                .build();
    }

}
