package com.example.demo.repository;

import com.example.demo.to.Estudiante;

public interface IEstudianteRepository {
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscar(Integer id);
	public void borrar(Integer id);
}
