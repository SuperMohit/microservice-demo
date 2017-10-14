package com.search.engine1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.search.engine1"))              
          .paths(PathSelectors.any())
          .build()
          .apiInfo(metadata());                                           
    }
    

    private ApiInfo metadata() {
      return new ApiInfoBuilder()
        .title("Movie Search API")
        .description("Text Search into Movies Database.")
        .version("1.0")
        .contact(new Contact("Mohit", "mohit.com", "mohit@gmail.com"))
        .build();
    }
    
}

