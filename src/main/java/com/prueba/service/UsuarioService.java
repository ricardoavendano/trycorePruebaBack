package com.prueba.service;

import org.springframework.stereotype.Service;

import com.prueba.datatransfer.UsuarioDTO;

import fj.data.Either;

@Service
public interface UsuarioService {
	
	public Either<Exception, UsuarioDTO> validarAutenticacionUsuario(UsuarioDTO usuarioDTO);
}
