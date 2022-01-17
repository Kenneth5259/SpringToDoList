package com.kenneth.todobackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
  @Bean
  public Docket listApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .groupName("Lists")
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.kenneth.todobackend.todolist.ToDoList"))
      .paths(PathSelectors.ant("/list/**"))
      .build();
  }
  @Bean
  public Docket itemApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .groupName("Items")
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.kenneth.todobackend.todolist.ListItem"))
      .paths(PathSelectors.ant("/item/**"))
      .build();
  }
}
