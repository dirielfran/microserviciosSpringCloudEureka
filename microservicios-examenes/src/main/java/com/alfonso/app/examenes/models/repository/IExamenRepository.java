package com.alfonso.app.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alfonso.commons.examenes.models.entity.Examen;

public interface IExamenRepository extends CrudRepository<Examen, Long> {
	
	@Query("SELECT e FROM Examen e WHERE e.nombre like %?1%")
	public List<Examen> findByNombre(String nombre);

}
