package com.kruger.vacunacion.services;

import java.util.List;

import com.kruger.vacunacion.entity.Empleado;

public interface IEmpleadoService {
	
	public Empleado create(Empleado empleado);
	public Empleado update(Empleado c);
	public void delete(Integer id);
	public Empleado findById(Integer id);
	public List<Empleado> findAll();
}
