package com.jhonny.vacunacion.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonny.vacunacion.entity.Empleado;
import com.jhonny.vacunacion.services.EmpleadoService;
import com.jhonny.vacunacion.services.EncryptService;

import errors.ResponseErrors;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleado;
	
	@GetMapping
	public List<Empleado> findAll(){
		return this.empleado.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Empleado empleado){
		ResponseErrors error = new ResponseErrors();
		if(!error.campoRequerido(empleado.getCedula()) || !error.campoRequerido(empleado.getNombres()) || !error.campoRequerido(empleado.getApellidos()) || !error.campoRequerido(empleado.getEmail()) ) {
			return error.requerido();
		}
		if(!error.soloNumeros(empleado.getCedula())) {
			return error.cedula();
		}
		if(!error.longitudCedula(empleado.getCedula())) {
			return error.cedulaLongitud();
		}
		if(!error.validarEmail(empleado.getEmail())) {
			return error.email();
		}
		if(!error.letras(empleado.getApellidos()) || !error.letras(empleado.getNombres()) ) {
			return error.cadena();
		}
		
		EncryptService encrypt = new EncryptService();
		String hashPass = encrypt.encryptPassword(empleado.getCedula());
		empleado.setPassword(hashPass);
		empleado.setUser(createUser(empleado.getNombres(), empleado.getApellidos(), empleado.getCedula()));
		empleado.setRole("Empleado");
		return ResponseEntity.status(HttpStatus.CREATED).body(this.empleado.create(empleado));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Empleado empleado, @PathVariable(value = "id") Integer id) {
		ResponseErrors error = new ResponseErrors();
		if(!error.campoRequerido(empleado.getCedula()) || !error.campoRequerido(empleado.getNombres()) || !error.campoRequerido(empleado.getApellidos()) || !error.campoRequerido(empleado.getEmail()) ) {
			return error.requerido();
		}
		if(!error.soloNumeros(empleado.getCedula())) {
			return error.cedula();
		}
		if(!error.longitudCedula(empleado.getCedula())) {
			return error.cedulaLongitud();
		}
		if(!error.validarEmail(empleado.getEmail())) {
			return error.email();
		}
		if(!error.letras(empleado.getApellidos()) || !error.letras(empleado.getNombres()) ) {
			return error.cadena();
		}
		Empleado empleadoOld = this.empleado.findById(id);
		empleadoOld.setNombres(empleado.getNombres());
		empleadoOld.setApellidos(empleado.getApellidos());
		empleadoOld.setCedula(empleado.getCedula());
		empleadoOld.setEmail(empleado.getEmail());
		return ResponseEntity.status(HttpStatus.OK).body(this.empleado.update(empleadoOld));
	}
	
	@GetMapping("/{id}")
	public Empleado findById(@PathVariable(value = "id") Integer id) {
		return empleado.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		empleado.delete(id);
	}
	
	public String createUser(String nombre,String apellido,String cedula) {
		String user = "" + nombre.toLowerCase().charAt(0);
		for (int n=0 ;n < apellido.length (); n++) { 
			char c = apellido.toLowerCase().charAt(n);
			if(c == ' ') break;
			else user = user + c;
		}
		user = user + cedula.substring(6,10);
		return user;
	}
}
