package com.ticketone.ticketone;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class TicketoneApplication {

	public static void main(String[] args) {
		log.info("Web Application \"TicketOne\" loading");
		SpringApplication.run(TicketoneApplication.class, args);
		log.info("Web Application \"TicketOne\" started");
	}

	@Bean
	public OpenAPI beOpenAPI() {
		return new OpenAPI()
				.components(new Components()
						.addSecuritySchemes("bearer-key",
								new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
										.in(SecurityScheme.In.HEADER).name("Authorization")))

				.info(new Info()
						.title("TicketOne Resource Services")
						.version("1.0.0")
						.description("TicketOne Resource Service")
						.termsOfService("https://www.plantict.it/")
						.license(new License().name("(C) Copyright - Plant ICT S.r.l.").url("https://www.plantict.it/"))
				)

				.addSecurityItem(
						new SecurityRequirement().addList("bearer-key", Arrays.asList("read", "write")));

	}

}
