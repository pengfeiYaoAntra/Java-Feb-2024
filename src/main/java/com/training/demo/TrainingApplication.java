package com.training.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext  = SpringApplication.run(TrainingApplication.class, args);
		String[] beans = configurableApplicationContext.getBeanDefinitionNames();
		for(String bean : beans){
			System.out.println(bean);
		}

	}


}
