package com.spring.boot.jdbc.Spring.Boot.JDBC.Repository;

import com.spring.boot.jdbc.Spring.Boot.JDBC.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer>
{

    public List<Player> findByNationality(String Nationality);

    @Modifying
    @Query("UPDATE Player p SET p.nationality = :nationality Where p.pid = :pid")
    void updateNationality(@Param("pid") int pid,@Param("nationality") String nationality );

}