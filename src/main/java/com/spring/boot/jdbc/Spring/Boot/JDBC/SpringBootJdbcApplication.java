package com.spring.boot.jdbc.Spring.Boot.JDBC;

import com.fasterxml.jackson.core.JsonEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	@Autowired
	PlayerDAO dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------------GET PLAYERS INFO---------------------\n");
		System.out.println(dao.getAllPlayers());
		System.out.println("-------------- GET PLAYER BY PID ---------------------\n");
		System.out.println(dao.getPlayerByPID(2));
		System.out.println("-------------- INSERT PLAYER ---------------------\n");
		System.out.println(dao.insertPlayer(new Player(10,"Name",13,"Indian",new Date(System.currentTimeMillis()),5)));
		System.out.println("--------------GET PLAYERS INFO---------------------\n");
		System.out.println(dao.getAllPlayers());

	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}


}
