package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Ciudad;
import com.example.demo.domain.Empleado;
import com.example.demo.domain.Lenguaje;
import com.example.demo.repositories.CiudadRespository;
import com.example.demo.repositories.EmpleadoRespository;
import com.example.demo.repositories.LenguajeRespository;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoRespository REmpleado;
	@Autowired
	private CiudadRespository RCiudad;
	@Autowired
	private LenguajeRespository RLenguaje;
	
	@GetMapping("/empleado/crear")
	public String crear(ModelMap m) {
		m.put("ciudades", RCiudad.findAll());
		m.put("lenguajes", RLenguaje.findAll());
		m.put("view","empleado/crear");
		return "views/_t/main";
	}
	@PostMapping("/empleado/crear")
	public String crear(@RequestParam("nombre")String nombre,@RequestParam("apellidos")String apellidos,@RequestParam("telefono")String telefono,@RequestParam("idciudad")Long idciudad,@RequestParam("idslenguajes")Long idslenguajes[]) {
		Empleado empleado=new Empleado(nombre,apellidos,telefono,RCiudad.findOne(idciudad));
		for (Long idlenguaje:idslenguajes){
			Lenguaje lenguaje=RLenguaje.findOne(idlenguaje);
			empleado.getLenguajes().add(lenguaje);
			lenguaje.getEmpleados().add(empleado);
		}		
		REmpleado.save(empleado);
		return "redirect:/resultado?mensaje=el empleado se ha creado correctamente";
	}
	@GetMapping("/empleado/listar")
	public String listar(ModelMap m) {
		m.put("empleados",REmpleado.findAll());
		m.put("view","empleado/listar");
		return "views/_t/main";
	}
	@GetMapping("/empleado/borrar")
	public String borrar(@RequestParam("id")Long id) {
		REmpleado.delete(id);
		return "redirect:/empleado/listar";
	}
	@GetMapping("/empleado/editar")
	public String editar(@RequestParam("id")Long id,ModelMap m) {
		m.put("empleado", REmpleado.findOne(id));
		m.put("lenguajes", RLenguaje.findAll());
		m.put("ciudades", RCiudad.findAll());
		m.put("view","empleado/editar");
		return "views/_t/main";
	}
	@PostMapping("/empleado/editar")
	public String editar(@RequestParam("id")Long id,@RequestParam("nombre")String nombre,@RequestParam("apellidos")String apellidos,@RequestParam("telefono")String telefono,@RequestParam("idciudad")Long idciudad,@RequestParam("idslenguajes")Long idslenguajes[]) {
		Empleado empleado=REmpleado.findOne(id);
		empleado.setNombre(nombre);
		empleado.setApellidos(apellidos);
		empleado.setTelefono(telefono);
		empleado.setCiudad(RCiudad.findOne(idciudad));
		empleado.getLenguajes().clear();
		for (Long idlenguaje:idslenguajes){
			Lenguaje lenguaje=RLenguaje.findOne(idlenguaje);
			empleado.getLenguajes().add(lenguaje);
			lenguaje.getEmpleados().add(empleado);
		}		
		REmpleado.save(empleado);
		return "redirect:/empleado/listar";
	}
}
