package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertar(Doctor doctor) {
		this.em.persist(doctor);
		
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.em.merge(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.em.find(Doctor.class, id);
	}

	@Override
	public void borrar(Integer id) {
		Doctor doc = this.buscar(id);
		this.em.remove(doc);
	}

}
