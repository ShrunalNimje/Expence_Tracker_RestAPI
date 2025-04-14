package my.mood.ExpenceTracker.Expence_Tracker.OpenAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Expence Tracker API")
						.description("A RestFul API for managing expences inluding Create, Update, Delete and Retrieve")
						.version("1.0"))
				
				.addSecurityItem(new SecurityRequirement().addList("basicAuth"))
				
				.components(new Components()
	                     .addSecuritySchemes("basicAuth",
	                         new SecurityScheme()
	                             .type(SecurityScheme.Type.HTTP)
	                             .scheme("basic")));
	}
}
