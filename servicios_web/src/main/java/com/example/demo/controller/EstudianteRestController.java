package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.to.RequestEstudiante;

@RestController
@RequestMapping("/estudiante")
public class EstudianteRestController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping
	public Estudiante consultar(@RequestBody RequestEstudiante requestEstudiante) {
		return this.estudianteService.buscar(requestEstudiante.getId());
	}
	
//	@RequestMapping(method= RequestMethod.POST)
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
	
	
}
