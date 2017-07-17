package garage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GarageMain {

	static GarageController controlador;

	public static void main(String[] args) {

		inicializarComponentes();

		// iniciar aplicacion o listar menu

		iniciarAplicacion();

	}

	private static void iniciarAplicacion() {

		System.out.println("welcome");
		System.out.println("1.- Listar plazas libres");
		System.out.println("2.- Listar plazas ocupadas");
		System.out.println("3.- Ver ingresos");
		System.out.println("4.- Reservar plaza");
		System.out.println("5.-");
		System.out.println("6.-");
		System.out.println("7.-");
		System.out.println("8.-");

		Scanner in = new Scanner(System.in);

		Integer opcion = in.nextInt();

		System.out.println("Ha elegido la opcion : " + opcion);

		switch (opcion) {
		case 1:

			controlador.listarPlazasLibres();

			break;
		case 2:

			controlador.listarPLazasOcupadas();

			break;

		default:
			break;
		}

	}

	private static void inicializarComponentes() {

		// inicializar los componentes de la app

		List<Cliente> clientes = new ArrayList<>();
		List<Vehiculo> vehiculos = new ArrayList<>();
		List<Plaza> plazas = new ArrayList<>();

		// 4 clientes

		for (int i = 0; i < 4; i++) {

			Cliente cliente = new Cliente();
			Vehiculo coche = new Vehiculo();

			cliente.setNif("adsds" + i);
			cliente.setNombreCliente("pepe" + i);

			coche.setMatricula("1233" + i);

			vehiculos.add(coche);

			cliente.setVehiculo(coche);

			clientes.add(cliente);

			// System.out.println("cliente" + (i + 1) + ":" + cliente);
			// System.out.println("coche" + (i + 1) + ":" + coche);

		}

		// 5 vehiculos

		Vehiculo coche = new Vehiculo();

		coche.setMatricula("12334");

		vehiculos.add(coche);

		// System.out.println("coche5:" + coche);

		// 30 plazas

		for (int i = 0; i < 30; i++) {

			Plaza plaza = new Plaza();

			if (i < 10) {

				plaza.setPrecio(50);

			} else if (i < 20) {

				plaza.setPrecio(75);

			} else {

				plaza.setPrecio(100);

			}

			plaza.setNumeroPlaza(i);
			plazas.add(plaza);

		}

		for (int j = 0; j < clientes.size(); j++) {

			Plaza plaza = plazas.get(j);

			plaza.setCliente(clientes.get(j));

		}

		for (int k = 0; k < plazas.size(); k++) {

			Plaza plaza = plazas.get(k);

			// System.out.println(plaza);

		}

		// 1 garage

		Garage garage = new Garage();

		for (int i = 0; i < 1; i++) {
			garage.setPlazas(plazas);
		}

		// System.out.println(garage);

		controlador = new ControladorGarageConArrays();

	}

}
