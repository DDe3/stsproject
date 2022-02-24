package com.example.demo.repository;

import com.example.demo.repository.modelo.Paciente;

public interface IPacienteRepository {
	
	public Paciente buscar(Integer id);
	public void actualizar(Paciente paciente);
	public void insertar(Paciente paciente);
	public void borrar(Integer id);

}
