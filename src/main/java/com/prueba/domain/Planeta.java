package com.prueba.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "planeta")
public class Planeta implements Serializable {

	private static final long serialVersionUID = 1586413299376165428L;

	@Id
	@Column(nullable = false, name = "idplaneta")
	private Long idPlaneta;

	@Column(nullable = false, name = "name")
	private String name;

	@Column(nullable = true, name = "rotationperiod")
	private String rotationPeriod;

	@Column(nullable = true, name = "orbitalperiod")
	private String orbitalPeriod;

	@Column(nullable = true, name = "diameter")
	private String diameter;

	@Column(nullable = true, name = "climate")
	private String climate;

	@Column(nullable = true, name = "gravity")
	private String gravity;

	@Column(nullable = true, name = "terrain")
	private String terrain;

	@Column(nullable = true, name = "surfacewater")
	private String surfaceWater;

	@Column(nullable = true, name = "population")
	private String population;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanetapk")
    private List<Persona> personaList;

	public Long getIdPlaneta() {
		return idPlaneta;
	}

	public void setIdPlaneta(Long idPlaneta) {
		this.idPlaneta = idPlaneta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRotationPeriod() {
		return rotationPeriod;
	}

	public void setRotationPeriod(String rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}

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
	
	@XmlTransient
	public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPlaneta != null ? idPlaneta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Planeta)) {
			return false;
		}
		Planeta other = (Planeta) object;
		if ((this.idPlaneta == null && other.idPlaneta != null)
				|| (this.idPlaneta != null && !this.idPlaneta.equals(other.idPlaneta))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Planeta[ idPlaneta=" + idPlaneta + " ]";
	}

}
