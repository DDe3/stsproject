package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.IPacienteService;
import com.example.demo.to.RequestEstudiante;
import com.example.demo.to.RequestPaciente;

@RestController
@RequestMapping("/ApiPacientes/V1")
public class PacienteRestController {
	
	@Autowired
	private IPacienteService pacienteService;
	

	@GetMapping(value = "/pacientes/contenido", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Paciente> encontrarPaciente(@RequestBody RequestPaciente requestPaciente) {
		return ResponseEntity.ok(pacienteService.buscar(requestPaciente.getId()));
	}
	
	@PatchMapping(value = "/pacientes/contenido", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> patchPaciente(@RequestBody Paciente paciente) {
		this.pacienteService.actualizar(paciente);
		return ResponseEntity.ok("Paciente actualizado parcialmente");
	}
	
	
	

}
