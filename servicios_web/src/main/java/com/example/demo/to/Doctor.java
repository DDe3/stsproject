package com.example.demo.to;

public class Doctor {
	
	
	private Integer id;
	private String nombre, apellido, iess, titulo, genero;
	
	
	public Doctor() {}
	
	public Doctor(Integer id, String nombre, String apellido, String iess, String titulo, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.iess = iess;
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
	public String getIess() {
		return iess;
	}
	public void setIess(String iess) {
		this.iess = iess;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

}
