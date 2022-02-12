package com.alfonso.app.cursos.services;

import org.springframework.web.bind.annotation.PathVariable;

import com.alfonso.app.cursos.models.entity.Curso;
import com.alfonso.commons.services.ICommonService;

public interface ICursoService extends ICommonService<Curso> {
	
	//metodo para la busqueda de curso por el id del alumno
	public Curso findCursoByAlumnoId(Long id);
	public Iterable<Long> getExamenesIdsRespondidos(Long idAlumno);
	
}
