package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.DTO.ResponseDTO;
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
	@GetMapping("{codigo}")
	public ResponseDTO obtenerAuto(@PathVariable Integer codigo)
	{
		return service.obtenerAutoPorCodigo(codigo);
	}
	@GetMapping("ruta/{codigo}")
	public ResponseDTO obtenerResponse(@PathVariable Integer codigo)
	{
		return service.devolverCodigoYNombre(codigo);
	}
	@DeleteMapping("/borrarAuto")
	public void borrarAuto(@RequestParam(value="codigoAuto") Integer codigoAuto)
	{
		try
		{
			this.service.borrarAuto(codigoAuto);
		}
		catch(Exception e){
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Error procesando la solicitud. " + e.getMessage(), e);
			
		}
	}
	
	@PostMapping("/guardarAuto")
	public ResponseDTO guardarAuto(@RequestParam(value="idVariante") Integer idVariante, @RequestParam(value="idOpciones[]") Integer[] idOpciones )
	{
		ResponseDTO response = null;
		try
		{
			List<Integer> listaId = null;
			if (idOpciones != null)
			{
				listaId = new ArrayList<Integer>();
				for(int x = 0; x < idOpciones.length; x++)
				{
					listaId.add(idOpciones[x]);
				}
					
			}
			response = service.guardarAuto(idVariante,listaId);
		}
		catch(Exception e){
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Error procesando la solicitud. " + e.getMessage(), e);
			
		}
		return response;
	}
	
}
