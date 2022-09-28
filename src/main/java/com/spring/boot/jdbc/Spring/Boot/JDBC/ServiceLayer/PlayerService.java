package com.spring.boot.jdbc.Spring.Boot.JDBC.ServiceLayer;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerRepository;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    PlayerSpringDataRepository repo;

    public List<Player> getAllPlayerFromDB(){

        return repo.findAll().stream().filter(p -> p.getAge()<30).collect(Collectors.toList());
    }

    public Player getPlayerByIDFromDBJson(@PathVariable("pid") int pid){
        Optional<Player> player = repo.findById(pid);
        if(player.isPresent())  return player.get();
        else throw new RuntimeException("Payer with Id="+pid+" not found.");
        //return null;
    }

    public Player getPlayerByID_PV_FromDBJson(@PathVariable int pid){
        Optional<Player> player = repo.findById(pid);
        if(player.isPresent())  return player.get();
        else throw new RuntimeException("Payer with Id="+pid+" not found.");
        //return null;
    }

}
