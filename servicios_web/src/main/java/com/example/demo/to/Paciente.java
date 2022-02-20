package com.example.demo.to;

public class Paciente {
	
	private Integer id, edad;
	private String nombre, apellido, genero, eCivil;
	private Integer codSeguro;
	
	public Paciente() {}
	
	public Paciente(Integer id, Integer edad, String nombre, String apellido, String genero, String eCivil,
			Integer codSeguro) {
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.eCivil = eCivil;
		this.codSeguro = codSeguro;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String geteCivil() {
		return eCivil;
	}
	public void seteCivil(String eCivil) {
		this.eCivil = eCivil;
	}
	public Integer getCodSeguro() {
		return codSeguro;
	}
	public void setCodSeguro(Integer codSeguro) {
		this.codSeguro = codSeguro;
	}
	
	

}
