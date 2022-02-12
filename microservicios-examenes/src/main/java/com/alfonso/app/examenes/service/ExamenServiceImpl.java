package com.alfonso.app.examenes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alfonso.app.examenes.models.repository.IAsignaturaRepository;
import com.alfonso.app.examenes.models.repository.IExamenRepository;
import com.alfonso.commons.examenes.models.entity.Asignatura;
import com.alfonso.commons.examenes.models.entity.Examen;
import com.alfonso.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService{

	//repository de Asignatura
	@Autowired
	private IAsignaturaRepository asignaturaRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String nombre) {
		return entityRepo.findByNombre(nombre);
	}

	@Override
	public Iterable<Asignatura> findAllAsignatura() {
		return asignaturaRepo.findAll();
	}

}
