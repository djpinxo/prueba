package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Ciudad;
import com.example.demo.domain.Lenguaje;
import com.example.demo.repositories.CiudadRespository;
import com.example.demo.repositories.LenguajeRespository;

@Controller
public class LenguajeController {
	@Autowired
	private LenguajeRespository RLenguaje;
	
	@GetMapping("/lenguaje/crear")
	public String crear(ModelMap m) {
		m.put("view","lenguaje/crear");
		return "views/_t/main";
	}
	@PostMapping("/lenguaje/crear")
	public String crear(@RequestParam("nombre")String nombre) {
		RLenguaje.save(new Lenguaje(nombre));
		return "redirect:/resultado?mensaje=la lenguaje se ha creado correctamente";
	}
	@GetMapping("/lenguaje/listar")
	public String listar(ModelMap m) {
		m.put("lenguajes",RLenguaje.findAll());
		m.put("view","lenguaje/listar");
		return "views/_t/main";
	}
	@GetMapping("/lenguaje/borrar")
	public String borrar(@RequestParam("id")Long id) {
		RLenguaje.delete(id);
		return "redirect:/lenguaje/listar";
	}
	@GetMapping("/lenguaje/editar")
	public String editar(@RequestParam("id")Long id,ModelMap m) {
		m.put("lenguaje", RLenguaje.findOne(id));
		m.put("view","lenguaje/editar");
		return "views/_t/main";
	}
	@PostMapping("/lenguaje/editar")
	public String editar(@RequestParam("id")Long id,@RequestParam("nombre")String nombre) {
		Lenguaje lenguaje=RLenguaje.findOne(id);
		lenguaje.setNombre(nombre);
		RLenguaje.save(lenguaje);
		return "redirect:/lenguaje/listar";
	}
}
