package com.alfonso.app.examenes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alfonso.app.examenes.models.entity.Examen;
import com.alfonso.app.examenes.models.entity.Pregunta;
import com.alfonso.app.examenes.service.IExamenService;
import com.alfonso.commons.controller.CommonController;

@RestController
public class ExamenController extends CommonController<Examen, IExamenService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Examen> opt = entityService.BuscarXId(id);
		if(!opt.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		Examen examenbd = opt.get();
		examenbd.setNombre(examen.getNombre());
		
		//Se eliminan de la bd las preguntas eliminadas
		List<Pregunta> eliminadas = new ArrayList<>();
		
		//Se validan que preguntas del json no estan en bd
//		examenbd.getPreguntas().forEach(p ->{
//			if(!examen.getPreguntas().contains(p)) {
//				eliminadas.add(p);
//			}
//		});
		
		//Se eliminan de bd las preguntas eliminadas
//		eliminadas.forEach(p ->{
//			examenbd.deletePregunta(p);
//		});
		
		examenbd.getPreguntas()
		.stream()
		.filter(p -> !examenbd.getPreguntas().contains(p))
		.forEach(examenbd::deletePregunta);
		
		examenbd.setPreguntas(examen.getPreguntas());
	
		return ResponseEntity.status(HttpStatus.CREATED).body(entityService.guardar(examenbd));
	}

}
