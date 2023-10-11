package com.credibanco.bank.inc.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RECARGAS")
public class Recharge {

	@Id
	@Column(name = "IDRECARGA", nullable = false)
	private int idRecarga;

	@Column(name = "FECHARECARGA", nullable = false)
	private LocalDateTime fechaRecarga;

	@Column(name = "VALOR", nullable = false)
	private long valor;

	@Column(name = "TARJETAID", nullable = false)
	private long tarjetaID;

	public int getIdRecarga() {
		return idRecarga;
	}

	public void setIdRecarga(int idRecarga) {
		this.idRecarga = idRecarga;
	}

	public LocalDateTime getFechaRecarga() {
		return fechaRecarga;
	}

	public void setFechaRecarga(LocalDateTime fechaRecarga) {
		this.fechaRecarga = fechaRecarga;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public long getTarjetaID() {
		return tarjetaID;
	}

	public void setTarjetaID(long tarjetaID) {
		this.tarjetaID = tarjetaID;
	}

	public Recharge() {
		super();
	}

	public Recharge(LocalDateTime fechaRecarga, long valor, long tarjetaID) {
		super();
		this.fechaRecarga = fechaRecarga;
		this.valor = valor;
		this.tarjetaID = tarjetaID;
	}

}
