package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.service.IDoctorService;
import com.example.demo.to.RequestDoctor;

@RestController
@RequestMapping("/ApiDoctores/V1")
public class DoctorRestController {
	
	@Autowired
	private IDoctorService doctorService;
	
	
	@GetMapping
	public Doctor getDoctor(@RequestBody RequestDoctor requestDoctor) {
		return this.doctorService.buscar(requestDoctor.getId());
	}
	
	@GetMapping("/doctores/{idDoctor}")
	public Doctor getDoctorPathVariable(@PathVariable("idDoctor") Integer id) {
		return this.doctorService.buscar(id);
	}
	
	@GetMapping("/doctores")
	public List<Doctor> getDoctorPathVariable(@PathParam(value="genero")Character genero) {
		return this.doctorService.buscarPorGenero(genero);
	}
	
	
	@PostMapping
	public String insertarDoctor(@RequestBody Doctor doctor) {
		this.doctorService.insertar(doctor);
		return "Doctor insertado";
	}
	
	@PutMapping
	public String actualizarDoctor(@RequestBody Doctor doctor) {
		this.doctorService.actualizar(doctor);
		return "Doctor actualizado";
	}
	
	@DeleteMapping
	public String borrarDoctor(@RequestBody RequestDoctor requestDoctor) {
		this.doctorService.borrar(requestDoctor.getId());
		return "Doctor eliminado";
	}
	

}
