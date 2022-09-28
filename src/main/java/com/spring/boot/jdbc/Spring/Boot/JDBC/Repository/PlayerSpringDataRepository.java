package com.spring.boot.jdbc.Spring.Boot.JDBC.Repository;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer>
{

    public List<Player> findByNationality(String Nationality);


}