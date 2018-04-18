package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Ciudad;
import com.example.demo.repositories.CiudadRespository;

@Controller
public class CiudadController {
	@Autowired
	private CiudadRespository RCiudad;
	
	@GetMapping("/ciudad/crear")
	public String crear(ModelMap m) {
		m.put("view","ciudad/crear");
		return "views/_t/main";
	}
	@PostMapping("/ciudad/crear")
	public String crear(@RequestParam("nombre")String nombre) {
		RCiudad.save(new Ciudad(nombre));
		return "redirect:/resultado?mensaje=la ciudad se ha creado correctamente";
	}
	@GetMapping("/ciudad/listar")
	public String listar(ModelMap m) {
		m.put("ciudades",RCiudad.findAll());
		m.put("view","ciudad/listar");
		return "views/_t/main";
	}
	@GetMapping("/ciudad/borrar")
	public String borrar(@RequestParam("id")Long id) {
		RCiudad.delete(id);
		return "redirect:/ciudad/listar";
	}
	@GetMapping("/ciudad/editar")
	public String editar(@RequestParam("id")Long id,ModelMap m) {
		m.put("ciudad", RCiudad.findOne(id));
		m.put("view","ciudad/editar");
		return "views/_t/main";
	}
	@PostMapping("/ciudad/editar")
	public String editar(@RequestParam("id")Long id,@RequestParam("nombre")String nombre) {
		Ciudad ciudad=RCiudad.findOne(id);
		ciudad.setNombre(nombre);
		RCiudad.save(ciudad);
		return "redirect:/ciudad/listar";
	}
}
