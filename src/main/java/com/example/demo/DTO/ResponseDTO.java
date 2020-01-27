package com.example.demo.DTO;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private String nombre;
	@Override
	public String toString() {
		return "ResponseDTO [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
