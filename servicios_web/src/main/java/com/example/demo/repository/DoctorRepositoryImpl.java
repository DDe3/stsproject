package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

	@Override
	public List<Doctor> buscarPorGenero(Character gen) {
		//SELECT * FROM doctor WHERE doct_genero == gen
		//SELECT d FROM Doctor d WHERE genero == :gen
		TypedQuery<Doctor> mq = this.em.createQuery("SELECT d FROM Doctor d WHERE genero = :gen", Doctor.class);
		mq.setParameter("gen", gen);
		return mq.getResultList();
		
	}

}
