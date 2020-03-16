package com.prueba.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

}
