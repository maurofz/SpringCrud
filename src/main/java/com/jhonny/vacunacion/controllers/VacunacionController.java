package com.jhonny.vacunacion.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonny.vacunacion.entity.Empleado;
import com.jhonny.vacunacion.entity.Vacunacion;
import com.jhonny.vacunacion.services.EmpleadoService;
import com.jhonny.vacunacion.services.VacunacionService;

@RestController
@RequestMapping("/api/empleado/vacunacion")
public class VacunacionController {
	
	@Autowired
	private VacunacionService vacunacion;
	
	@Autowired
	private EmpleadoService empleado;
	
	@GetMapping
	public List<Vacunacion> findAll(){
		return this.vacunacion.findAll();
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> create(@RequestBody Vacunacion vacunado,@PathVariable(value = "id") Integer id){
		Empleado emp = this.empleado.findById(id);
		if(!emp.isEstadoVacunacion()) {
			Map<String,Object> response = new HashMap<>();
			response.put("message", "El empleado no se encuentra vacunado.");
			response.put("code","200");
			response.put("status","success");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		}else {
			vacunado.setPersona(emp);
			return ResponseEntity.status(HttpStatus.CREATED).body(vacunacion.create(vacunado));	
		}
	}
}
