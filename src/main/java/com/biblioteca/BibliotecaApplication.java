package com.biblioteca;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;


@ComponentScan(basePackages = "com.biblioteca")
@SpringBootApplication
@Controller
public class BibliotecaApplication extends SpringBootServletInitializer {
/*
	@RequestMapping("/")
	@ResponseBody
	public String ola() {
		return "Ola, ";
	}*/

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}
	
	

}
