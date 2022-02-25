package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
		
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.estudianteRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.borrar(id);
		
	}

	@Override
	public List<Estudiante> buscarPorEdad(Integer edad) {
		return this.estudianteRepository.buscarPorEdad(edad);
	}

	

}
