package com.everis.alicante.courses.becajava.garage.domain;

import java.util.List;
import java.util.Map;

public class Garage {

	private List<Plaza> plazas;
	private Map<String, Reserva> reservas;
	private Map<String, Vehiculo> vehiculos;
	private Map<String, Cliente> clientes;

	public List<Plaza> getPlazas() {
		return plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	public Map<String, Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}

	public Map<String, Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Map<String, Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Map<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Garage [plazas=" + plazas.size() + "]";
	}

}
