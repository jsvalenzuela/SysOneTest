package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.model.MOpcion;
import com.example.demo.service.OpcionService;

@RestController
@RequestMapping("/v1")
public class OpcionController {
	@Autowired
	@Qualifier("servicio")
	OpcionService service;
	
	@GetMapping("/opciones")
	public List<MOpcion> obtenerOpciones()
	{
		return service.obtener();
	}
}
