package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;


@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertar(Estudiante estudiante) {
		this.em.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.em.merge(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.em.find(Estudiante.class, id);
	}

	@Override
	public void borrar(Integer id) {
		Estudiante estu = this.buscar(id);
		this.em.remove(estu);
		
	}

	@Override
	public List<Estudiante> buscarPorEdad(Integer edad) {
		// SELECT * FROM estudiante WHERE estu_edad > edad
		// SELECT e FROM Estudiante e WHERE edad > :edad
		TypedQuery<Estudiante> mq = this.em.createQuery("SELECT e FROM Estudiante e WHERE edad > :edad1", Estudiante.class);
		mq.setParameter("edad1", edad);
		return mq.getResultList();
	}

}
