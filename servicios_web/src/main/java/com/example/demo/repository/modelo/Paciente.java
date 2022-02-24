package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	@SequenceGenerator(sequenceName = "seq_paciente", name = "seq_paciente", allocationSize = 1)
	private Integer id;
	@Column(name="paci_nombre")
	private String nombre;
	@Column(name="paci_apellido")
	private String apellido;
	@Column(name="paci_codseg")
	private String codSeguro;
	@Column(name="paci_genero")
	private Character genero;
	@Column(name="paci_edad")
	private Integer edad;
	@Column(name="paci_ecivil")
	private String estadoCivil;
	
	
	public Paciente() {}
	
	
	public Paciente(Integer id, String nombre, String apellido, String codSeguro, Character genero, Integer edad,
			String estadoCivil) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.codSeguro = codSeguro;
		this.genero = genero;
		this.edad = edad;
		this.estadoCivil = estadoCivil;
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
	public String getCodSeguro() {
		return codSeguro;
	}
	public void setCodSeguro(String codSeguro) {
		this.codSeguro = codSeguro;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
}
