package com.jhonny.vacunacion.services;

import java.util.List;

import com.jhonny.vacunacion.entity.Empleado;

public interface IEmpleadoService {
	
	public Empleado create(Empleado empleado);
	public Empleado update(Empleado c);
	public void delete(Integer id);
	public Empleado findById(Integer id);
	public List<Empleado> findAll();
}
