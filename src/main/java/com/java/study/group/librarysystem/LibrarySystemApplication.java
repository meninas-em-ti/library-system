package com.java.study.group.librarysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication
public class LibrarySystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibrarySystemApplication.class, args);

	}

	@Bean
	public ViewResolver htmlViewResolver(ITemplateResolver templateResolver) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		SpringTemplateEngine engine = new SpringTemplateEngine();

		engine.addDialect(new Java8TimeDialect());
		engine.setTemplateResolver(templateResolver);

		resolver.setTemplateEngine(engine);
		return resolver;
	}

}
