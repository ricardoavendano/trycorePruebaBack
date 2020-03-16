package com.prueba.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "controladorpersona")
public class ControladorPersona implements Serializable {

	private static final long serialVersionUID = 3666746727293974613L;

	@Id
	@Column(nullable = false, name = "idpersona")
	private Long idPersona;

	@Column(nullable = false, name = "name")
	private String name;
	
	@Column(nullable = false, name = "contador")
	private Long contador;

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

	public Long getContador() {
		return contador;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPersona != null ? idPersona.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ControladorPersona)) {
			return false;
		} else {
			ControladorPersona other = (ControladorPersona) object;
			if ((this.idPersona == null && other.idPersona != null)
					|| (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
				return false;
			}
			return true;
		}
	}

	@Override
	public String toString() {
		return "entity.ControladorPersona[ idPersona=" + idPersona + " ]";
	}
}
