package br.com.santander.agenda.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.models.auth.In;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket agendaApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(Arrays.asList(new ApiKey("Token access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.santander.agenda"))
				.paths(PathSelectors.ant("/**"))
				.build();
	}
}
