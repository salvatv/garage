package garage;

import java.util.ArrayList;
import java.util.List;

public class GarageMain {

	public static void main(String[] args) {

		inicializarComponentes();

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

			System.out.println("cliente" + (i + 1) + ":" + cliente);
			System.out.println("coche" + (i + 1) + ":" + coche);

		}

		// 5 vehiculos

		Vehiculo coche = new Vehiculo();

		coche.setMatricula("12334");

		vehiculos.add(coche);

		System.out.println("coche5:" + coche);

		// 30 plazas

		for (int i = 0; i < 30; i++) {

			Plaza plaza = new Plaza();

			plaza.setPrecio(0);
			plazas.add(plaza);

		}

		for (int j = 0; j < clientes.size(); j++) {

			Plaza plazaa = plazas.get(j);

			plazaa.setCliente(clientes.get(j));

		}

		for (int k = 0; k < plazas.size(); k++) {

			Plaza plaza = plazas.get(k);

			System.out.println(plaza);

		}

		// 1 garage

		Garage garage = new Garage();
		
		for (int i = 0; i < 1; i++) {
			garage.setPlazas(plazas);
		}

		

		System.out.println(garage);

	}

}
