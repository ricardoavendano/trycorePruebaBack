package com.prueba.imp;

import java.util.Base64;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.datatransfer.UsuarioDTO;
import com.prueba.domain.Usuario;
import com.prueba.exception.AutenticacionFallidaException;
import com.prueba.exception.UsuarioNoExisteException;
import com.prueba.repository.UsuarioRepository;
import com.prueba.service.UsuarioService;

import fj.data.Either;

@Service
public class UsuarioServiceImp implements UsuarioService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImp.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;	
	
	public Either<Exception, UsuarioDTO> validarAutenticacionUsuario(UsuarioDTO usuarioDTO) {
		try {
			Optional<Usuario> usuario = usuarioRepository.findById(usuarioDTO.getIdUsuario());

			if (!usuario.isPresent()) {
				throw new UsuarioNoExisteException();
			} else {
				
				String encodedString = Base64.getEncoder().encodeToString(usuarioDTO.getPassword().getBytes());
				if(encodedString.equals(usuario.get().getPassword())) {
					
					usuarioDTO.setPassword(usuario.get().getPassword());
					return Either.right(usuarioDTO);
				}else {
					throw new AutenticacionFallidaException();
				}
				
			}

		} catch (AutenticacionFallidaException | UsuarioNoExisteException  e) {
			LOGGER.error("UsuarioServiceImp:validarAutenticacionUsuario",e);
			return Either.left(e);
			
		} catch (Exception e) {

			return Either.left(e);
		}
	}
}
