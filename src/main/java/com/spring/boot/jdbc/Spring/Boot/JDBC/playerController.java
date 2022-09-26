package com.spring.boot.jdbc.Spring.Boot.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class playerController {

    @Autowired
    PlayerDAO dao;

    @GetMapping(value = "/players")
    public List<Player> getAllPlayerFromDB(){
        return dao.getAllPlayers();
    }

    @GetMapping(value = "/players-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Player> getAllPlayerFromDBJson(){
        return getAllPlayerFromDB();
    }

}
