package com.example.demo.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Empleado {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String apellidos;
	private String telefono;
	@ManyToOne
	private Ciudad ciudad;
	@ManyToMany
	private Collection<Lenguaje> lenguajes;
	
	public Empleado(){
		this.nombre="desconocido";
		this.apellidos="";
		this.telefono="";
		this.ciudad=null;
		this.lenguajes=new HashSet<Lenguaje>();
	}
	public Empleado(String nombre,String apellidos,String telefono,Ciudad ciudad){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.telefono=telefono;
		this.ciudad=ciudad;
		this.lenguajes=new HashSet<Lenguaje>();
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
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Collection<Lenguaje> getLenguajes() {
		return lenguajes;
	}
	public void setLenguajes(Collection<Lenguaje> lenguajes) {
		this.lenguajes = lenguajes;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String toString(){
		return this.nombre+this.apellidos+this.telefono;
	}

}
