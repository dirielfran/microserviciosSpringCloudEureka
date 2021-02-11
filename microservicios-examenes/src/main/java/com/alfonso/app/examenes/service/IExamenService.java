package com.alfonso.app.examenes.service;

import java.util.List;

import com.alfonso.commons.examenes.models.entity.Asignatura;
import com.alfonso.commons.examenes.models.entity.Examen;
import com.alfonso.commons.services.ICommonService;

public interface IExamenService extends ICommonService<Examen>{
	
	public List<Examen> findByNombre(String nombre);
	
	public Iterable<Asignatura> findAllAsignatura();

}
