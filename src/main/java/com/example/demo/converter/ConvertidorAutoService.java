package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.entities.Auto;
import com.example.demo.model.MAuto;

@Component("convertidorAutoService")
public class ConvertidorAutoService {
	
	public ResponseDTO generarResponse(List<Auto>listaAuto)
	{
		ResponseDTO response = new ResponseDTO();
		if(!listaAuto.isEmpty())
		{
			boolean primerValor = true;
			String arrayOpciones[] = new String[listaAuto.size()];
			int contadorRegistros = 0;
			boolean poseeOpciones = true;
			Integer precio = 0;
			for(Auto regAuto : listaAuto)
			{
				//verifico que posea opciones
				if(poseeOpciones == true && listaAuto.size() == 1 && regAuto.getIdOpcion() == null)
					poseeOpciones = false;
				if(primerValor == true)
				{
					response.setNombre(regAuto.getIdVariante().getNombre());
					response.setId(regAuto.getCodigoAuto());
					precio = regAuto.getIdVariante().getPrecio();
					primerValor = false;
				}
				
				if(poseeOpciones)
				{
					arrayOpciones[contadorRegistros] = regAuto.getIdOpcion().getCodigoOpcion();
					precio += regAuto.getIdOpcion().getPrecio(); 
				}
					
				
				contadorRegistros++;
			}
			response.setOpcionales(arrayOpciones);
			response.setPrecio(precio);
		}
		return response;
		
	}
	
	public List<MAuto>convertirListaAuto(List<Auto>listaAuto)
	{
		List<MAuto>listaMAuto = new ArrayList<>();
		for(Auto reg : listaAuto)
		{
			listaMAuto.add(new MAuto(reg));
		}
		return listaMAuto;
	}
}
