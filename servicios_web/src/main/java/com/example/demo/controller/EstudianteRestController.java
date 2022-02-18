package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.to.Estudiante;

@RestController
@RequestMapping("/estudiantes/uce")
public class EstudianteRestController {
	
	@GetMapping
	public Estudiante consultar() {
		return new Estudiante(23, "Leonardo", "Salinas", 24);
	}
}
