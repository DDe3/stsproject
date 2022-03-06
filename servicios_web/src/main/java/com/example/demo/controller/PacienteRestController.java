package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.IPacienteService;
import com.example.demo.to.RequestPaciente;

@RestController
@RequestMapping("/ApiPacientes/V1")
public class PacienteRestController {
	
	@Autowired
	private IPacienteService pacienteService;
	
	@GetMapping
	public Paciente getPaciente(@RequestBody RequestPaciente requestPaciente) {
		return this.pacienteService.buscar(requestPaciente.getId());
	}
	
	@GetMapping("/pacientes/{idPaciente}")
	public Paciente getPacientePathVariable(@PathVariable("idPaciente") Integer id) {
		return this.pacienteService.buscar(id);
	}
	
	@GetMapping("/pacientes")
	public List<Paciente> getPacienteRequestParam(@PathParam(value = "ecivil") String ecivil) {
		return this.pacienteService.buscarPorEstadoCivil(ecivil);
	}
	
	@GetMapping("/pacientes/{idPaciente}/rbody")
	@ResponseBody
	public Paciente consultarResponseBody(@PathVariable("idPaciente") Integer idPaciente) {
		return this.pacienteService.buscar(idPaciente);
	}
	
	@GetMapping("/pacientes/{idPaciente}/status")
	public ResponseEntity<Paciente> consultarResponseEntity(@PathVariable("idPaciente") Integer idPaciente) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("msg", "Paciente consultado");
		return new ResponseEntity<>(this.pacienteService.buscar(idPaciente), headers, 266);
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
