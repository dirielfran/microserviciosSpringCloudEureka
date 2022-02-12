package com.alfonso.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.alfonso.commons.alumnos.models.entity.Alumno;

@Repository
public interface IAlumnosRepository extends PagingAndSortingRepository<Alumno, Long> {

	@Query("SELECT a FROM Alumno a WHERE a.nombre LIKE %?1% OR a.apellido LIKE %?1%")
	public List<Alumno> findByNombreOrApellido(String term);
}
