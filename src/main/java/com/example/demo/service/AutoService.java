package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.converter.ConvertidorAutoService;
import com.example.demo.entities.Auto;
import com.example.demo.model.MAuto;
import com.example.demo.repository.AutoRepositorio;


@Service("autoService")
public class AutoService {
	@Autowired
	@Qualifier("repositorioAuto")
	private AutoRepositorio autoRepositorio;
	@Autowired
	@Qualifier("convertidorAutoService")
	private ConvertidorAutoService convertidorAutoService;
	
	public List<MAuto>obtener()
	{
		List<MAuto>listaMAuto = null;
		List<Auto> listaAuto = autoRepositorio.findAll();
		if(listaAuto != null)
			listaMAuto = convertidorAutoService.convertirListaAuto(listaAuto);
		return listaMAuto;
	}
	
	public ResponseDTO devolverCodigoYNombre(Integer codigoAuto)
	{
		ResponseDTO response = new ResponseDTO();
		Auto auto = this.autoRepositorio.findOneByCodigoAuto(codigoAuto);
		response.setId(auto.getId());
		response.setNombre(auto.getIdVariante().getNombre());
		return response;
	}
	
	public  ResponseDTO obtenerAutoPorCodigo(Integer codigoAuto)
	{
		ResponseDTO response = null;
		List<Auto> listaAuto = this.autoRepositorio.findByCodigoAuto(codigoAuto);
		if(listaAuto != null)
		{
			response = this.convertidorAutoService.generarResponse(listaAuto);
		}
		return response;
	}
}
