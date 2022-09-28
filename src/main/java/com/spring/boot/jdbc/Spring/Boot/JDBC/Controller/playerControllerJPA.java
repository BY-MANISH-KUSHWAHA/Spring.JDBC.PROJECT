package com.spring.boot.jdbc.Spring.Boot.JDBC.Controller;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerDAO;
import com.spring.boot.jdbc.Spring.Boot.JDBC.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class playerControllerJPA {

    @Autowired
    PlayerService service;

    @GetMapping(value = "/jpa/allplayers")
    public List<Player> getAllPlayer(){
        return service.getAllPlayerFromDB();
    }

    @GetMapping(value = "/jpa/playerbyid/{pid}")
    public Player getPlayerByID(@PathVariable("pid") int PID){
        return service.getPlayerByIDFromDBJson(PID); // PathVariable Define in Controller
    }

    @GetMapping(value = "/jpa/playerbyid-1/{pid}")
    public Player getPlayer_PV_ByID(@PathVariable("pid") int PID){
        return service.getPlayerByID_PV_FromDBJson(PID); // PATH-VARIABLE define inside Service
    }

    @GetMapping("/jpa/playerbyid")
    public Player getPlayerByPIDFromDBJson1(@RequestParam(name="pid", required = false, defaultValue = "0") int PID)
    {
        return service.getPlayerByIDFromDBJson(PID);
    }
}
