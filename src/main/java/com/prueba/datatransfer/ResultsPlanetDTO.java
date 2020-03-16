package com.prueba.datatransfer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsPlanetDTO {

	private String name;
	private String rotationPeriod;
	private String orbitalPeriod;
	private String diameter;
	private String climate;
	private String gravity;
	private String terrain;
	private String surfaceWater;
	private String population;
	private List<ResidentsDTO> residents;
	private List<FilmsDTO> films;
	private String created;
	private String edited;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("rotation_period")
	public String getRotationPeriod() {
		return rotationPeriod;
	}

	public void setRotationPeriod(String rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}

	@JsonProperty("orbital_period")
	public String getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public void setOrbitalPeriod(String orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	@JsonProperty("surface_water")
	public String getSurfaceWater() {
		return surfaceWater;
	}

	public void setSurfaceWater(String surfaceWater) {
		this.surfaceWater = surfaceWater;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public List<ResidentsDTO> getResidents() {
		return residents;
	}

	public void setResidents(List<ResidentsDTO> residents) {
		this.residents = residents;
	}

	public List<FilmsDTO> getFilms() {
		return films;
	}

	public void setFilms(List<FilmsDTO> films) {
		this.films = films;
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
