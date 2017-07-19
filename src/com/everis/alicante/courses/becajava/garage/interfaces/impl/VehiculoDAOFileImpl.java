package com.everis.alicante.courses.becajava.garage.interfaces.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.VehiculoDAO;

public class VehiculoDAOFileImpl implements VehiculoDAO {

	@Override
	public Map<String, Vehiculo> readVehiculos() throws IOException {

		Map<String, Vehiculo> vehiculos = new TreeMap<String, Vehiculo>();

		String linea;

		File file = new File("src/resources/Vehiculos.txt");

		FileReader reader = new FileReader(file);

		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {

			if (!linea.contains("NIF")) {
				System.out.println(linea);

				Vehiculo vehiculoTemp = new Vehiculo();

				String[] temp = linea.split(";");

				vehiculoTemp.setMatricula(temp[0]);

				vehiculoTemp.setTipoVehiculo(temp[1]);

				vehiculos.put(vehiculoTemp.getMatricula(), vehiculoTemp);

			}

		}

		reader.close();

		// System.out.println(file.exists());

		return vehiculos;
	}

	@Override
	public void createVehiculo() {
		// TODO Auto-generated method stub

	}

}
