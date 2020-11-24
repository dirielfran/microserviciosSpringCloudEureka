package com.alfonso.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//Se modifica para que la implementacion sea generica, R es cualquier tipo que extienda de CrudRepository
public class CommonServiceImpl<E, R extends CrudRepository<E,Long>> implements ICommonService<E> {
	
	@Autowired
	//Se modifica metodo de acceso para que puedan ser utilizadas por las clases hijas
	protected R entityRepo;

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> buscarTodos() {
		return entityRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> BuscarXId(Long idEntity) {
		return entityRepo.findById(idEntity);
	}

	@Override
	@Transactional
	public E guardar(E entity) {
		return entityRepo.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long idEntity) {
		entityRepo.deleteById(idEntity);
	}
}
