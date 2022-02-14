package com.jhonny.vacunacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonny.vacunacion.entity.Empleado;
import com.jhonny.vacunacion.services.EmpleadoService;

import errors.ResponseErrors;

@RestController
@RequestMapping("/api/empleado/update")
public class EmpleadoUpController {
	
	@Autowired
	private EmpleadoService empleado;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Empleado empleado, @PathVariable(value = "id") Integer id) {
		ResponseErrors error = new ResponseErrors();
		if(!error.campoRequerido(empleado.getDireccion()) || !error.campoRequerido(empleado.getTelefono()) || empleado.getFechaNacimiento()==null ) {
			return error.requeridoUpdate();
		}
		Empleado empleadoOld = this.empleado.findById(id);
		empleadoOld.setDireccion(empleado.getDireccion());
		empleadoOld.setTelefono(empleado.getTelefono());
		empleadoOld.setFechaNacimiento(empleado.getFechaNacimiento());
		empleadoOld.setEstadoVacunacion(empleado.isEstadoVacunacion());
		return ResponseEntity.status(HttpStatus.OK).body(this.empleado.update(empleadoOld));
	}
}
