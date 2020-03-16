package com.prueba.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.prueba.controller.PruebaController;
import com.prueba.datatransfer.Error;
import com.prueba.datatransfer.UsuarioDTO;
import com.prueba.exception.UsuarioNoExisteException;
import com.prueba.service.ErrorService;
import com.prueba.service.UsuarioService;

import fj.data.Either;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PruebaControllerTest {
	
	@InjectMocks
	private PruebaController pruebaController;
	
	@Mock
	private UsuarioService usuarioService;

	@Mock
	private ErrorService errorService;

	@Test
	public void validLogin() {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setIdUsuario("usuario1");
		usuarioDTO.setPassword("dXN1YXJpbzE=");
		
		Either<Exception, UsuarioDTO> resultEither = Either.right(usuarioDTO);
		Mockito.when(usuarioService.validarAutenticacionUsuario(usuarioDTO)).thenReturn(resultEither);
		
		ResponseEntity<?> res = pruebaController.validarLogin(usuarioDTO);
		
		assertEquals(200, res.getStatusCodeValue());
	}
	
	@Test
	public void noValidLogin() {
		
		Exception e = new UsuarioNoExisteException();
		Error error = errorService.getError(e);
		
		Either<Exception, UsuarioDTO> resultEither = Either.left(new UsuarioNoExisteException());
		
		Mockito.when(usuarioService.validarAutenticacionUsuario(Mockito.any())).thenReturn(resultEither);
		Mockito.when(errorService.getError(e)).thenReturn(error);
		
		ResponseEntity<?> res = pruebaController.validarLogin(Mockito.any());
		
		assertEquals(500, res.getStatusCodeValue());
	}
}
