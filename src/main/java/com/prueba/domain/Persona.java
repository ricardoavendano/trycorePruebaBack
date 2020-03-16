package com.prueba.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = -5046864535057659761L;

	@Id
	@Column(nullable = false, name = "idpersona")
	private Long idPersona;

	@Column(nullable = false, name = "name")
	private String name;

	@Column(nullable = true, name = "height")
	private String height;

	@Column(nullable = true, name = "mass")
	private String mass;

	@Column(nullable = true, name = "haircolor")
	private String hairColor;

	@Column(nullable = true, name = "skincolor")
	private String skinColor;

	@Column(nullable = true, name = "eyecolor")
	private String eyeColor;

	@Column(nullable = true, name = "birthyear")
	private String birthYear;

	@Column(nullable = true, name = "gender")
	private String gender;
	
	@JoinColumn(name = "IDPLANETAPK", referencedColumnName = "IDPLANETA", nullable = false)
	@ManyToOne(optional = false)
	private Planeta idPlanetapk;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

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

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getSkinColor() {
		return skinColor;
	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

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
	
	public Planeta getIdPlanetapk() {
		return idPlanetapk;
	}

	public void setIdPlanetapk(Planeta idPlanetapk) {
		this.idPlanetapk = idPlanetapk;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPersona != null ? idPersona.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Persona)) {
			return false;
		} else {
			Persona other = (Persona) object;
			if ((this.idPersona == null && other.idPersona != null)
					|| (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
				return false;
			}
			return true;
		}
	}

	@Override
	public String toString() {
		return "entity.Persona[ idPersona=" + idPersona + " ]";
	}

}
