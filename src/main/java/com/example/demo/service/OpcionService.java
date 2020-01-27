package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.converter.Convertidor;
import com.example.demo.entities.Opcion;
import com.example.demo.model.MOpcion;
import com.example.demo.repository.OpcionRepositorio;
import java.util.List;
@Service("servicio")
public class OpcionService {
	@Autowired
	@Qualifier("repositorio")
	private OpcionRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	public List<MOpcion>obtener()
	{
		List <MOpcion> lista = null;
		List<Opcion> registros = repositorio.findAll();
		
		return convertidor.convertirLista(registros);
	}
}
