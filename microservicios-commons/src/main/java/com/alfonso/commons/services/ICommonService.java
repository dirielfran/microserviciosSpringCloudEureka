package com.alfonso.commons.services;

import java.util.Optional;


public interface ICommonService<E> {
	
	public Iterable<E> buscarTodos();
	
	public Optional<E> BuscarXId(Long idEntity);
	
	public E guardar(E entity);
	
	public void deleteById(Long idAlumno);
}
