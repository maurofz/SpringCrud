package com.kruger.vacunacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kruger.vacunacion.entity.Empleado;
import com.kruger.vacunacion.repository.IEmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleado;
	
	@Override
	@Transactional
	public Empleado create(Empleado empleado) {
		return this.empleado.save(empleado);
	}

	@Override
	@Transactional
	public Empleado update(Empleado empleado) {
		return this.empleado.save(empleado);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		this.empleado.deleteById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Integer id) {
		Optional<Empleado> empleadoOptional = this.empleado.findById(id);
		return empleadoOptional.orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return empleado.findAll();
	}
	
	
}
