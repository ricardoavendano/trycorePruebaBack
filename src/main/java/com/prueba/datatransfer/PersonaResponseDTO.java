package com.prueba.datatransfer;

public class PersonaResponseDTO {

	private Long idPersona;
	private Long idPlaneta;
	private String name;
	private Long contador;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	
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

}
