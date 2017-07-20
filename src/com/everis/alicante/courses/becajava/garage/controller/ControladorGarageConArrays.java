package com.everis.alicante.courses.becajava.garage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.everis.alicante.courses.becajava.garage.GarageMain;
import com.everis.alicante.courses.becajava.garage.domain.Camion;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Coche;
import com.everis.alicante.courses.becajava.garage.domain.Garage;
import com.everis.alicante.courses.becajava.garage.domain.Moto;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.Aparcable;
import com.everis.alicante.courses.becajava.garage.interfaces.ClienteDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.GarageController;
import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.VehiculoDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.ClienteDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.ReservaDAOFileImp;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.VehiculoDAOFileImpl;

public class ControladorGarageConArrays implements GarageController {

	@Override
	public void listarPlazasLibres() {

		List<Plaza> plazasLibres = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMain.getGarage().getPlazas();

		for (int i = 0; i < plazas.size(); i++) {

			Plaza plaza = plazas.get(i);

			if (plaza.getLibre()) {
				plazasLibres.add(plaza);
			}

		}

		// listar por pantalla

		for (Plaza plaza : plazasLibres) {

			System.out.println(plaza);

		}
	}

	@Override
	public void listarPLazasOcupadas() {

		List<Plaza> plazasOcupadas = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMain.getGarage().getPlazas();

		for (int i = 0; i < plazas.size(); i++) {

			Plaza plaza = plazas.get(i);

			if (!plaza.getLibre()) {
				plazasOcupadas.add(plaza);
			}

		}

		// listar por pantalla

		for (Plaza plaza : plazasOcupadas) {

			System.out.println(plaza);

		}

	}

	@Override
	public boolean reservarPlaza() throws IOException {

		boolean hayplaza = false;

		// crear cliente

		Cliente cliente = new Cliente();

		ReservaDAO daoReserva = new ReservaDAOFileImp();
		ClienteDAO daoCliente = new ClienteDAOFileImpl();
		VehiculoDAO daoVehiculo = new VehiculoDAOFileImpl();

		// escribir menu datos cliente

		Scanner in = new Scanner(System.in);

		System.out.println("Introduce nombre cliente");
		String nomCliente = in.nextLine();
		cliente.setNombreCliente(nomCliente);

		System.out.println("Introduce nif del ciente");
		String nifCliente = in.nextLine();
		cliente.setNif(nifCliente);

		System.out.println("Tipo de vehiculo: ");
		System.out.println("1. Coche.");
		System.out.println("2. Moto.");
		System.out.println("3. Camion.");

		String option = in.nextLine();

		Vehiculo vehiculoCliente = new Vehiculo();

		switch (option) {
		case "1":
			vehiculoCliente = new Coche();
			break;

		case "2":
			vehiculoCliente = new Moto();
			break;

		case "3":
			vehiculoCliente = new Camion();
			break;

		default:
			vehiculoCliente = null;
			break;
		}

		System.out.print("Inserte la matrícula del vehículo: ");
		String matricula = in.nextLine();
		vehiculoCliente.setMatricula(matricula);
		vehiculoCliente.setTipoVehiculo(vehiculoCliente.getClass().getSimpleName());

		cliente.setVehiculo(vehiculoCliente);

		// logica de si hay vacias

		Garage garage = GarageMain.getGarage();

		List<Plaza> plazas = garage.getPlazas();

		for (int i = 0; i < plazas.size(); i++) {

			Plaza plaza = plazas.get(i);

			if (plaza.getLibre() && vehiculoCliente instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza = true;

				Reserva reserva = new Reserva();

				reserva.setCliente(cliente);
				reserva.setPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				reserva.setCodigoReserva(String.valueOf(plaza.getNumeroPlaza()));

				daoReserva.saveReserva(reserva);

				daoCliente.createCliente(cliente);

				daoVehiculo.createVehiculo(vehiculoCliente);

				return hayplaza;
			}

		}

		in.close();

		return hayplaza;

		// si hay plazas libres set cliente a la plaza

	}

	@Override
	public void listarClientes() throws IOException {

		ClienteDAO daoCliente = new ClienteDAOFileImpl();

		Map<String, Cliente> clientes = daoCliente.readClientes();

		Collection<Cliente> collection = clientes.values();

		for (Iterator<Cliente> iterator = collection.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			System.out.println(cliente.getNombreCliente());
			System.out.println("-------------------------------------------------");
		}

	}

	@Override
	public void listarReservas() throws IOException {

		ReservaDAO reservaDao = new ReservaDAOFileImp();
		Map<String, Reserva> reservas = reservaDao.readReservas();

		Collection<Reserva> listaReservas = reservas.values();

		for (Reserva reserva : listaReservas) {

			System.out.println("num reserva: " + reserva.getPlaza().getNumeroPlaza());
			System.out.println("cliente :" + reserva.getCliente().getNif());
			System.out.println("matriculo :" + reserva.getCliente().getVehiculo().getMatricula());
			System.out.println("tipo vehiculo :" + reserva.getCliente().getVehiculo().getTipoVehiculo());

		}

	}

}
