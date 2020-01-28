package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name = "AUTO")
@Entity
public class Auto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="codigoAuto")
	private Integer codigoAuto;
	
	@JoinColumn(name = "idOpcion", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private Opcion idOpcion;
	@JoinColumn(name = "idVariante", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private Variante idVariante;
	
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
	@Override
	public String toString() {
		return "Auto [id=" + id + ", codigoAuto=" + codigoAuto + ", idOpcion=" + idOpcion + ", idVariante=" + idVariante
				+ "]";
	}
	
	public Auto(Integer id, Integer codigoAuto, Opcion idOpcion, Variante idVariante) {
		this.id = id;
		this.codigoAuto = codigoAuto;
		this.idOpcion = idOpcion;
		this.idVariante = idVariante;
	}
	
	public Auto() {
		
	}
}
