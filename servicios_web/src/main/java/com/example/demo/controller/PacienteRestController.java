package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.to.Paciente;

@RestController
@RequestMapping("/paciente")
public class PacienteRestController {
	
	@GetMapping
	public Paciente consultar() {
		return new Paciente(1,24,"Leonardo","Salinas","Masculino", "Soltero", 12355);
	}

}
