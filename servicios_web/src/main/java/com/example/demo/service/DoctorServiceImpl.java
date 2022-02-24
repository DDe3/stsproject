package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDoctorRepository;
import com.example.demo.repository.modelo.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	private IDoctorRepository doctorRepository;

	@Override
	public void insertar(Doctor doctor) {
		this.doctorRepository.insertar(doctor);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.doctorRepository.actualizar(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.doctorRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.doctorRepository.borrar(id);
	}
	
	

}
