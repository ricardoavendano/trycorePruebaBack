package com.prueba.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prueba.datatransfer.PersonaAdpDTO;
import com.prueba.datatransfer.PersonaDTO;
import com.prueba.datatransfer.PersonaResponseDTO;
import com.prueba.datatransfer.PlanetaAdpDTO;
import com.prueba.datatransfer.PlanetaDTO;
import com.prueba.datatransfer.PlanetaResponseDTO;
import com.prueba.datatransfer.ResultsDTO;
import com.prueba.datatransfer.ResultsPlanetDTO;
import com.prueba.domain.ControladorPersona;
import com.prueba.domain.ControladorPlaneta;
import com.prueba.domain.Persona;
import com.prueba.domain.Planeta;

@Component
public class ModeloAdapter {

	public List<PersonaAdpDTO> personaListAdapter(PersonaDTO persona) {

		List<PersonaAdpDTO> personaListDTO = new ArrayList<>();
		for (ResultsDTO personaList : persona.getResults()) {

			PersonaAdpDTO personaDTO = new PersonaAdpDTO();
			String[] idPersona = personaList.getUrl().split("/");
			String[] idPlaneta = personaList.getHomeworld().split("/");
			personaDTO.setIdPersona(Long.valueOf(idPersona[idPersona.length - 1]));
			personaDTO.setIdPlaneta(Long.valueOf(idPlaneta[idPlaneta.length - 1]));
			personaDTO.setBirthYear(personaList.getBirthYear());
			personaDTO.setEyeColor(personaList.getEyeColor());
			personaDTO.setGender(personaList.getGender());
			personaDTO.setHairColor(personaList.getHairColor());
			personaDTO.setHeight(personaList.getHeight());
			personaDTO.setMass(personaList.getMass());
			personaDTO.setName(personaList.getName());
			personaDTO.setSkinColor(personaList.getSkinColor());

			personaListDTO.add(personaDTO);
		}

		return personaListDTO;
	}

	public List<PlanetaAdpDTO> planetaListAdapter(PlanetaDTO planeta) {

		List<PlanetaAdpDTO> planetaListDTO = new ArrayList<>();
		for (ResultsPlanetDTO planetaList : planeta.getResults()) {

			PlanetaAdpDTO planetaDTO = new PlanetaAdpDTO();
			String[] idPersona = planetaList.getUrl().split("/");
			planetaDTO.setIdPlaneta(Long.valueOf(idPersona[idPersona.length - 1]));
			planetaDTO.setClimate(planetaList.getClimate());
			planetaDTO.setDiameter(planetaList.getDiameter());
			planetaDTO.setGravity(planetaList.getGravity());
			planetaDTO.setName(planetaList.getName());
			planetaDTO.setOrbitalPeriod(planetaList.getOrbitalPeriod());
			planetaDTO.setPopulation(planetaList.getPopulation());
			planetaDTO.setRotationPeriod(planetaList.getRotationPeriod());
			planetaDTO.setSurfaceWater(planetaList.getSurfaceWater());
			planetaDTO.setTerrain(planetaList.getTerrain());

			planetaListDTO.add(planetaDTO);
		}

		return planetaListDTO;
	}

	public List<PlanetaAdpDTO> planetaList(List<Planeta> planetaList) {

		List<PlanetaAdpDTO> planetaListDTO = new ArrayList<>();
		for (Planeta planeta : planetaList) {

			PlanetaAdpDTO planetaDTO = new PlanetaAdpDTO();
			planetaDTO.setIdPlaneta(planeta.getIdPlaneta());
			planetaDTO.setClimate(planeta.getClimate());
			planetaDTO.setDiameter(planeta.getDiameter());
			planetaDTO.setGravity(planeta.getGravity());
			planetaDTO.setName(planeta.getName());
			planetaDTO.setOrbitalPeriod(planeta.getOrbitalPeriod());
			planetaDTO.setPopulation(planeta.getPopulation());
			planetaDTO.setRotationPeriod(planeta.getRotationPeriod());
			planetaDTO.setSurfaceWater(planeta.getSurfaceWater());
			planetaDTO.setTerrain(planeta.getTerrain());

			planetaListDTO.add(planetaDTO);
		}

		return planetaListDTO;
	}

	public List<PersonaResponseDTO> personaResponseId(List<Persona> personaList) {

		List<PersonaResponseDTO> personaListDTO = new ArrayList<>();
		
		for(Persona persona: personaList) {
			
			PersonaResponseDTO personaDTO = new PersonaResponseDTO();
			personaDTO.setIdPersona(persona.getIdPersona());
			personaDTO.setName(persona.getName());
			personaListDTO.add(personaDTO);
		}
		return personaListDTO;
	}

	public List<PersonaAdpDTO> personaList(List<Persona> personaList) {

		List<PersonaAdpDTO> personaListDTO = new ArrayList<>();
		for (Persona persona : personaList) {

			PersonaAdpDTO personaDTO = new PersonaAdpDTO();
			personaDTO.setIdPersona(persona.getIdPersona());
			personaDTO.setIdPlaneta(persona.getIdPlanetapk().getIdPlaneta());
			personaDTO.setBirthYear(persona.getBirthYear());
			personaDTO.setEyeColor(persona.getEyeColor());
			personaDTO.setGender(persona.getGender());
			personaDTO.setHairColor(persona.getHairColor());
			personaDTO.setHeight(persona.getHeight());
			personaDTO.setMass(persona.getMass());
			personaDTO.setName(persona.getName());
			personaDTO.setSkinColor(persona.getSkinColor());

			personaListDTO.add(personaDTO);
		}

		return personaListDTO;
	}

	public List<PlanetaResponseDTO> planetaResponseList(List<ControladorPlaneta> planetaList) {

		List<PlanetaResponseDTO> planetaListDTO = new ArrayList<>();
		for (ControladorPlaneta planeta : planetaList) {

			PlanetaResponseDTO planetaDTO = new PlanetaResponseDTO();
			planetaDTO.setIdPlaneta(planeta.getIdPlaneta());
			planetaDTO.setName(planeta.getName());
			planetaDTO.setContador(planeta.getContador());

			planetaListDTO.add(planetaDTO);
		}

		return planetaListDTO;
	}

	public PlanetaResponseDTO planetaResponseId(Planeta planeta) {

		PlanetaResponseDTO planetaDTO = new PlanetaResponseDTO();
		planetaDTO.setIdPlaneta(planeta.getIdPlaneta());
		planetaDTO.setName(planeta.getName());

		return planetaDTO;
	}

	public List<PersonaResponseDTO> personaResponseList(List<ControladorPersona> personaList) {

		List<PersonaResponseDTO> personaListDTO = new ArrayList<>();
		for (ControladorPersona persona : personaList) {

			PersonaResponseDTO personaDTO = new PersonaResponseDTO();
			personaDTO.setIdPersona(persona.getIdPersona());
			personaDTO.setName(persona.getName());
			personaDTO.setContador(persona.getContador());

			personaListDTO.add(personaDTO);
		}

		return personaListDTO;
	}
}
