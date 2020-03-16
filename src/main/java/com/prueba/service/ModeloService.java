package com.prueba.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.prueba.datatransfer.PersonaAdpDTO;
import com.prueba.datatransfer.PersonaResponseDTO;
import com.prueba.datatransfer.PlanetaAdpDTO;
import com.prueba.datatransfer.PlanetaResponseDTO;

import fj.data.Either;

@Service
public interface ModeloService {

	public Either<Exception, String> cargarModelo() throws JsonParseException, JsonMappingException, IOException;
	
	public Either<Exception, List<PlanetaAdpDTO>> cargarPlaneta();
	
	public Either<Exception, List<PersonaAdpDTO>> cargarPersona();
	
	public Either<Exception, List<PersonaResponseDTO>> cargarPersonaResponse();
	
	public Either<Exception, List<PlanetaResponseDTO>> cargarPlanetaResponse();
	
	public Either<Exception, PlanetaResponseDTO> cargarPlanetaResponseId(Long id);
	
	public Either<Exception, List<PersonaResponseDTO>> cargarPersonaResponseId(Long id);
}
