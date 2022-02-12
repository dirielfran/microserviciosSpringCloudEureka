package com.alfonso.commons.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICommonService<E> {
	
	public Iterable<E> buscarTodos();
	
	public Page<E> buscarTodos(Pageable pageable);
	
	public Optional<E> BuscarXId(Long idEntity);
	
	public E guardar(E entity);
	
	public void deleteById(Long idAlumno);
}
