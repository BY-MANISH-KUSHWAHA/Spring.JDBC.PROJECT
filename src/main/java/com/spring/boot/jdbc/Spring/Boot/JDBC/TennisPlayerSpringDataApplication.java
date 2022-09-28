package com.spring.boot.jdbc.Spring.Boot.JDBC;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Date;
@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner
{
    @Autowired
    PlayerSpringDataRepository playerRepository;
    private Logger logger = LoggerFactory.getLogger((this.getClass()));
    public static void main(String[] args)
    {
        SpringApplication.run(TennisPlayerSpringDataApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        logger.info("\n Inserting a player \n", playerRepository.save(new Player("Shubham",23,"India", Date.valueOf("2000-01-05"),1)));
        logger.info("\n Inserting a player \n", playerRepository.save(new Player("Arjun",24,"Pakistan", Date.valueOf("1990-01-05"),2)));
        logger.info("\n Inserting a player \n", playerRepository.save(new Player("Manish",21,"USA", Date.valueOf("2001-01-05"),3)));
        //
        logger.info("\n Findin the player by ID \n", playerRepository.findById(1));
        logger.info("\n Delete By ID method \n");
        playerRepository.deleteById(1);
        logger.info("\n Find All method \n",playerRepository.findAll());
    }
}