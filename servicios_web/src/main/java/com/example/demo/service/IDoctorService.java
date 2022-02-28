package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Doctor;

public interface IDoctorService {
	
	public void insertar(Doctor doctor);
	public void actualizar(Doctor doctor);
	public Doctor buscar(Integer id);
	public void borrar(Integer id);
	public List<Doctor> buscarPorGenero(Character gen);
}
