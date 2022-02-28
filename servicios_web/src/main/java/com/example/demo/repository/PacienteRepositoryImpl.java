package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Paciente buscar(Integer id) {
		return this.em.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.em.merge(paciente);
	}

	@Override
	public void insertar(Paciente paciente) {
		this.em.persist(paciente);
	}

	@Override
	public void borrar(Integer id) {
		Paciente pac = this.buscar(id);
		this.em.remove(pac);
	}

	@Override
	public List<Paciente> buscarPorEstadoCivil(String ecivil) {
		TypedQuery<Paciente> mq = em.createQuery("SELECT p FROM Paciente p WHERE estadoCivil=:ecivil", Paciente.class);
		mq.setParameter("ecivil", ecivil);
		return mq.getResultList();
	}
	
}
