package com.alfonso.app.cursos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alfonso.app.cursos.models.entity.Curso;
import com.alfonso.app.cursos.models.repository.ICursoRepository;
import com.alfonso.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, ICursoRepository> implements ICursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return entityRepo.findCursoByAlumnoId(id);
	}

}
