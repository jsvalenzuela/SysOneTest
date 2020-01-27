package com.example.demo.model;

import com.example.demo.entities.Auto;
import com.example.demo.entities.Opcion;
import com.example.demo.entities.Variante;

public class MAuto {
	private Integer id;
	private Integer codigoAuto;
	private Opcion idOpcion;
	private Variante idVariante;
	
	public MAuto(Integer id, Integer codigoAuto, Opcion idOpcion, Variante idVariante) {
		super();
		this.id = id;
		this.codigoAuto = codigoAuto;
		this.idOpcion = idOpcion;
		this.idVariante = idVariante;
	}
	public MAuto()
	{
		
	}
	public MAuto(Auto obj)
	{
		id = obj.getId();
		codigoAuto = obj.getCodigoAuto();
		idOpcion = obj.getIdOpcion();
		idVariante = obj.getIdVariante();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodigoAuto() {
		return codigoAuto;
	}
	public void setCodigoAuto(Integer codigoAuto) {
		this.codigoAuto = codigoAuto;
	}
	public Opcion getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(Opcion idOpcion) {
		this.idOpcion = idOpcion;
	}
	public Variante getIdVariante() {
		return idVariante;
	}
	public void setIdVariante(Variante idVariante) {
		this.idVariante = idVariante;
	}
}
