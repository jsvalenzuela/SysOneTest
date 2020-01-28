package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.converter.ConvertidorAutoService;
import com.example.demo.entities.Auto;
import com.example.demo.entities.Opcion;
import com.example.demo.entities.Variante;
import com.example.demo.model.MAuto;
import com.example.demo.repository.AutoRepositorio;
import com.example.demo.repository.OpcionRepositorio;
import com.example.demo.repository.VarianteRepositorio;


@Service("autoService")
public class AutoService {
	@Autowired
	@Qualifier("repositorioAuto")
	private AutoRepositorio autoRepositorio;
	@Autowired
	private OpcionService opcionService;
	@Autowired
	private VarianteService varianteService;
	
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
	
	//con el codigo del auto lo borro
	public void borrarAuto(Integer codigoAuto) throws Exception
	{
		List<Auto> listaAuto = this.autoRepositorio.findByCodigoAuto(codigoAuto);
		if(listaAuto != null && !listaAuto.isEmpty())
		{
			this.autoRepositorio.deleteAll(listaAuto);
		}
		else
		{
			throw new Exception("Auto Inexistente. Intente nuevamente");
		}
	}
	
	public ResponseDTO devolverCodigoYNombre(Integer codigoAuto)
	{
		ResponseDTO response = new ResponseDTO();
		Auto auto = this.autoRepositorio.findOneByCodigoAuto(codigoAuto);
		response.setId(auto.getId());
		response.setNombre(auto.getIdVariante().getNombre());
		return response;
	}
	
	public ResponseDTO guardarAuto(Integer idVariante, List<Integer> listaId) throws Exception
	{
		ResponseDTO response = null;
		if(idVariante != null)
		{
			response = new ResponseDTO();
			Variante va = this.varianteService.obtenerVariante(idVariante);
			if(va != null)
			{
				Integer maxCodigo = this.autoRepositorio.devolverCodigoAutoMaximo();
				List<Opcion> listaOpcion = null;
				if(listaId != null && !listaId.isEmpty())
				{
					Integer cantidadOpciones = this.opcionService.devolverCantidadOpciones(listaId);
					if(cantidadOpciones < listaId.size())
						throw new Exception("Una de las variantes no existe");
					listaOpcion = this.opcionService.devolverOpcionConListadoId(listaId);
				}
				maxCodigo++;
				List<Auto> autosLista = generarRegistrosInsert(maxCodigo, va, listaOpcion);
				this.autoRepositorio.saveAll(autosLista);
				response = this.convertidorAutoService.generarResponse(autosLista);
			}
			else
			{
				throw new Exception("No existe la variante buscada");
			}
		}
		else
		{
			throw new Exception("campo idVariante vacio");
		}
		return response;
	}
	
	private List<Auto> generarRegistrosInsert(Integer codigoAuto,Variante variante,List<Opcion> listaOpcion)
	{
		List<Auto> autoLista = new ArrayList<Auto>();
		if(listaOpcion != null)
		{
			for(Opcion opc : listaOpcion)
			{
				Auto aux = new Auto();
				aux.setIdOpcion(opc);
				aux.setCodigoAuto(codigoAuto);
				aux.setIdVariante(variante);
				autoLista.add(aux);
			}
		}
		else
		{
			Auto aux = new Auto();
			aux.setCodigoAuto(codigoAuto);
			aux.setIdVariante(variante);
			autoLista.add(aux);
		}
		return autoLista;
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
