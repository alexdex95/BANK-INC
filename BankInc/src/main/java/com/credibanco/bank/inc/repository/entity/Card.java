package com.credibanco.bank.inc.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TARJETAS")
public class Card {

	@Id
	@Column(name = "IDTARJETA", nullable = false)
	private long idTarjeta;

	@Column(name = "NOMBRETITULAR", nullable = false)
	private String nombreTitular;

	@Column(name = "FECHAVENCIMIENTO", nullable = false)
	private LocalDateTime fechaVencimiento;

	@Column(name = "FECHACREACION", nullable = false)
	private LocalDateTime fechaCreacion;

	@Column(name = "SALDO", nullable = false)
	private long saldo;

	@Column(name = "PRODUCTOID", nullable = false)
	private int productoID;

	@Column(name = "ESTADOID", nullable = false)
	private int estadoID;

	public long getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public LocalDateTime getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public int getProductoID() {
		return productoID;
	}

	public void setProductoID(int productoID) {
		this.productoID = productoID;
	}

	public int getEstadoID() {
		return estadoID;
	}

	public void setEstadoID(int estadoID) {
		this.estadoID = estadoID;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

}
