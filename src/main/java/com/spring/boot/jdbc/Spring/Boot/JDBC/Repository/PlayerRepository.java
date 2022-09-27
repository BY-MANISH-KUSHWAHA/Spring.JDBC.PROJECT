package com.spring.boot.jdbc.Spring.Boot.JDBC.Repository;


import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

// jda - Java persistence api
@Repository // To perform
@Transactional // to make transaction b/w java classes and database
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;


    public Player insertPlayer(Player player){
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player){
        return entityManager.merge(player);
    }

    public Player getPlayerById(int id){
        return entityManager.find(Player.class,id);
    }

    public void deleteById(int id){
        Player player = getPlayerById(id);
        entityManager.remove(player);
    }

    public List<Player> getAllPlayer(){
        TypedQuery<Player> getAll = entityManager.createNamedQuery("get-all-players", Player.class);

        return getAll.getResultList();

    }


}
