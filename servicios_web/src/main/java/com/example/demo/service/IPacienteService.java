package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;

public interface IPacienteService {
	
	public Paciente buscar(Integer id);
	public void actualizar(Paciente paciente);
	public void insertar(Paciente paciente);
	public void borrar(Integer id);

}
