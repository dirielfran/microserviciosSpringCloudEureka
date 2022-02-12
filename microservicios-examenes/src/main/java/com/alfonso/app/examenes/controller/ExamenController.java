package com.alfonso.app.examenes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alfonso.app.examenes.service.IExamenService;
import com.alfonso.commons.controller.CommonController;
import com.alfonso.commons.examenes.models.entity.Examen;
import com.alfonso.commons.examenes.models.entity.Pregunta;

@RestController
public class ExamenController extends CommonController<Examen, IExamenService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Examen examen, BindingResult result , @PathVariable Long id){
		
		// Validacion de campos
		if(result.hasErrors()) return this.validar(result);
		
		Optional<Examen> opt = entityService.BuscarXId(id);
		if(!opt.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		Examen examenbd = opt.get();
		examenbd.setNombre(examen.getNombre());
		
		//Se eliminan de la bd las preguntas eliminadas
		List<Pregunta> eliminadas = new ArrayList<>();
		
		examenbd.getPreguntas()
		.stream()
		.filter(p -> !examenbd.getPreguntas().contains(p))
		.forEach(examenbd::deletePregunta);
		
		examenbd.setPreguntas(examen.getPreguntas());
	
		return ResponseEntity.status(HttpStatus.CREATED).body(entityService.guardar(examenbd));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrarExamen(@PathVariable String term){
		return ResponseEntity.ok(entityService.findByNombre(term));
	}
	
	@GetMapping("asignaturas")
	public ResponseEntity<?> getAsignaturas(){
		return ResponseEntity.ok(entityService.findAllAsignatura());
	}

}
