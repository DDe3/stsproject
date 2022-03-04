package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.to.RequestEstudiante;

@RestController
@RequestMapping("/ApiEstudiantes/V1")
public class EstudianteRestController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping
	public Estudiante consultarRequestBody(@RequestBody RequestEstudiante requestEstudiante) {
		return this.estudianteService.buscar(requestEstudiante.getId());
	}
	
	@GetMapping("/estudiantes/{idEstudiante}")
	@ResponseBody
	public Estudiante consultarPathVariable(@PathVariable("idEstudiante") Integer idEstudiante) {
		return this.estudianteService.buscar(idEstudiante);
	}
	
	@GetMapping("/estudiantes/entidad/{idEstudiante}")
	public ResponseEntity<Estudiante> consultarPathVariableEntidad(@PathVariable("idEstudiante") Integer idEstudiante) {
		return ResponseEntity.ok(this.estudianteService.buscar(idEstudiante));

	}
	
	@GetMapping("/estudiantes/status/personalizado/{idEstudiante}")
	public ResponseEntity<Estudiante> consultarPathVariableEntidadPersonalizado(@PathVariable("idEstudiante") Integer idEstudiante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.estudianteService.buscar(idEstudiante));

	}
	
	@GetMapping("/estudiantes/status/personalizado2/{idEstudiante}")
	public ResponseEntity<Estudiante> consultarPathVariableEntidadPersonalizadoDos(@PathVariable("idEstudiante") Integer idEstudiante) {
		return ResponseEntity.status(230).body(this.estudianteService.buscar(idEstudiante));

	}
	
	@GetMapping("/estudiantes/status/personalizadoHeader/{idEstudiante}")
	public ResponseEntity<Estudiante> consultarPathVariableEntidadPersonalizadoHeader(@PathVariable("idEstudiante") Integer idEstudiante) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("mensaje", "Mensaje personalizado");
		return new ResponseEntity<>(this.estudianteService.buscar(idEstudiante), headers, 231);
	}
	
	
	@GetMapping("/estudiantes")
	public List<Estudiante> consultarRequestParam(@PathParam(value = "edad") Integer edad) {
		System.out.println("Estudiantes mayores a "+edad);
		return this.estudianteService.buscarPorEdad(edad);
	}
	

	@PostMapping
	public String insertar(@RequestBody Estudiante estudiante) {
		this.estudianteService.insertar(estudiante);
		return "Estudiante insertado";
	}
	
	
	@PutMapping
	public String actualizar(@RequestBody Estudiante estudiante) {
		System.out.println("Peticion");
		this.estudianteService.actualizar(estudiante);
		return "Estudiante actualizado";
	}
	
	@DeleteMapping
	public String eliminar(@RequestBody RequestEstudiante requestEstudiante) {
		System.out.println("Peticion DELETE");
		this.estudianteService.borrar(requestEstudiante.getId());
		return "Estudiante eliminado";
	}
	
	@PatchMapping("/actualizacionParcial")
	@ResponseBody
	public String patch(@RequestBody Estudiante estudiante) {
		System.out.println("Peticion");
		this.estudianteService.actualizar(estudiante);
		return "Estudiante actualizado";
		
	}
	
	
}
