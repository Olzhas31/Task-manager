package com.example.task_manager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
        .group("public-apis")
        .pathsToMatch("/**")
        .build();
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI().info(
        new Info()
            .title("Task-manager Service API")
            .description("Task-manager Service API")
            .contact(new Contact()
                .name("Olzhas Suleimenov")
                .email("suleimenov97@gmail.com")
            )
            .version("1.0")
    );
  }
}