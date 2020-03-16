package com.prueba.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.datatransfer.PersonaResponseDTO;
import com.prueba.datatransfer.PlanetaResponseDTO;
import com.prueba.domain.ControladorPersona;
import com.prueba.domain.ControladorPlaneta;
import com.prueba.domain.Planeta;
import com.prueba.repository.ControladorPersonaRepository;
import com.prueba.repository.ControladorPlanetaRepository;
import com.prueba.repository.PlanetaRepository;
import com.prueba.service.ControladorService;

import fj.data.Either;

@Service
public class ControladorServiceImp implements ControladorService{

	@Autowired
	private ControladorPersonaRepository controladorPersonaRepository;
	
	@Autowired
	private ControladorPlanetaRepository controladorPlanetaRepository;
	
	@Autowired
	private PlanetaRepository planetaRepository;
	
	public Either<Exception, String> clickPlaneta(PlanetaResponseDTO planetaResponseDTO) {
		
		guargarControladorPlaneta(planetaResponseDTO);
		return Either.right("OK");
	}

	
	public Either<Exception, String> clickPersona(PersonaResponseDTO personaResponseDTO) {
		
		guargarControladorPersona(personaResponseDTO);
		return Either.right("OK");
	}
	
	private void guargarControladorPlaneta(PlanetaResponseDTO planetaResponseDTO) {
		
		Optional<ControladorPlaneta> planeta = controladorPlanetaRepository.findById(planetaResponseDTO.getIdPlaneta());

		if (!planeta.isPresent()) {
			
			ControladorPlaneta controladorPlaneta = new ControladorPlaneta();
			controladorPlaneta.setIdPlaneta(planetaResponseDTO.getIdPlaneta());
			controladorPlaneta.setName(planetaResponseDTO.getName());
			controladorPlaneta.setContador(Long.valueOf("1"));
			controladorPlanetaRepository.save(controladorPlaneta);
			
		} else {

			planeta.get().setContador(planeta.get().getContador() + 1);
			controladorPlanetaRepository.save(planeta.get());
		}
	}
	
	private void guargarControladorPersona(PersonaResponseDTO personaResponseDTO) {
		
		guardarControladorPlanetaPersona(personaResponseDTO);
		
		Optional<ControladorPersona> persona = controladorPersonaRepository.findById(personaResponseDTO.getIdPersona());

		if (!persona.isPresent()) {
			
			ControladorPersona controladorPersona = new ControladorPersona();
			controladorPersona.setIdPersona(personaResponseDTO.getIdPersona());
			controladorPersona.setName(personaResponseDTO.getName());
			controladorPersona.setContador(Long.valueOf("1"));
			controladorPersonaRepository.save(controladorPersona);
			
		} else {

			persona.get().setContador(persona.get().getContador() + 1);
			controladorPersonaRepository.save(persona.get());
		}
	}

	private void guardarControladorPlanetaPersona(PersonaResponseDTO personaResponseDTO) {
		
		Optional<Planeta> planeta = planetaRepository.findById(personaResponseDTO.getIdPlaneta());
		
		if (planeta.isPresent()) {
			PlanetaResponseDTO planetaResponseDTO = new PlanetaResponseDTO();
			planetaResponseDTO.setContador(Long.valueOf("0"));
			planetaResponseDTO.setIdPlaneta(planeta.get().getIdPlaneta());
			planetaResponseDTO.setName(planeta.get().getName());
			guargarControladorPlaneta(planetaResponseDTO);
		}
	}

}
