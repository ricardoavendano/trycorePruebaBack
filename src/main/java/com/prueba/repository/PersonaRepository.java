package com.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prueba.domain.Persona;

public interface PersonaRepository extends CrudRepository<Persona, String>{

	@Query("SELECT u FROM Persona u WHERE u.idPlanetapk.idPlaneta = :idPlaneta")
	List<Persona> listaPersonaPorPlaneta(@Param("idPlaneta") Long idPlaneta);
}
