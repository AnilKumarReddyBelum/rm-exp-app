package com.ac.rmexpapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.ac.rmexpapp.repo.ExpenseRepository;


@SpringBootApplication
@ComponentScan(basePackages = { "com.ac.rmexpapp.controller",
		"com.ac.rmexpapp.model", "com.ac.rmexpapp.model",
		"com.ac.rmexpapp.service" })
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "com.ac.rmexpapp.repo" })
@EntityScan(basePackages = { "com.ac.rmexpapp.model" })
public class RmexpappApplication extends SpringBootServletInitializer {

	@Bean
	CommandLineRunner init(ExpenseRepository expenseRepository) {
		return (String... args) -> {/*
			Expense expense = new Expense();
			expense.setOwner("Anil");
			expense.setCost(new BigDecimal("150"));
			expenseRepository.save(expense);
		*/};
	}

	@Profile("local")
	@Bean(destroyMethod = "shutdown")
	public EmbeddedDatabase dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(RmexpappApplication.class, args);
	}
}
