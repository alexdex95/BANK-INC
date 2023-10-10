package com.credibanco.bank.inc.repository.entity;

import java.time.LocalDate;

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

	@Column(name = "FECHAVENCIMIENTO", nullable = false)
	private LocalDate fechaVencimiento;

	@Column(name = "FECHACREACION", nullable = false)
	private LocalDate fechaCreacion;

	@Column(name = "SALDO", nullable = false)
	private long saldo;

	@Column(name = "PRODUCTOID", nullable = false)
	private int productoID;

	@Column(name = "CLIENTEID", nullable = false)
	private int clienteID;

	@Column(name = "ESTADOID", nullable = false)
	private int estadoID;

	public long getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
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

	public int getClienteID() {
		return clienteID;
	}

	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}

	public int getEstadoID() {
		return estadoID;
	}

	public void setEstadoID(int estadoID) {
		this.estadoID = estadoID;
	}

}
