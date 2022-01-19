/**
 *
 */
package com.example.squadio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SQUADIO")
                        .version("VERSION 1")
                        .description("API documentation for SQUADIO APIS TEST")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().name("BENSON KARIUKI").email("bensonkariuki710@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }

}
