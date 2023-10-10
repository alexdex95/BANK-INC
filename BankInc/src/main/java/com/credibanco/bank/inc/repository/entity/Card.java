package com.credibanco.bank.inc.repository.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "TARJETAS")
@Data
@Builder
public class Card {

	@Id
	@Column(name = "IDTARJETA", nullable = false)
	private double idTarjeta;

	@Column(name = "FECHAVENCIMIENTO", nullable = false)
	private Date fechaVencimiento;

	@Column(name = "FECHACREACION", nullable = false)
	private Date fechaCreacion;

	@Column(name = "SALDO", nullable = false)
	private double saldo;

	@Column(name = "PRODUCTOID", nullable = false)
	private int productoID;

	@Column(name = "CLIENTEID", nullable = false)
	private int clienteID;

	@Column(name = "ESTADOID", nullable = false)
	private int estadoID;

}
