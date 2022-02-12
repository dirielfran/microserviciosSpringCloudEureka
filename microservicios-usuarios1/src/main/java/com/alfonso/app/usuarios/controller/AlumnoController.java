package com.alfonso.app.usuarios.controller;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alfonso.app.usuarios.models.service.IAlumnoService;
import com.alfonso.commons.alumnos.models.entity.Alumno;
import com.alfonso.commons.controller.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, IAlumnoService>{

	@GetMapping("/uploads/img/{id}")
	public  ResponseEntity<?> verFoto(@PathVariable Long id){
		Optional<Alumno> opt = entityService.BuscarXId(id);
		if(opt.isEmpty() || opt.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource imagen = new ByteArrayResource(opt.get().getFoto());
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(imagen);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno, BindingResult result , @PathVariable Long id){
		
		// Validacion de campos
		if(result.hasErrors()) return this.validar(result);
		
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

	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> guardarConFoto(@Valid Alumno alumno, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
		if( !archivo.isEmpty() ) {
			alumno.setFoto(archivo.getBytes());
		}
		return super.guardar(alumno, result);
	}
	
	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid Alumno alumno, BindingResult result , @PathVariable Long id,
			@RequestParam MultipartFile archivo) throws IOException{
		
		// Validacion de campos
		if(result.hasErrors()) return this.validar(result);
		
		Optional<Alumno> opt = entityService.BuscarXId(id);
		if(opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoDB = opt.get();
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());
		
		if( !archivo.isEmpty() ) {
			alumnoDB.setFoto(archivo.getBytes());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entityService.guardar(alumnoDB));
	}

	
}
