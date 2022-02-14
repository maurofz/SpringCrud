package com.jhonny.vacunacion.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_EMPLEADO")
@PrimaryKeyJoinColumn(name = "EMPLEADO_ID")

public class Empleado extends Persona{
	
	
	@Column(name="fechaNacimiento", nullable=true)
	private Date fechaNacimiento;
	
	@Column(name="direccion", nullable=true,length = 50)
	private String direccion;
	
	@Column(name="telefono", nullable=true,length = 20)
	private String telefono;
	
	@Column(name="estado", nullable=true)
	private boolean estadoVacunacion;
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEstadoVacunacion() {
		return estadoVacunacion;
	}

	public void setEstadoVacunacion(boolean estadoVacunacion) {
		this.estadoVacunacion = estadoVacunacion;
	}
}
