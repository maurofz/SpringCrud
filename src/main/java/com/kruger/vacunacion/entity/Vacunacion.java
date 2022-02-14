package com.kruger.vacunacion.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_VACUNACION")
public class Vacunacion {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="fechaAplicacion",nullable = true)
	private Date fechaAplicacion;
	
	@Column(name="tipoVacuna",nullable = true, length = 50)
	private String tipoVacuna;
	
	@Column(name="nroDosis",nullable = true)
	private Integer nroDosis;
	
	@JoinColumn(name="idEmpleado",nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Empleado empleado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public String getTipoVacuna() {
		return tipoVacuna;
	}

	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

	public Integer getNroDosis() {
		return nroDosis;
	}

	public void setNroDosis(Integer nroDosis) {
		this.nroDosis = nroDosis;
	}

	public Persona getEmpleado() {
		return empleado;
	}

	public void setPersona(Empleado empleado) {
		this.empleado = empleado;
	}
		
}
