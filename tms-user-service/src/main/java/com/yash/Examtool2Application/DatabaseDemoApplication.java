package com.yash.Examtool2Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DatabaseDemoApplication {

/*	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

}
