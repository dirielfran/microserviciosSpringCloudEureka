package com.alfonso.commons.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alfonso.commons.services.ICommonService;


public class CommonController<E, S extends ICommonService<E>>{

	@Autowired
	protected S entityService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(entityService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verAlumno(@PathVariable Long id){
		Optional<E> opt = entityService.BuscarXId(id);
		if(opt.isEmpty()) {
			//Si no lo encuentra envia un codigo 404 y construye body vacio
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opt.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody E entity){
		E entityBD = entityService.guardar(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarAlumno(@PathVariable Long id){
		entityService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
