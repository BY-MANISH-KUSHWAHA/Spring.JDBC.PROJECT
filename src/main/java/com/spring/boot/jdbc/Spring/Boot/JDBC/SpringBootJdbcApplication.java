package com.spring.boot.jdbc.Spring.Boot.JDBC;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.sql.Date;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

//	@Autowired
//	PlayerDAO dao;

	// JPA
	@Autowired
	PlayerRepository playerRepository;

	@Override
	public void run(String... args) throws Exception {

//		System.out.println("--------------GET PLAYERS INFO---------------------\n");
//		System.out.println(dao.getAllPlayers());
//		System.out.println("-------------- GET PLAYER BY PID ---------------------\n");
//		System.out.println(dao.getPlayerByPID(2));
//		System.out.println("-------------- INSERT PLAYER ---------------------\n");
//		System.out.println(dao.insertPlayer(new Player(10,"Name",13,"Indian",new Date(System.currentTimeMillis()),5)));
//		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
//		String input = args.length == 0 ? "2000-02-11" : args[0];
//		System.out.println(dao.insertPlayer(new Player(11,"Manish",22,"Indian",ft.parse(input),5)));
//		System.out.println("--------------Updated GET PLAYERS INFO---------------------\n");
//		System.out.println(dao.getAllPlayers());
//
//		System.out.println("--------------Updated A PLAYER INFO using Method---------------------\n");
//		System.out.println(dao.updatePlayer(new Player(11,"Manish Kumar Kushwaha",29,"Ireland",ft.parse(input),8)));
//
//		System.out.println("--------------Updated GET PLAYERS INFO---------------------\n");
//		System.out.println(dao.getAllPlayers());
//
//		System.out.println("--------------Delete A PLAYER From Player Table---------------------\n");
//		System.out.println(dao.deletePlayer(2));
//
//		System.out.println("--------------Custom ROW MAPPER PLAYERS INFO---------------------\n");
//		System.out.println(dao.getAllPlayersUsingCustomRowMapper());


		//-------------------------- JPA -------------------------------------
		//-----------------  CRUD WITHOUT DATABASE QUERYIES -----------------------------------

		// For log: spring.jpa.show-sql=true ==> add in properties

		// CREATE
//		String input = args.length == 0 ? "2000-02-11" : args[0];
//		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
//		playerRepository.insertPlayer(new Player("Manish Kumar Kushwaha",29,"Ireland",ft.parse(input),8));
//			// new Date from SQL
//		playerRepository.insertPlayer(new Player("ZAYA",29,"INDIA",Date.valueOf("2000-03-02"),8));
//		playerRepository.insertPlayer(new Player("Manish Kumar Kushwaha",29,"Ireland",ft.parse(input),8));
//
//		// READ
//		System.out.println("Player By ID:" + playerRepository.getPlayerById(1));
//
//		// Upadte -> Add PID value
//		playerRepository.updatePlayer(new Player(2,"Kumar Kushwaha",29,"India",ft.parse(input),8));
//		System.out.println("Player By ID AFTER UPDATE:" + playerRepository.getPlayerById(2));
//
//		// Delete
//		playerRepository.deleteById(2); // Check this table on H2 console
//
//		// Get All Players
//		System.out.println("All Player List:"+playerRepository.getAllPlayer());




	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}


}
