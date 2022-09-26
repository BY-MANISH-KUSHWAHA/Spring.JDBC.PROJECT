package com.spring.boot.jdbc.Spring.Boot.JDBC;

import com.fasterxml.jackson.core.JsonEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	@Autowired
	PlayerDAO dao;

	@Override
	public void run(String... args) throws Exception {

		System.out.println(dao.getAllPlayers());

	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}


}
