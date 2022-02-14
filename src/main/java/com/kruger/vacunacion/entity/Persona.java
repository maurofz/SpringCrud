package com.jhonny.vacunacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "T_PERSONA")
@Inheritance(strategy = InheritanceType.JOINED)

public class Persona {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="cedula", nullable=false,length = 12)
	private String cedula;
	
	@Column(name="nombres",nullable=false,length = 50)
	private String nombres;
	
	@Column(name="apellidos", nullable=false,length = 50)
	private String apellidos;
	
	@Column(name="email", nullable=false,length = 50, unique = true)
	private String email;
	
	@Column(name="role",nullable=false,length = 50)
	private String role;
	
	@Column(name="usuario", nullable=false,length = 50, unique = true)
	private String usuario;
	
	@Column(name="password",nullable=false,length = 500)
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUser(String user) {
		this.usuario = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
