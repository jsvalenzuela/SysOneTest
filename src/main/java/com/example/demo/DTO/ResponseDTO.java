package com.example.demo.DTO;

import java.io.Serializable;
import java.util.Arrays;

public class ResponseDTO implements Serializable {
	private Integer id;
	private String nombre;
	private String opcionales[];
	private Integer precio;
	
	
	@Override
	public String toString() {
		return "ResponseDTO [id=" + id + ", nombre=" + nombre + ", opcionales=" + Arrays.toString(opcionales)
				+ ", precio=" + precio + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getOpcionales() {
		return opcionales;
	}
	public void setOpcionales(String[] codigoOpcionListado) {
		this.opcionales = codigoOpcionListado;
	}
	
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	
	
}
