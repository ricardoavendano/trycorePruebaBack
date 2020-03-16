package com.prueba.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.prueba.datatransfer.Error;
import com.prueba.exception.AutenticacionFallidaException;
import com.prueba.exception.EstadoCompraException;
import com.prueba.exception.UsuarioNoExisteException;
@Service
public class ErrorService {

	public Error getError(Exception e) {

		if (e instanceof EstadoCompraException) {

			return new Error("EstadoCompraException001", "No hay compras registradas con el id: "+ ((EstadoCompraException) e).getId());

		}
		if (e instanceof UsuarioNoExisteException) {

			return new Error("UsuarioNoExisteException001", "Usuario no encontrado");

		}
		if (e instanceof AutenticacionFallidaException) {

			return new Error("AutenticacionFallidaException001", "Autenticacion fallida, vuelva a intentarlo");

		}		
										
		Map<String, String> params = new HashMap<>();
		params.put("Exception", e.getClass() + "-" + e.getMessage());
		params.put("Time", LocalDateTime.now().toString());

		return new Error("Libro001", "Unknown Error");
	}
}
