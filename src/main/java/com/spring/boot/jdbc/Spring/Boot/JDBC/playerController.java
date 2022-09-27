package com.spring.boot.jdbc.Spring.Boot.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/playersByPID2")
    public Player getPlayerByPIDFromDBJson2(Parms parameters)
    {
        //implement the setter and getter of the Params class.
        return dao.getPlayerByPID(Integer.parseInt(parameters.pid));
    }

    // -------------------------------- END Get Call with Parameters -----------------------------------


}
