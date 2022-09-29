package com.spring.boot.jdbc.Spring.Boot.JDBC.Controller;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerDAO;
import com.spring.boot.jdbc.Spring.Boot.JDBC.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/jpa/playerbyid-2/{pid}")
    public Player getPlayer_PV_SAME_NAME_ByID(@PathVariable int pid){
        return service.getPlayerByID_PV_FromDBJson(pid); // PATH-VARIABLE define inside Service and Use same name for path and dependent varaiable(id)
    }

    @GetMapping("/jpa/playerbyid")
    public Player getPlayerByPIDFromDBJson1(@RequestParam(name="pid", required = false, defaultValue = "0") int PID)
    {
        return service.getPlayerByIDFromDBJson(PID);
    }

    // POST
    @PostMapping("/addPlayer")
    //@RequestMapping(method = RequestMethod.POST)
    public Player addPlayer(@RequestBody Player p){
        return service.addPlayer(p);
    }

    // Upadte Player complete filed
    @PutMapping("/updatePlayer/{pid}")
    public Player updatePlayer(@PathVariable int pid,@RequestBody Player player){
        return service.updatePlayerById(pid,player);
    }

    // Partial Player update
    @PatchMapping("/patchPlayer/{pid}")
    public Player patchPlayer(@PathVariable int pid,@RequestBody Map<String,Object> playerPartialDetails){
        return service.patchPlayerById(pid,playerPartialDetails);
    }

    // updating with Query (Define in PlayerSpringDataRepos..)
    @PatchMapping("/patchPlayer/{pid}/nationality")
    public void patchNationality(@PathVariable int pid, @RequestBody String nationality){
        service.updateNationality(pid,nationality);
    }

    // delete player
    @DeleteMapping("/deletePlayer/{pid}")
    public void deletePlayer(@PathVariable int pid){
        service.deletePlayerById(pid);
    }
    // instead of making different path we can do /player for all delete,add,patch,update etc.
}
