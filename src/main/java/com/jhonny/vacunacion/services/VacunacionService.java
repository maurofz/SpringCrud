package com.jhonny.vacunacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhonny.vacunacion.entity.Vacunacion;
import com.jhonny.vacunacion.repository.IVacunacionRepository;

@Service
public class VacunacionService implements IVacunacionService{

	@Autowired
	private IVacunacionRepository vacunacion;
	
	@Override
	@Transactional
	public Vacunacion create(Vacunacion vacunado) {
		return this.vacunacion.save(vacunado);
	}

	@Override
	@Transactional
	public Vacunacion update(Vacunacion vacunado) {
		return this.vacunacion.save(vacunado);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		this.vacunacion.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Vacunacion findById(Integer id) {
		Optional<Vacunacion> vacunadoOptional = this.vacunacion.findById(id);
		return vacunadoOptional.orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vacunacion> findAll() {
		return this.vacunacion.findAll();
	}
	
}
