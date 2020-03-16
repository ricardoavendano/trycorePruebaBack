package com.prueba.imp;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.adapter.ModeloAdapter;
import com.prueba.datatransfer.PersonaAdpDTO;
import com.prueba.datatransfer.PersonaDTO;
import com.prueba.datatransfer.PersonaResponseDTO;
import com.prueba.datatransfer.PlanetaAdpDTO;
import com.prueba.datatransfer.PlanetaDTO;
import com.prueba.datatransfer.PlanetaResponseDTO;
import com.prueba.domain.ControladorPersona;
import com.prueba.domain.ControladorPlaneta;
import com.prueba.domain.Persona;
import com.prueba.domain.Planeta;
import com.prueba.repository.ControladorPersonaRepository;
import com.prueba.repository.ControladorPlanetaRepository;
import com.prueba.repository.PersonaRepository;
import com.prueba.repository.PlanetaRepository;
import com.prueba.service.ModeloService;

import fj.data.Either;

@Service
public class ModeloServiceImp implements ModeloService {

	@Autowired
	private ModeloAdapter personaAdapter;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private ControladorPlanetaRepository controladorPlanetaRepository;

	@Autowired
	private ControladorPersonaRepository controladorPersonaRepository;

	public Either<Exception, String> cargarModelo() throws JsonParseException, JsonMappingException, IOException {
		setPlaneta();
		setPersona();
		return Either.right("OK");
	}

	public Either<Exception, List<PlanetaAdpDTO>> cargarPlaneta() {

		return Either.right(getPlaneta());
	}

	public Either<Exception, List<PersonaAdpDTO>> cargarPersona() {

		return Either.right(getPersona());
	}

	public Either<Exception, List<PlanetaResponseDTO>> cargarPlanetaResponse() {

		return Either.right(getPlanetaResponse());
	}

	public Either<Exception, PlanetaResponseDTO> cargarPlanetaResponseId(Long id) {

		return Either.right(getPlanetaResponseId(id));
	}

	public Either<Exception, List<PersonaResponseDTO>> cargarPersonaResponse() {

		return Either.right(getPersonaResponse());
	}
	
	public Either<Exception, List<PersonaResponseDTO>> cargarPersonaResponseId(Long id) {

		return Either.right(getPersonaResponseId(id));
	}

	private void setPlaneta() throws IOException, JsonParseException, JsonMappingException {
		String url = "https://swapi.co/api/planets/";
		String body = getRest(url);
		PlanetaDTO planetaDTO = mapPlaneta(body);

		List<PlanetaAdpDTO> personaAdp = serPlaneta(2, personaAdapter.planetaListAdapter(planetaDTO));

		guardarPlaneta(personaAdp);
	}

	private List<PlanetaAdpDTO> getPlaneta() {
		List<Planeta> planeta = (List<Planeta>) planetaRepository.findAll();
		return personaAdapter.planetaList(planeta);
	}

	private List<PersonaAdpDTO> getPersona() {
		List<Persona> persona = (List<Persona>) personaRepository.findAll();
		return personaAdapter.personaList(persona);
	}

	private List<PlanetaResponseDTO> getPlanetaResponse() {
		List<ControladorPlaneta> planeta = (List<ControladorPlaneta>) controladorPlanetaRepository.findAll();
		return personaAdapter.planetaResponseList(planeta);
	}

	private PlanetaResponseDTO getPlanetaResponseId(Long id) {
		Optional<Planeta> planeta = planetaRepository.findById(id);

		if (planeta.isPresent()) {
			return personaAdapter.planetaResponseId(planeta.get());
		}
		return null;
	}

	private List<PersonaResponseDTO> getPersonaResponse() {
		List<ControladorPersona> persona = (List<ControladorPersona>) controladorPersonaRepository.findAll();
		return personaAdapter.personaResponseList(persona);
	}
	
	private List<PersonaResponseDTO> getPersonaResponseId(Long id) {
		List<Persona> persona = personaRepository.listaPersonaPorPlaneta(id);

		if (!persona.isEmpty()) {
			return personaAdapter.personaResponseId(persona);
		}
		return null;
	}

