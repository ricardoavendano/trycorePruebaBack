package com.prueba.adapter.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.prueba.adapter.ModeloAdapter;
import com.prueba.datatransfer.FilmsDTO;
import com.prueba.datatransfer.PersonaDTO;
import com.prueba.datatransfer.ResultsDTO;
import com.prueba.datatransfer.SpeciesDTO;
import com.prueba.datatransfer.StarshipsDTO;
import com.prueba.datatransfer.VehiclesDTO;

@RunWith(MockitoJUnitRunner.class)
public class ModeloAdapterTest {
	
	@InjectMocks
	private ModeloAdapter modeloAdapter;
	
	@Test
	public void personaListAdapter() {
		
		PersonaDTO persona = new PersonaDTO();
		persona.setCount(Long.valueOf("0"));
		persona.setNext("https://swapi.co/api/people/?page=3");
		persona.setPrevious(null);
		
		List<ResultsDTO> listResult = new ArrayList<>();
		ResultsDTO result = new ResultsDTO();
		
		result.setBirthYear("");
		result.setCreated("");
		result.setEdited("");
		result.setEyeColor("");
		result.setGender("");
		result.setHairColor("");
		result.setHeight("");
		result.setHomeworld("https://swapi.co/api/planets/1/");
		result.setMass("");
		result.setName("");
		result.setSkinColor("");
		result.setUrl("https://swapi.co/api/people/11/");
		
		List<VehiclesDTO> vehiclesList = new ArrayList<>();
		VehiclesDTO vehicle = new VehiclesDTO("");
		vehiclesList.add(vehicle);
		result.setVehicles(vehiclesList);
		
		List<StarshipsDTO> starshipsList = new ArrayList<>();
		StarshipsDTO starships = new StarshipsDTO("");
		starshipsList.add(starships);
		result.setStarship(starshipsList);
		
		List<SpeciesDTO> speciesList = new ArrayList<>();
		SpeciesDTO species = new SpeciesDTO("");
		speciesList.add(species);
		result.setSpecies(speciesList);
		
		List<FilmsDTO> filsList = new ArrayList<>();
		FilmsDTO films = new FilmsDTO("");
		filsList.add(films);
		result.setFilms(filsList);
		
		listResult.add(result);
		
		persona.setResults(listResult);
		
		modeloAdapter.personaListAdapter(persona);
		
	}

}
