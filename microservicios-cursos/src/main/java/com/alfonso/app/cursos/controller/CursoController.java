package com.alfonso.app.cursos.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alfonso.app.cursos.models.entity.Curso;
import com.alfonso.app.cursos.services.ICursoService;
import com.alfonso.commons.alumnos.models.entity.Alumno;
import com.alfonso.commons.controller.CommonController;
import com.alfonso.commons.examenes.models.entity.Examen;
//import com.alfonso.commons.examenes.models.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso, ICursoService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarCurso(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id){
		
		// Validacion de campos
		if(result.hasErrors()) return this.validar(result);
		
		Optional<Curso> opt = this.entityService.BuscarXId(id);
		if(!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursodb = opt.get();
		cursodb.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.entityService.guardar(cursodb));
	}
	
	//metodo que añade alumnos al curso
	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
		Optional<Curso> opt = this.entityService.BuscarXId(id);
		if(!opt.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursodb = opt.get();
		alumnos.forEach(alumno -> {
			cursodb.addAlumno(alumno);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.entityService.guardar(cursodb));
	}
	
	//metodo que elimina un alumno del curso
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Curso> opt = this.entityService.BuscarXId(id);
		if(!opt.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursodb = opt.get();
		cursodb.removeAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.entityService.guardar(cursodb));
	}
	
	//Metodo que devuelve curso por id del alumno
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarCursoXAlumnoId(@PathVariable Long id){
		Curso curso = entityService.findCursoByAlumnoId(id);
		if( null != curso) {
			List<Long> examenesIds = (List<Long>) entityService.getExamenesIdsRespondidos(id);
			
			List<Examen> examenes = curso.getExamenes().stream().map( examen -> {
				if( examenesIds.contains(examen.getId())) {
					examen.setRespondido(true);
				}
				return examen;
			}).collect(Collectors.toList());
			curso.setExamenes(examenes);
		}
		return ResponseEntity.ok(curso);
	}
	
	//metodo que añade examen al curso
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamen(@RequestBody List<Examen> examenes, @PathVariable Long id){
		Optional<Curso> opt = this.entityService.BuscarXId(id);
		if(!opt.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursodb = opt.get();
		examenes.forEach(examen -> {
			cursodb.addExamen(examen);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.entityService.guardar(cursodb));
	}
	
	//metodo que elimina un examen del curso
	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Curso> opt = this.entityService.BuscarXId(id);
		if(!opt.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursodb = opt.get();
		cursodb.removeExamen(examen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.entityService.guardar(cursodb));
	}
}
