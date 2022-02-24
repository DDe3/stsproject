package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_doctor")
	@SequenceGenerator(name = "seq_doctor", sequenceName = "seq_doctor", allocationSize = 1)
	@Column(name="doct_id")
	private Integer id;
	@Column(name="doct_nombre")
	private String nombre;
	@Column(name="doct_apellido")
	private String apellido;
	@Column(name="doct_codiess")
	private String codIess;
	@Column(name="doct_titulo")
	private String titulo;
	@Column(name="doct_genero")
	private Character genero;
	
	public Doctor() {}
	
	
	public Doctor(Integer id, String nombre, String apellido, String codIess, String titulo, Character genero) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.codIess = codIess;
		this.titulo = titulo;
		this.genero = genero;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCodIess() {
		return codIess;
	}
	public void setCodIess(String codIess) {
		this.codIess = codIess;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	
	
	

}
