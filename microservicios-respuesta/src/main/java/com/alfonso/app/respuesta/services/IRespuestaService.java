package com.alfonso.app.respuesta.services;

import com.alfonso.app.respuesta.models.entity.Respuesta;

public interface IRespuestaService {
	
	public Iterable<Respuesta> saveAll( Iterable<Respuesta> respuestas);
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long idAlumno, Long idExamen);
	public Iterable<Long> findExamenesIdsConRespuestaByAlumno(Long alumnoId);

}
