package com.api.market.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.securitySchemes(Arrays.asList(apiKey()))
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.api.market.web.controller"))
			.build()
			.apiInfo(apiDetails());	
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Market API",
				"This is the API for manage your market.",
				"API",
				"Terms of service",
				new Contact("Julian Castañeda", "www.julian-castaneda.com", "julian.castaneda@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

	private ApiKey apiKey(){
		return new ApiKey("JWT", "Authorization", "header");
	}

}
