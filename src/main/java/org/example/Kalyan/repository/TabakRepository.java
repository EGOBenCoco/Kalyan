package org.example.Kalyan.repository;

import org.example.Kalyan.models.Tabak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TabakRepository extends JpaRepository<Tabak,Integer>
{
/*    List<Tabak> findAllByName(String name);
    List<Tabak> findByBrend(String brend);*/
}
