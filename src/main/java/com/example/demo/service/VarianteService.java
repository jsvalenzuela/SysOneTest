package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Variante;
import com.example.demo.repository.VarianteRepositorio;

@Service("varianteService")
public class VarianteService {

	@Autowired
	@Qualifier("repositorioVariante")
	private VarianteRepositorio repositorio;
	
	public Variante obtenerVariante(Integer idVariante)
	{
		return this.repositorio.findById(idVariante);
	}
}
