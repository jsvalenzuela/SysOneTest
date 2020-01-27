package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MAuto;
import com.example.demo.service.AutoService;


@RestController
@RequestMapping("/auto")
public class AutoController {
	@Autowired
	@Qualifier("autoService")
	AutoService service;
	
	@GetMapping("/all")
	public List<MAuto> obtenerOpciones()
	{
		return service.obtener();
	}
}
