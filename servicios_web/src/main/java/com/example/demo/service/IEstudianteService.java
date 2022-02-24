package com.example.demo.service;

import com.example.demo.to.Estudiante;

public interface IEstudianteService {
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscar(Integer id);
	public void borrar(Integer id);
}
