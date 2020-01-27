package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.demo.entities.Auto;
import com.example.demo.model.MAuto;

@Component("convertidorAutoService")
public class ConvertidorAutoService {
	
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
