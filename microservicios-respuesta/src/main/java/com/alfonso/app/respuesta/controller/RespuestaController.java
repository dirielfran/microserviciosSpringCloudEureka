package com.alfonso.app.respuesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alfonso.app.respuesta.models.entity.Respuesta;
import com.alfonso.app.respuesta.services.IRespuestaService;

@RestController
public class RespuestaController {
	
	@Autowired
	IRespuestaService iRespuestaService;
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas){
		Iterable<Respuesta> respuestasDB = this.iRespuestaService.saveAll(respuestas);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDB);
	}
	
	@GetMapping("/alumno/{idAlumno}/examen/{idExamen}")
	public ResponseEntity<?> getRespuestasXAlumXExam(@PathVariable Long idAlumno, @PathVariable Long idExamen){
		Iterable<Respuesta> respuestas = iRespuestaService.findRespuestaByAlumnoByExamen(idAlumno, idExamen);
		return ResponseEntity.ok(respuestas);
	}
	
	@GetMapping("/alumno/{idAlumno}/examenes-respondidos")
	public ResponseEntity<?> getExamenesIdsRespondidos(@PathVariable Long idAlumno){
		Iterable<Long> examenesIds = iRespuestaService.findExamenesIdsConRespuestaByAlumno(idAlumno);
		return ResponseEntity.ok(examenesIds);
	}
	
}
