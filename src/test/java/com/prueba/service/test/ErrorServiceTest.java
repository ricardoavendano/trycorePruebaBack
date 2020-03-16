package com.prueba.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.prueba.datatransfer.Error;
import com.prueba.exception.AutenticacionFallidaException;
import com.prueba.exception.EstadoCompraException;
import com.prueba.exception.UsuarioNoExisteException;
import com.prueba.service.ErrorService;

@RunWith(MockitoJUnitRunner.class)
public class ErrorServiceTest {

	@InjectMocks
	private ErrorService errorService;
	
	@Test
	public void estadoCompraException() {
		Error error = errorService.getError(new EstadoCompraException(Long.valueOf(1)));
		assertTrue(error.getCode().equals("EstadoCompraException001"));
	}	
	
	@Test
	public void usuarioNoExisteException() {
		Error error = errorService.getError(new UsuarioNoExisteException());
		assertTrue(error.getCode().equals("UsuarioNoExisteException001"));
	}
	
	@Test
	public void autenticacionFallidaException() {
		Error error = errorService.getError(new AutenticacionFallidaException());
		assertTrue(error.getCode().equals("AutenticacionFallidaException001"));
	}
	
	
	@Test
	public void errorDesconocido() {
		Error error = errorService.getError(new Exception());
		
		assertTrue(error.getCode().equals("Libro001"));
		assertTrue(error.getDescription().equals("Unknown Error"));
	}
	
	
}
