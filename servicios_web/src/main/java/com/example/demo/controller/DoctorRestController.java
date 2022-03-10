package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IDoctorService;
import com.example.demo.to.RequestDoctor;

@RestController
@RequestMapping("/ApiDoctores/V1")
public class DoctorRestController {

	@Autowired
	private IDoctorService doctorService;


	@PostMapping(value = "/doctores/contenido", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> postDoctor(@RequestBody Doctor doctor) {
		doctorService.insertar(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body("Doctor insertado");
	}

	@PutMapping(value = "/doctores/contenido", 
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> putDoctor(@RequestBody Doctor doctor) {
		doctorService.actualizar(doctor);
		return ResponseEntity.ok("Doctor Actualizado");
	}

	@GetMapping
	public Doctor getDoctor(@RequestBody RequestDoctor requestDoctor) {
		return this.doctorService.buscar(requestDoctor.getId());
	}
}
