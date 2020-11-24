package com.alfonso.app.cursos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfonso.app.cursos.models.entity.Curso;

@Repository
public interface ICursoRepository extends CrudRepository<Curso, Long> {
	@Query("SELECT c FROM Curso c JOIN FETCH c.alumnos a WHERE a.id = ?1")
	public Curso findCursoByAlumnoId(Long id);
}
