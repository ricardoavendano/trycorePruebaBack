package com.prueba.service;

import org.springframework.stereotype.Service;

import com.prueba.datatransfer.PersonaResponseDTO;
import com.prueba.datatransfer.PlanetaResponseDTO;

import fj.data.Either;

@Service
public interface ControladorService {

	public Either<Exception, String> clickPlaneta(PlanetaResponseDTO planetaResponseDTO);
	
	public Either<Exception, String> clickPersona(PersonaResponseDTO personaResponseDTO);
}
