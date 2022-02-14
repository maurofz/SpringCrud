package errors;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseErrors {
	
	public ResponseEntity<?> requerido(){
		Map<String,Object> response = new HashMap<>();
		response.put("message", "Los datos de la cédula,nombres,apellidos y correo son requeridos.");
		response.put("code","200");
		response.put("status","success");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<?> requeridoUpdate(){
		Map<String,Object> response = new HashMap<>();
		response.put("message", "Los datos de la dirección,teléfono,fecha de nacimiento y estado de vacunación son requeridos.");
		response.put("code","200");
		response.put("status","success");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<?> cedula(){
		Map<String,Object> response = new HashMap<>();
		response.put("message", "La cédula debe ser un valor numérico");
		response.put("code","200");
		response.put("status","success");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<?> cedulaLongitud(){
		Map<String,Object> response = new HashMap<>();
		response.put("message", "La cédula debe ser de 10 caracteres");
		response.put("code","200");
		response.put("status","success");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<?> email(){
		Map<String,Object> response = new HashMap<>();
		response.put("message", "Debe ser un email válido.");
		response.put("code","200");
		response.put("status","success");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<?> cadena(){
		Map<String,Object> response = new HashMap<>();
		response.put("message", "Los valores para nombres y apellidos no deben tener ni números ni caracteres especiales");
		response.put("code","200");
		response.put("status","success");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	public boolean letras(String campo) {
		Pattern patron = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+");
		Matcher comprobar = patron.matcher(campo);
		if(comprobar.matches()) return true;
		else return false;
	}
	
	public boolean soloNumeros(String cedula) {
		if(!cedula.matches("[+-]?\\d*(\\.\\d+)?")) return false;
		else return true;
	}
	
	public boolean longitudCedula(String cedula) {
		if(cedula.length()<10 || cedula.length()>10) return false;
		else return true;
	}
	
	public boolean campoRequerido(String campo) {
		if(campo.length()<1) return false;
		else return true;
	}
	
	public boolean validarEmail(String email) {
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		if(mather.find()) return true;
		else return false;
	}
}