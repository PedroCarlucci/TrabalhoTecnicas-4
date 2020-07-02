package com.trabalhoTec.trabfinal.CasosDeUso;

import java.util.List;

import com.trabalhoTec.trabfinal.Entities.Dungeon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDungeon extends CrudRepository<Dungeon, String> {
    List<Dungeon> findByNome(String nome);
    List<Dungeon> findAll();
}
