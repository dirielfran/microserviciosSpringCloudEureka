package com.alfonso.app.usuarios.models.service;


import java.util.List;

import com.alfonso.commons.alumnos.models.entity.Alumno;
import com.alfonso.commons.services.ICommonService;

public interface IAlumnoService extends ICommonService<Alumno>{
	
//	public Iterable<Alumno> buscarTodos();
//	
//	public Optional<Alumno> BuscarXId(Long idAlumno);
//	
//	public Alumno guardar(Alumno alumno);
//	
//	public void deleteById(Long idAlumno);
	//metodo para la busqueda de alumnos por nombre o apellido
	public List<Alumno> findByNombreOrApellido(String term);
}
