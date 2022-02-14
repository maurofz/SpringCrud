package com.jhonny.vacunacion.entity;


import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_ADMINISTRADOR")
@PrimaryKeyJoinColumn(name = "ADMINISTRADOR_ID")

public class Administrador extends Persona{
	
}
