package com.alfonso.app.examenes.service;

import org.springframework.stereotype.Service;

import com.alfonso.app.examenes.models.entity.Examen;
import com.alfonso.app.examenes.models.repository.IExamenRepository;
import com.alfonso.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService{

}
