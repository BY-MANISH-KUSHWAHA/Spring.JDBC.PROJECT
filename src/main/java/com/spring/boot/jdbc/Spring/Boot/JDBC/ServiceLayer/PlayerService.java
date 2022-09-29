package com.spring.boot.jdbc.Spring.Boot.JDBC.ServiceLayer;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerRepository;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerSpringDataRepository;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    PlayerSpringDataRepository repo;

    public List<Player> getAllPlayerFromDB(){

        //return repo.findAll().stream().filter(p -> p.getAge()<30).collect(Collectors.toList());
        return repo.findAll();
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

    // addPlayer
    public Player addPlayer(Player player){
        return repo.save(player);
    }


    // UpdatePlayer
    public Player updatePlayerById(@PathVariable("pid") int pid,Player player){
        Optional<Player> p = repo.findById(pid);
        if(p.isEmpty())  throw new RuntimeException("Payer with Id="+pid+" not found.");
        return repo.save(player);
    }


    // Partial Player update
    public Player patchPlayerById(@PathVariable("pid") int pid, Map<String,Object> partialPlayer){
        Optional<Player> player = repo.findById(pid); // To overcome the null pointer exception
        if(player.isPresent()){
            // iterate through map and make desired changes in player object
            partialPlayer.forEach((key,value) -> {
                if(key.toUpperCase().equals("DOB")){
                    player.get().setDob(Date.valueOf((String) value));
                }
                else{
                    System.out.println("Key:"+key+", Value:"+value);
                    // Find the field of the object (Expect two Arguments, Class and Key ) {return the field object }
                    Field field = ReflectionUtils.findField(Player.class,key); // field object
                    ReflectionUtils.makeAccessible(field);// All fields are private, So using this we make all variable accessible
                    ReflectionUtils.setField(field,player.get(),value);// using field and value change the value in player object
                }

            });
        }
        else{
            throw new RuntimeException("Payer with Id="+pid+" not found.");
        }
        return repo.save(player.get());
    }


    // partial update (Using queries/entity)
    @Transactional
    public void updateNationality(int pid,String nationality){
        Optional<Player> p = repo.findById(pid);
        if(p.isEmpty())  throw new RuntimeException("Payer with Id="+pid+" not found.");
        repo.updateNationality(pid,nationality);
    }

    // delete player
    public void deletePlayerById(int pid){
        Optional<Player> p = repo.findById(pid);
        if(p.isEmpty())  throw new RuntimeException("Payer with Id="+pid+" not found.");
        repo.delete(p.get());
    }


}
