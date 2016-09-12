package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootIssue6871Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIssue6871Application.class, args);
	}

	@Bean
	public PlatformTransactionManager tm() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.url("jdbc:h2:mem:tst;DB_CLOSE_DELAY=-1")
				.username("sa")
				.password("")
				.build();
	}

	@Bean
	public SomeServiceWithTransact someServiceWithTransact() {
		return new SomeServiceWithTransact();
	}

	@Bean
	public SomeServiceNoTransact someServiceNoTransact() {
		return new SomeServiceNoTransact();
	}
}
