package ai.ineuron.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ai.ineuron.restcontroller")) // base package for the //
																						// restcontoller
				.paths(PathSelectors.regex("/api/tourist/.*")) // to specify the request path
				.build() // building the docket object
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());

	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Rohit", "www.ineuron.ai/course", "kumarrohit60060@gmail.com");

		return new ApiInfo("TouristInfo", "Gives Information about tourist Activities..", "3.5.Release.", "http:",
				contact, "GNU sBLIC", "http://apache.org/license/guru", Collections.emptyList());
	}
}
