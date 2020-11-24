package com.alfonso.app.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.alfonso.app.examenes.models.entity.Examen;

public interface IExamenRepository extends CrudRepository<Examen, Long> {

}
