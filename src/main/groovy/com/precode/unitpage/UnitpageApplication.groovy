package com.precode.unitpage

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
<<<<<<< HEAD

=======
>>>>>>> 796f582c17cfaacb2cc228c3e7391da44db2dea1
@ComponentScan(basePackages = "com.precode.unitpage")
class UnitpageApplication extends SpringBootServletInitializer {

	static void main(String[] args) {
		SpringApplication.run (UnitpageApplication, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.sources(UnitpageApplication)
	}
	
}
