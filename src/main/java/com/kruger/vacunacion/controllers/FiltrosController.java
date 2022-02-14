package com.kruger.vacunacion.controllers;

import java.util.List;

import com.kruger.vacunacion.repository.IVacunacionRepository;
import com.kruger.vacunacion.services.EmpleadoService;
import com.kruger.vacunacion.services.VacunacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.vacunacion.repository.IEmpleadoRepository;

@RestController
@RequestMapping("/api/empleados/filtros")
public class FiltrosController {
	
	@Autowired
	private VacunacionService vacunacion;
	
	@Autowired
	private EmpleadoService empleado;
	
	@Autowired
	private IEmpleadoRepository empleadoR;
	
	@Autowired
	private IVacunacionRepository vacunaR;
	
	@GetMapping("/vacunado/{estado}")
	private List<?> findByEstado(@PathVariable(value="estado") boolean estado){
		return this.empleadoR.findByEstado(estado);
	}
	
	@GetMapping("/vacuna/{vacuna}")
	private List<?> findByVacuna(@PathVariable(value="vacuna") String vacuna){
		return this.vacunaR.findByVacuna(vacuna);
	}

}
