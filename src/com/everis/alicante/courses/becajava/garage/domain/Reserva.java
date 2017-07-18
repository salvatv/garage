package com.everis.alicante.courses.becajava.garage.domain;

import java.util.Date;

public class Reserva {

	private Plaza plaza;
	private Cliente cliente;
	private Date fechaReserva;
	private Date fechaInicio;
	private Date fechaFin;

	public Plaza getPlaza() {
		return plaza;
	}

	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Reserva [plaza=" + plaza + ", cliente=" + cliente + ", vehiculo=" + cliente.getVehiculo() + ", fechaReserva="
				+ fechaReserva + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	public String toTxt() {

		String str = "";

		str = str.concat(String.valueOf(this.plaza.getNumeroPlaza()));
		str = str.concat(";");
		str = str.concat(this.cliente.getNif());
		str = str.concat(";");
		str = str.concat(this.cliente.getVehiculo().getMatricula());
		str = str.concat(";");
		str = str.concat(this.fechaReserva.toString());

		return str;

	}

}
