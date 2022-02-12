package com.alfonso.app.respuesta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alfonso.app.respuesta.models.entity.Respuesta;
import com.alfonso.app.respuesta.models.repository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements IRespuestaService {
	
	@Autowired
	private RespuestaRepository respuestaRepository;

	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return respuestaRepository.saveAll(respuestas);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long idAlumno, Long idExamen) {
		return respuestaRepository.findRespuestaByAlumnoByExamen(idAlumno, idExamen);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestaByAlumno(Long alumnoId) {
		return respuestaRepository.findExamenesIdsConRespuestaByAlumno(alumnoId);
	}
	
	

}
