package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.to.Doctor;

@RestController
@RequestMapping("/doctor")
public class DoctorRestController {
	
	@GetMapping
	public Doctor consultar() {
		return new Doctor(1,"Pedro","Rodriguez","SJDIWAKD","Cirujano","Masculino");
	}

}
