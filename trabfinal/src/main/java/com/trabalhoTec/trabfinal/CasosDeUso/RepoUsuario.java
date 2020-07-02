package com.trabalhoTec.trabfinal.CasosDeUso;

import java.util.List;

import com.trabalhoTec.trabfinal.Entities.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends CrudRepository<Usuario, String> {
    List<Usuario> findByNome(String nome);
    List<Usuario> findAll();
}