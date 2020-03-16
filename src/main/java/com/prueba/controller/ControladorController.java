package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.datatransfer.Error;
import com.prueba.datatransfer.PersonaResponseDTO;
import com.prueba.datatransfer.PlanetaResponseDTO;
import com.prueba.service.ControladorService;
import com.prueba.service.ErrorService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping
@RestController
@Controller
public class ControladorController {
	
	@Autowired
	private ControladorService controladorService;
	
	@Autowired
	private ErrorService errorService;

	@PostMapping(value = "/planeta/click")
	public ResponseEntity<?> clickPlaneta(@RequestBody PlanetaResponseDTO planetaResponseDTO) {

		Either<Exception, String> resultEither = controladorService.clickPlaneta(planetaResponseDTO);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/persona/click")
	public ResponseEntity<?> clickPersona(@RequestBody PersonaResponseDTO personaResponseDTO) {

		Either<Exception, String> resultEither = controladorService.clickPersona(personaResponseDTO);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
