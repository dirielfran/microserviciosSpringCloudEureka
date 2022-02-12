package com.alfonso.app.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicios-respuesta")
public interface RespuestaFeignClient {
	
	@GetMapping("/alumno/{idAlumno}/examenes-respondidos")
	public Iterable<Long> getExamenesIdsRespondidos(@PathVariable Long idAlumno);

}
