package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.MediaType;
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
import com.example.demo.to.RequestEstudiante;

@RestController
@RequestMapping("/ApiEstudiantes/V1")
public class EstudianteRestController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping(value = "/estudiantes/contenido/aceptacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> consultarEstudiante(@RequestBody RequestEstudiante requestEstudiante) {
		return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.buscar(requestEstudiante.getId()));

	}

	@DeleteMapping(path = "/estudiantes/contenido/aceptacion", 
			consumes = MediaType.APPLICATION_XML_VALUE, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> desmantelarEstudiante(@PathParam(value = "eid") Integer eid, @RequestBody RequestEstudiante requestEstudiante) {
		if (eid==requestEstudiante.getId()) {
			estudianteService.borrar(eid);
			return ResponseEntity.status(HttpStatus.OK).body("Estudiante eliminado");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar");
		}
	}

}
