package com.prueba.datatransfer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsDTO {

	private String name;
	private String height;
	private String mass;
	private String hairColor;
	private String skinColor;
	private String eyeColor;
	private String birthYear;
	private String gender;
	private String homeworld;
	private List<FilmsDTO> films;
	private List<SpeciesDTO> species;
	private List<VehiclesDTO> vehicles;
	private List<StarshipsDTO> starships;
	private String created;
	private String edited;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	@JsonProperty("hair_color")
	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	@JsonProperty("skin_color")
	public String getSkinColor() {
		return skinColor;
	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	@JsonProperty("eye_color")
	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	@JsonProperty("birth_year")
	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public List<FilmsDTO> getFilms() {
		return films;
	}

	public void setFilms(List<FilmsDTO> films) {
		this.films = films;
	}

	public List<SpeciesDTO> getSpecies() {
		return species;
	}

	public void setSpecies(List<SpeciesDTO> species) {
		this.species = species;
	}

	public List<VehiclesDTO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehiclesDTO> vehicles) {
		this.vehicles = vehicles;
	}

	public List<StarshipsDTO> getStarships() {
		return starships;
	}

	public void setStarship(List<StarshipsDTO> starships) {
		this.starships = starships;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
