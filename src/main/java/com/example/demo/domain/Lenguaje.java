package com.example.demo.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lenguaje {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	@ManyToMany(mappedBy="lenguajes")
	private Collection<Empleado> empleados;
	
	public Lenguaje(){
		this.nombre="desconocido";
	}
	public Lenguaje(String nombre){
		this.nombre=nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Collection<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Collection<Empleado> empleados) {
		this.empleados = empleados;
	}
	public String toString(){
		return this.nombre;
	}

}
