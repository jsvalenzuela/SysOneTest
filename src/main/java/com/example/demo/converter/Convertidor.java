package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Opcion;
import com.example.demo.model.MOpcion;

import java.util.ArrayList;
import java.util.List;
@Component("convertidor")
public class Convertidor {

	public List<MOpcion> convertirLista(List<Opcion> opcionLista)
	{
		List<MOpcion> mOpcion = new ArrayList<MOpcion>();
		for(Opcion opc : opcionLista)
		{
			mOpcion.add(new MOpcion(opc));
		}
		return mOpcion;
	}
}
