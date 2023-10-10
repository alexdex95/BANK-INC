package com.credibanco.bank.inc.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "PRODUCTOS")
@Data
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "IDPRODUCTO", nullable = false)
	private int idProducto;

	@Column(name = "NUMEROPRODUCTO", nullable = false)
	private String numeroProducto;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	public String getNumeroProducto() {
		return numeroProducto;
	}

}
