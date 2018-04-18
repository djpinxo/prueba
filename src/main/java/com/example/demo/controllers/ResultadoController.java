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
public class ResultadoController {
	@GetMapping("resultado")
	public String resultado(@RequestParam("mensaje")String mensaje,ModelMap m){
		m.put("view","_t/resultado");
		m.put("mensaje",mensaje);
		return "views/_t/main";
	}
}
