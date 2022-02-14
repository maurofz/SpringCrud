package com.kruger.vacunacion.services;

import java.util.List;

import com.kruger.vacunacion.entity.Vacunacion;

public interface IVacunacionService {
	public Vacunacion create(Vacunacion vacunado);
	public Vacunacion update(Vacunacion vacunado);
	public void delete(Integer id);
	public Vacunacion findById(Integer id);
	public List<Vacunacion> findAll();
}
