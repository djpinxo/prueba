package com.example.demo.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudad {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	@OneToMany(mappedBy="ciudad")
	private Collection<Empleado> empleados;
	
	public Ciudad(){
		this.nombre="desconocido";
	}
	public Ciudad(String nombre){
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
