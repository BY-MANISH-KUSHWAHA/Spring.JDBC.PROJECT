package com.spring.boot.jdbc.Spring.Boot.JDBC.Repository;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    // READ
    public List<Player> getAllPlayers(){
        String getPlayerQuery = "SELECT * FROM Player";

        // JdbcTEMPLATE => query => Database => Request Set => Row  Mapped => Player.class => List<Object>
        // Row Mapper mapped class all data to make it as Object.
        return  jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
    }

    // READ
    public Player getPlayerByPID(int PID){
        String getPlayerByPIDQuery = "SELECT * FROM Player WHERE PID = ?";

        // JdbcTEMPLATE => query => ID is being substituted as a Primary Key => Database => Request Set => Row  Mapped => Player.class => List<Object>
        return  jdbcTemplate.queryForObject(getPlayerByPIDQuery,new BeanPropertyRowMapper<Player>(Player.class),new Object[]{PID});
    }

    // INSERTING a new Row
    public int insertPlayer(Player player){
        String insertPlayerQuery = "INSERT INTO Player VALUES(?,?,?,?,?,?)";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(insertPlayerQuery, new Object[]{player.getPid(),player.getName(),player.getAge(),player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation()});
    }

    // UPDATE a row
    public int updatePlayer(Player player){
        String updatePlayerQuery = "UPDATE Player "+
                                    "SET NAME = ?, AGE = ?, Nationality = ?, DOB = ?, Designation = ?"+
                                    "Where PID = ?";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(updatePlayerQuery,
                new Object[]{player.getName(),
                player.getAge(),
                player.getNationality(),
                new Timestamp(player.getDob().getTime()),
                player.getDesignation(),
                player.getPid()} // Same as Sequence
        );
    }

    // Delete A player (row)
    public int deletePlayer(int PID){
        String deletePlayerQuery = "DELETE FROM Player WHERE PID = ?;";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(deletePlayerQuery, PID);
    }




    // -------------- Using Custom RowMapper Class
    private static final class PlayerMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setPid(rs.getInt("PID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("AGE"));
            player.setNationality(rs.getString("Nationality"));
            String input = rs.getString("Dob");
            player.setDob(Date.valueOf(input));
            player.setDesignation(rs.getInt("Designation"));

            return player;

        }
    }
    public List<Player> getAllPlayersUsingCustomRowMapper(){
        String getPlayerQuery = "SELECT * FROM Player";

        // JdbcTEMPLATE => query => Database => Request Set => Row  Mapped => Player.class => List<Object>
        // Row Mapper mapped class all data to make it as Object.
        return  jdbcTemplate.query(getPlayerQuery,new PlayerMapper());
    }




}
