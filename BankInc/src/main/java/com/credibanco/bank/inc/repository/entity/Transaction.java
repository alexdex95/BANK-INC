package com.credibanco.bank.inc.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSACCIONES")
public class Transaction {

	@Id
	@Column(name = "IDTRANSACCION", nullable = false)
	private int idTransaccion;

	@Column(name = "FECHAMOVIMIENTO", nullable = false)
	private LocalDateTime fechaMovimiento;

	@Column(name = "VALOR", nullable = false)
	private long valor;

	@Column(name = "PRODUCTOID", nullable = false)
	private int productoID;

	@Column(name = "TARJETAID", nullable = false)
	private long tarjetaID;

	@Column(name = "ESTADOID", nullable = false)
	private int estadoID;

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public LocalDateTime getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public int getProductoID() {
		return productoID;
	}

	public void setProductoID(int productoID) {
		this.productoID = productoID;
	}

	public long getTarjetaID() {
		return tarjetaID;
	}

	public void setTarjetaID(long tarjetaID) {
		this.tarjetaID = tarjetaID;
	}

	public int getEstadoID() {
		return estadoID;
	}

	public void setEstadoID(int estadoID) {
		this.estadoID = estadoID;
	}

}
