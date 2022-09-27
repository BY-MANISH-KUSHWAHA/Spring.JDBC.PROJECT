package com.spring.boot.jdbc.Spring.Boot.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public List<Player> getAllPlayers(){
        String getPlayerQuery = "SELECT * FROM Player";

        // JdbcTEMPLATE => query => Database => Request Set => Row  Mapped => Player.class => List<Object>
        // Row Mapper mapped class all data to make it as Object.
        return  jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayerByPID(int PID){
        String getPlayerByPIDQuery = "SELECT * FROM Player WHERE PID = ?";

        // JdbcTEMPLATE => query => ID is being substituted as a Primary Key => Database => Request Set => Row  Mapped => Player.class => List<Object>
        return  jdbcTemplate.queryForObject(getPlayerByPIDQuery,new BeanPropertyRowMapper<Player>(Player.class),new Object[]{PID});
    }

    public int insertPlayer(Player player){
        String insertPlayerQuery = "INSERT INTO Player VALUES(?,?,?,?,?,?)";
        // will return primary key.
        return  jdbcTemplate.update(insertPlayerQuery, new Object[]{player.getPid(),player.getName(),player.getAge(),player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation()});
    }


}
