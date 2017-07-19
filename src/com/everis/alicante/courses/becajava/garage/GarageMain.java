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

			plazaa = controlador.listarReservas();

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

		PlazaDAO plazaDao = new PlazaDAOFileImpl();
		ReservaDAO reservaDao = new ReservaDAOFileImp();
		ClienteDAO clienteDao = new ClienteDAOFileImpl();
		VehiculoDAO vehiculoDao = new VehiculoDAOFileImpl();

		garage.setPlazas(plazaDao.readPlazas());
		garage.setClientes(clienteDao.readClientes());
		garage.setVehiculos(vehiculoDao.readVehiculos());
		garage.setReservas(reservaDao.readReservas());

		controlador = new ControladorGarageConArrays();

		// List<Plaza> plazas = plazaDao.readPlazas();

		// inicializar los componentes de la app

		// List<Cliente> clientes = new ArrayList<>();
		// List<Vehiculo> vehiculos = new ArrayList<>();
		// List<Plaza> plazas = new ArrayList<>();

		// 4 clientes

		// for (int i = 0; i < 4; i++) {

		// Cliente cliente = new Cliente();
		// Vehiculo coche = new Vehiculo();

		// cliente.setNif("adsds" + i);
		// cliente.setNombreCliente("pepe" + i);

		// coche.setMatricula("1233" + i);

		// vehiculos.add(coche);

		// cliente.setVehiculo(coche);

		// clientes.add(cliente);

		// System.out.println("cliente" + (i + 1) + ":" + cliente);
		// System.out.println("coche" + (i + 1) + ":" + coche);

		// }

		// 4 vehiculos

		// Vehiculo coche = new Vehiculo();

		// coche.setMatricula("12334");

		// vehiculos.add(coche);

		// System.out.println("coche5:" + coche);

		// 30 plazas

		// for (int i = 0; i < 30; i++) {
		//
		// Plaza plaza = new Plaza();
		//
		// if (i < 10) {
		//
		// plaza.setPrecio(50);
		//
		// } else if (i < 20) {
		//
		// plaza.setPrecio(75);
		//
		// } else {
		//
		// plaza.setPrecio(100);
		//
		// }
		//
		// plaza.setNumeroPlaza(i);
		// plazas.add(plaza);

		// }

		// for (int j = 0; j < clientes.size(); j++) {

		// Plaza plaza = plazas.get(j);

		// plaza.setCliente(clientes.get(j));

		// }

		// for (int k = 0; k < plazas.size(); k++) {

		// Plaza plaza = plazas.get(k);

		// System.out.println(plaza);

		// }

		// 1 garage

		// for (int i = 0; i < 1; i++) {
		// garage.setPlazas(plazas);
		// }

		// System.out.println(garage);

	}

	public static Garage getGarage() {
		return garage;
	}

}
