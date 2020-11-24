package com.alfonso.app.usuarios.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alfonso.app.usuarios.models.service.IAlumnoService;
import com.alfonso.commons.alumnos.models.entity.Alumno;
import com.alfonso.commons.controller.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, IAlumnoService>{

//	@Autowired
//	private IAlumnoService alumnoService;
//	
//	@GetMapping
//	public ResponseEntity<?> listar(){
//		return ResponseEntity.ok().body(alumnoService.buscarTodos());
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> verAlumno(@PathVariable Long id){
//		Optional<Alumno> opt = alumnoService.BuscarXId(id);
//		if(opt.isEmpty()) {
//			//Si no lo encuentra envia un codigo 404 y construye body vacio
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok(opt.get());
//	}
//	
//	@PostMapping
//	public ResponseEntity<?> guardar(@RequestBody Alumno alumno){
//		Alumno alumnoBD = alumnoService.guardar(alumno);
//		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoBD);
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Alumno> opt = entityService.BuscarXId(id);
		if(opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoDB = opt.get();
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entityService.guardar(alumnoDB));
	}
	//endpoint para la busqueda de alumno por apellido o nombre
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrarAlumno(@PathVariable String term){
		return ResponseEntity.ok(entityService.findByNombreOrApellido(term));
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> borrarAlumno(@PathVariable Long id){
//		alumnoService.deleteById(id);
//		return ResponseEntity.noContent().build();
//	}
}
