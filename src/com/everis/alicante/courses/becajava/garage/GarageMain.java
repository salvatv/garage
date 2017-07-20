package com.everis.alicante.courses.becajava.garage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.everis.alicante.courses.becajava.garage.controller.ControladorGarageConArrays;
import com.everis.alicante.courses.becajava.garage.domain.Garage;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.interfaces.ClienteDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.GarageController;
import com.everis.alicante.courses.becajava.garage.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.VehiculoDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.ClienteDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.PlazaDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.ReservaDAOFileImp;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.VehiculoDAOFileImpl;

public class GarageMain {

	static GarageController controlador;

	static Garage garage;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		inicializarComponentes();

		// iniciar aplicacion o listar menu

		iniciarAplicacion();

	}

	private static void iniciarAplicacion() throws IOException {

		System.out.println("welcome");
		System.out.println("1.- Listar plazas libres");
		System.out.println("2.- Listar plazas ocupadas");
		System.out.println("3.- Ver ingresos");
		System.out.println("4.- Listar clientes");
		System.out.println("5.- Listar vehiculos");
		System.out.println("6.- Reservar plaza");
		System.out.println("7.- Listar Reservas");
		System.out.println("8.-");

		Scanner in = new Scanner(System.in);

		Integer opcion = in.nextInt();

		Boolean plazaa = false;

		System.out.println("Ha elegido la opcion : " + opcion);

		switch (opcion) {
		case 1:

			controlador.listarPlazasLibres();

			break;
		case 2:

			controlador.listarPLazasOcupadas();

			break;

		case 4:

			controlador.listarClientes();

			break;

		case 6:

			plazaa = controlador.reservarPlaza();

			break;

		case 7:

			controlador.listarReservas();

			break;

		default:
			break;
		}

		if (plazaa && opcion == 6) {
			System.out.println("Se ha reservado su plaza.");
		} else if (opcion == 6) {
			System.out.println("No hay plazas reservables.");
		}

		iniciarAplicacion();

		in.close();

	}

	private static void inicializarComponentes() throws FileNotFoundException, IOException {

		garage = new Garage();

		// PlazaDAO plazaDao = new PlazaDAOFileImpl();
		// ReservaDAO reservaDao = new ReservaDAOFileImp();
		// ClienteDAO clienteDao = new ClienteDAOFileImpl();
		// VehiculoDAO vehiculoDao = new VehiculoDAOFileImpl();

		// garage.setPlazas(plazaDao.readPlazas());
		// garage.setClientes(clienteDao.readClientes());
		// garage.setVehiculos(vehiculoDao.readVehiculos());
		// garage.setReservas(reservaDao.readReservas());

		controlador = new ControladorGarageConArrays();

	}

	public static Garage getGarage() {
		return garage;
	}

}
