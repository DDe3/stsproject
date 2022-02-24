package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPacienteRepository;
import com.example.demo.repository.modelo.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService {

	
	@Autowired
	private IPacienteRepository pacienteRepository;
	
	
	
	@Override
	public Paciente buscar(Integer id) {
		return this.pacienteRepository.buscar(id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.pacienteRepository.actualizar(paciente);
	}

	@Override
	public void insertar(Paciente paciente) {
		this.pacienteRepository.insertar(paciente);
	}

	@Override
	public void borrar(Integer id) {
		this.pacienteRepository.borrar(id);
	}
	
	

}
