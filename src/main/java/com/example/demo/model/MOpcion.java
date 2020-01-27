package com.example.demo.model;

import com.example.demo.entities.Opcion;

public class MOpcion {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getNombreOpcion() {
		return nombreOpcion;
	}
	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}
	public String getCodigoOpcion() {
		return codigoOpcion;
	}
	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}
	private Integer precio;
	private String nombreOpcion;
	private String codigoOpcion;
	
	public MOpcion()
	{
		
	}
	public MOpcion(Opcion obj)
	{
		id = obj.getId();
		precio =  obj.getPrecio();
		nombreOpcion = obj.getNombreOpcion();
		codigoOpcion = obj.getCodigoOpcion();
		
	}
	public MOpcion(Integer id, Integer precio, String nombreOpcion, String codigoOpcion) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombreOpcion = nombreOpcion;
		this.codigoOpcion = codigoOpcion;
	}
	
	
}
