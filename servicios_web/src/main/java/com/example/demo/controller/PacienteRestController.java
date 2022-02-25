package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.IPacienteService;
import com.example.demo.to.RequestPaciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteRestController {
	
	@Autowired
	private IPacienteService pacienteService;
	
	@GetMapping
	public Paciente getPaciente(@RequestBody RequestPaciente requestPaciente) {
		return this.pacienteService.buscar(requestPaciente.getId());
	}
	
	@PostMapping
	public String insertarPaciente(@RequestBody Paciente paciente) {
		this.pacienteService.insertar(paciente);
		return "Paciente insertado";
	}
	
	@PutMapping
	public String actualizarPaciente(@RequestBody Paciente paciente) {
		this.pacienteService.actualizar(paciente);
		return "Paciente actualizado";
	}
	
	@DeleteMapping
	public String borrarPaciente(@RequestBody RequestPaciente requestPaciente) {
		this.pacienteService.borrar(requestPaciente.getId());
		return "Paciente eliminado";
	}
	
	

}
