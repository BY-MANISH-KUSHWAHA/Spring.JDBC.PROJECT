package com.spring.boot.jdbc.Spring.Boot.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public List<Player> getAllPlayers(){
        String getPlayerQuery = "SELECT * FROM Player";

        // Row Mapper
        return  jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
    }
}
