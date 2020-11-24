package com.alfonso.app.examenes.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "examenes")
public class Examen implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	//El orphanRemoval atributo instruirá al proveedor de JPA para que active una remove transición 
	//de estado de entidad cuando el hijo su entidad matriz ya no haga referencia a una entidad.
	@JsonIgnoreProperties(value = {"examen"}, allowSetters = true)
	@OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Pregunta> preguntas;
	
	public Examen() {
		this.preguntas = new ArrayList<>();
	}


	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}


	//Se utiliza el metodo addPregunta para añadir la lsita de preguntas y seteo de examen
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas.clear();
		preguntas.forEach(this::addPregunta);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public void addPregunta(Pregunta pregunta ) {
		this.preguntas.add(pregunta);
		//relacion inversa
		pregunta.setExamen(this);
	}
	
	public void deletePregunta(Pregunta pregunta) {
		this.preguntas.remove(pregunta);
		//Se estable relacion inversa al setearle null se elimana por la 
		//propiedad config. orphanRemoval = true
		pregunta.setExamen(null);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1406719456082571936L;


}
