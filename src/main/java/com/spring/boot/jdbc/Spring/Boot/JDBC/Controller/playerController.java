package com.spring.boot.jdbc.Spring.Boot.JDBC.Controller;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import com.spring.boot.jdbc.Spring.Boot.JDBC.Repository.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class playerController {

    @Autowired
    PlayerDAO dao;

    @GetMapping(value = "/allplayers")
    public List<Player> getAllPlayerFromDB(){
        return dao.getAllPlayers();
    }

    @GetMapping(value = "/allplayers-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Player> getAllPlayerFromDBJson(){
        return getAllPlayerFromDB();
    }



    // -------------------------------- Get Call with Parameters -----------------------------------
    // Blog: https://www.amitph.com/spring-requestparam-annotation/
    // Blog: https://dzone.com/articles/spring-boot-passing-parameters
    // Call: http://localhost:8080/playersByPID/2
    @GetMapping(value = "/playersByPID/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player getPlayerByPIDFromDBJson(@PathVariable("pid") String PID){
        System.out.println(PID);
        return dao.getPlayerByPID(Integer.parseInt(PID));
    }

    // Call: http://localhost:8080/playersByPID1?pid=2
    @GetMapping("/playersByPID1")
    public Player getPlayerByPIDFromDBJson1(@RequestParam(name="pid", required = false, defaultValue = "0") String PID)
    {
        return dao.getPlayerByPID(Integer.parseInt(PID));
    }

    public class Parms {
        private String pid; // accept multiple varaible with setter and getter
        public void setPID(String pid) {
            this.pid = pid;
        }

        public String getPID() {
            return pid;
        }

    }

    // Blog: https://lightrun.com/answers/springfox-springfox-using-getmapping-method--with-custom-java-class--parameter--and-parameter-show-error-type-in-swagge
    // This Actually used in Swagger
    @GetMapping("/playersByPID2")
    public Player getPlayerByPIDFromDBJson2(Parms parameters)
    {
        //implement the setter and getter of the Params class.
        System.out.println(parameters.pid);
        return new Player();
        //return dao.getPlayerByPID(Integer.parseInt(parameters.pid));
    }

    // -------------------------------- END Get Call with Parameters -----------------------------------

    //--------------------------------- Delete a Player ----------------------------------------------- ;
    @DeleteMapping(value = "/delete/{id}")
    public int deletePost(@PathVariable int id) {
        System.out.println(id);
        return dao.deletePlayer(id);
    }
    //--------------------------------- End Delete a Player -----------------------------------------------


}
