package com.credibanco.bank.inc.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Product {

	@Id
	@Column(name = "IDPRODUCTO", nullable = false)
	private int idProducto;

	@Column(name = "NUMEROPRODUCTO", nullable = false)
	private String numeroProducto;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	public String getNumeroProducto() {
		return numeroProducto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setNumeroProducto(String numeroProducto) {
		this.numeroProducto = numeroProducto;
	}

}
