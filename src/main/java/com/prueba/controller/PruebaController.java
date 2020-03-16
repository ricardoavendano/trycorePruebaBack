package com.prueba.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.datatransfer.Error;
import com.prueba.datatransfer.PersonaAdpDTO;
import com.prueba.datatransfer.PersonaResponseDTO;
import com.prueba.datatransfer.PlanetaAdpDTO;
import com.prueba.datatransfer.PlanetaResponseDTO;
import com.prueba.datatransfer.UsuarioDTO;
import com.prueba.service.ErrorService;
import com.prueba.service.ModeloService;
import com.prueba.service.UsuarioService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping
@RestController
@Controller
public class PruebaController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModeloService modeloService;

	@Autowired
	private ErrorService errorService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> validarLogin(@RequestBody UsuarioDTO usuarioDTO) {

		Either<Exception, UsuarioDTO> resultEither = usuarioService.validarAutenticacionUsuario(usuarioDTO);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/cargar/modelo")
	public ResponseEntity<?> cargarModelo() throws IOException {
		
		Either<Exception, String> resultEither = modeloService.cargarModelo();

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/cargar/planeta")
	public ResponseEntity<?> cargarPlaneta() throws IOException {
		
		Either<Exception, List<PlanetaAdpDTO>> resultEither = modeloService.cargarPlaneta();

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/cargar/persona")
	public ResponseEntity<?> cargarPersona(){
		
		Either<Exception, List<PersonaAdpDTO>> resultEither = modeloService.cargarPersona();

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/cargar/personaRS")
	public ResponseEntity<?> cargarPersonaResponse() {
		
		Either<Exception, List<PersonaResponseDTO>> resultEither = modeloService.cargarPersonaResponse();

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/cargar/personaRS/{idPlaneta}")
	public ResponseEntity<?> cargarPlanetaPorPersona(@PathVariable Long idPlaneta) {
		
		Either<Exception, PlanetaResponseDTO> resultEither = modeloService.cargarPlanetaResponseId(idPlaneta);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/cargar/planetaRS")
	public ResponseEntity<?> cargarPlanetaResponse(){
		
		Either<Exception, List<PlanetaResponseDTO>> resultEither = modeloService.cargarPlanetaResponse();

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/cargar/planetaRS/{idPlaneta}")
	public ResponseEntity<?> cargarPersonaPorPlaneta(@PathVariable Long idPlaneta){
		
		Either<Exception, List<PersonaResponseDTO>> resultEither = modeloService.cargarPersonaResponseId(idPlaneta);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
