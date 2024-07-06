package com.alura.literatura;

import com.alura.literatura.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//spring.datasource.url=jdbc:mysql://localhost:3306/literatura
//spring.datasource.username=postgres
//spring.datasource.password=postgres
//spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	@Autowired
	private MainController mainController;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primer proyecto Spring sin Web"); // eliminado en el video 1.3
		mainController.run();
	}




}
