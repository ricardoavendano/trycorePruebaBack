package com.prueba.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "controladorplaneta")
public class ControladorPlaneta implements Serializable {

	private static final long serialVersionUID = 9189037000732807794L;

	@Id
	@Column(nullable = false, name = "idplaneta")
	private Long idPlaneta;

	@Column(nullable = false, name = "name")
	private String name;
	
	@Column(nullable = false, name = "contador")
	private Long contador;

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
	public boolean equals(Object object) {
		if (!(object instanceof ControladorPlaneta)) {
			return false;
		} else {
			ControladorPlaneta other = (ControladorPlaneta) object;
			if ((this.idPlaneta == null && other.idPlaneta != null)
					|| (this.idPlaneta != null && !this.idPlaneta.equals(other.idPlaneta))) {
				return false;
			}
			return true;
		}
	}

	@Override
	public String toString() {
		return "entity.ControladorPlaneta[ idPlaneta=" + idPlaneta + " ]";
	}
}
