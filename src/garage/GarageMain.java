package garage;

public class GarageMain {

	public static void main(String[] args) {

		// inicializar los componentes de la app

		// 4 clientes
		for (int i = 0; i < 4; i++) {

			Cliente cliente = new Cliente();
			Vehiculo coche = new Vehiculo();
			cliente.setNif("adsds" + i);
			cliente.setNombreCliente("pepe" + i);
			coche.setMatricula("1233" + i);
			cliente.setVehiculo(coche);
			System.out.println("cliente:" + cliente);
			System.out.println("coche:" + coche);
		}
		// 5 vehiculos

		// 30 plaza

		for (int i = 0; i < 4; i++) {

			Cliente cliente = new Cliente();
			Vehiculo coche = new Vehiculo();
			cliente.setNif("adsds" + i);
			cliente.setNombreCliente("pepe" + i);
			coche.setMatricula("1233" + i);
			cliente.setVehiculo(coche);
			System.out.println("cliente:" + cliente);
			System.out.println("coche:" + coche);
		}
		// 1 garage

		// inicializarComponentes();

	}

	// public static void ilicializarComponentes(){}

}
