package com.digitization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Configuration
@ImportResource(
		locations = {"classpath:/app.xml"}
)
//public class DigitizationApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DigitizationApplication.class, args);
//	}
//
//}
public class DigitizationApplication extends SpringBootServletInitializer {
	public DigitizationApplication() {
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(new Class[]{DigitizationApplication.class});
	}

	public static void main(String[] args) {
		SpringApplication.run(DigitizationApplication.class, args);
	}

}
