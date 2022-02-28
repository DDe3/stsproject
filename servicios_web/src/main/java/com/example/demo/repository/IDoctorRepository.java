package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Doctor;

public interface IDoctorRepository {
	public void insertar(Doctor doctor);
	public void actualizar(Doctor doctor);
	public Doctor buscar(Integer id);
	public void borrar(Integer id);
	public List<Doctor> buscarPorGenero(Character genero);
}
