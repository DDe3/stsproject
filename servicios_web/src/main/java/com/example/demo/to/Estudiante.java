package com.example.demo.to;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estudiante")
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@Column(name="estu_id")
	private Integer id;
	@Column(name="estu_nombre")
	private String nombre;
	@Column(name="estu_apellido")
	private String apellido;
	@Column(name="estu_direccion")
	private String direccion;
	@Column(name="estu_edad")
	private Integer edad;
	@Column(name="estu_fechanac")
	private Date fechaNacimiento;
	
	public Estudiante() {}

	public Estudiante(Integer id, String nombre, String apellido, String direccion, Integer edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.fechaNacimiento = new Date(System.currentTimeMillis());
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

	
	
	

}
