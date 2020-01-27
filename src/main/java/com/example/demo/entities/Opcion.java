package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "OPCION")
@Entity
public class Opcion implements Serializable {
	public Opcion(Integer id, Integer precio, String codigoOpcion, String nombreOpcion) {
		super();
		this.id = id;
		this.precio = precio;
		this.codigoOpcion = codigoOpcion;
		this.nombreOpcion = nombreOpcion;
	}
	public Opcion()
	{
		
	}
	@Override
	public String toString() {
		return "Opcion [id=" + id + ", precio=" + precio + ", codigoOpcion=" + codigoOpcion + ", nombreOpcion="
				+ nombreOpcion + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="precio")
	private Integer precio;
	@Column(name="codigoOpcion")
	private String codigoOpcion;
	@Column(name="nombreOpcion")
	private String nombreOpcion;
	
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
	public String getCodigoOpcion() {
		return codigoOpcion;
	}
	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}
	public String getNombreOpcion() {
		return nombreOpcion;
	}
	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}
}
