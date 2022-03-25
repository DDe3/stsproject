package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.demo.to.ListaEstudiante;
import com.example.demo.to.RequestEstudiante;


@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/ApiEstudiantes/V2/estudiantes")
public class EstudianteRestController2 {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping(path = "/{idEstudiante}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> consultarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante) {
		return ResponseEntity.ok(this.estudianteService.buscar(idEstudiante));

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estudiante> consultarEstudiantes(@PathParam(value = "edad") Integer edad) {
		System.out.println("Estudiantes mayores a "+edad);
		return this.estudianteService.buscarPorEdad(edad);
	}
	
	@GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ListaEstudiante consultarEstudiantes2(@PathParam(value = "edad") Integer edad) {
		System.out.println("Estudiantes mayores a "+edad);
		ListaEstudiante lista = new ListaEstudiante();
		lista.setLista(this.estudianteService.buscarPorEdad(edad));
		return lista;
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertar(@RequestBody Estudiante estudiante) {
		this.estudianteService.insertar(estudiante);
		return "Estudiante insertado";
	}
	

	@PutMapping(path = "/{idEstudiante}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String actualizar(@PathVariable("idEstudiante") Integer idEstudiante, @RequestBody Estudiante estudiante) {
		System.out.println("Peticion");
		estudiante.setId(idEstudiante);
		this.estudianteService.actualizar(estudiante);
		return "Estudiante actualizado";
	}
	
	@PatchMapping(path = "/{idEstudiante}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String patch(@RequestBody Estudiante estudiante, @PathVariable("idEstudiante") Integer idEstudiante) {
		System.out.println("Peticion");
		estudiante.setId(idEstudiante);
		this.estudianteService.actualizar(estudiante);
		return "Estudiante actualizado";
		
	}
	
	@DeleteMapping(path = "/{idEstudiante}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String eliminar(@PathVariable("idEstudiante") Integer idEstudiante) {
		System.out.println("Peticion DELETE");
		this.estudianteService.borrar(idEstudiante);
		return "Estudiante eliminado";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
