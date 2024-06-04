package com.jwt.jwt.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("JWT API Documentation")
                        .description("JWT token üretmek için yazılan servis")
                        .version("v1.0")
                        .license(new License().name("İbrahim BAYRAMLI").url("https://github.com/ibrahimbayramli/spring-jwt-token")));
    }
}
