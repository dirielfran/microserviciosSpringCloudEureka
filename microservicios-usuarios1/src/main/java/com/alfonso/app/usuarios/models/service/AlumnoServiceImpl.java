package com.alfonso.app.usuarios.models.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alfonso.app.usuarios.models.repository.IAlumnosRepository;
import com.alfonso.commons.alumnos.models.entity.Alumno;
import com.alfonso.commons.services.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, IAlumnosRepository> implements IAlumnoService {

	@Override
	//metodo para la busqueda de alumnos por nombre o apellido
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return entityRepo.findByNombreOrApellido(term);
	}
	
//	@Autowired
//	private IAlumnosRepository alumnoRepo;
//
//	@Override
//	@Transactional(readOnly = true)
//	public Iterable<Alumno> buscarTodos() {
//		return alumnoRepo.findAll();
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public Optional<Alumno> BuscarXId(Long idAlumno) {
//		return alumnoRepo.findById(idAlumno);
//	}
//
//	@Override
//	@Transactional
//	public Alumno guardar(Alumno alumno) {
//		return alumnoRepo.save(alumno);
//	}
//
//	@Override
//	@Transactional
//	public void deleteById(Long idAlumno) {
//		alumnoRepo.deleteById(idAlumno);
//	}

}