	private void setPersona() throws IOException, JsonParseException, JsonMappingException {
		String url = "https://swapi.co/api/people/";
		String body = getRest(url);
		PersonaDTO personaDTO = mapPersona(body);

		List<PersonaAdpDTO> personaAdp = serPersona(2, personaAdapter.personaListAdapter(personaDTO));

		guardarPersona(personaAdp);
	}

	private void guardarPlaneta(List<PlanetaAdpDTO> planetaAdp) {

		for (PlanetaAdpDTO planetaDTO : planetaAdp) {
			Planeta planeta = new Planeta();
			planeta.setIdPlaneta(planetaDTO.getIdPlaneta());
			planeta.setClimate(planetaDTO.getClimate());
			planeta.setDiameter(planetaDTO.getDiameter());
			planeta.setGravity(planetaDTO.getGravity());
			planeta.setName(planetaDTO.getName());
			planeta.setOrbitalPeriod(planetaDTO.getOrbitalPeriod());
			planeta.setPopulation(planetaDTO.getPopulation());
			planeta.setRotationPeriod(planetaDTO.getRotationPeriod());
			planeta.setSurfaceWater(planetaDTO.getSurfaceWater());
			planeta.setTerrain(planetaDTO.getTerrain());
			planetaRepository.save(planeta);
		}
	}

	private void guardarPersona(List<PersonaAdpDTO> personaAdp) {

		for (PersonaAdpDTO personaDTO : personaAdp) {
			Persona persona = new Persona();
			Planeta planeta = new Planeta();
			planeta.setIdPlaneta(personaDTO.getIdPlaneta());
			persona.setIdPersona(personaDTO.getIdPersona());
			persona.setIdPlanetapk(planeta);
			persona.setBirthYear(personaDTO.getBirthYear());
			persona.setEyeColor(personaDTO.getEyeColor());
			persona.setGender(personaDTO.getGender());
			persona.setHairColor(personaDTO.getHairColor());
			persona.setHeight(personaDTO.getHeight());
			persona.setMass(personaDTO.getMass());
			persona.setName(personaDTO.getName());
			persona.setSkinColor(personaDTO.getSkinColor());
			personaRepository.save(persona);
		}
	}

	private PlanetaDTO mapPlaneta(String body) throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(body, new TypeReference<PlanetaDTO>() {
		});
	}

	private PersonaDTO mapPersona(String body) throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(body, new TypeReference<PersonaDTO>() {
		});
	}

	private String getRest(String url) {
		System.setProperty("http.agent", "Chrome");

		RestTemplate template = new RestTemplate();
		ResponseEntity<String> entity = template.getForEntity(url, String.class);
		return entity.getBody();
	}

	private List<PlanetaAdpDTO> serPlaneta(int count, List<PlanetaAdpDTO> planetaAdp)
			throws JsonParseException, JsonMappingException, IOException {

		String url = "https://swapi.co/api/planets/?page=" + count;
		try {
			String body = getRest(url);

			PlanetaDTO planetaDTO = mapPlaneta(body);

			List<PlanetaAdpDTO> planeta = personaAdapter.planetaListAdapter(planetaDTO);

			for (PlanetaAdpDTO planetDTO : planeta) {
				planetaAdp.add(planetDTO);
			}
			count++;
			serPlaneta(count, planetaAdp);
		} catch (Exception e) {
			return planetaAdp;
		}
		return planetaAdp;

	}

	private List<PersonaAdpDTO> serPersona(int count, List<PersonaAdpDTO> personaAdp)
			throws JsonParseException, JsonMappingException, IOException {

		String url = "https://swapi.co/api/people/?page=" + count;
		try {
			String body = getRest(url);

			PersonaDTO personaDTO = mapPersona(body);

			List<PersonaAdpDTO> persona = personaAdapter.personaListAdapter(personaDTO);

			for (PersonaAdpDTO personDTO : persona) {
				personaAdp.add(personDTO);
			}
			count++;
			serPersona(count, personaAdp);
		} catch (Exception e) {
			return personaAdp;
		}
		return personaAdp;

	}

}
