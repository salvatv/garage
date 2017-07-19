package com.everis.alicante.courses.becajava.garage.interfaces.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.interfaces.ClienteDAO;

public class ClienteDAOFileImpl implements ClienteDAO {

	@Override
	public Map<String, Cliente> readClientes() throws IOException {

		Map<String, Cliente> clientes = new TreeMap<String, Cliente>();

		String linea;

		File file = new File("src/resources/Clientes.txt");

		FileReader reader = new FileReader(file);

		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {

			if (!linea.contains("NIF")) {
				System.out.println(linea);

				Cliente clienteTemp = new Cliente();

				String[] temp = linea.split(";");

				clienteTemp.setNif(temp[0]);

				clienteTemp.setNombreCliente(temp[1]);

				clientes.put(clienteTemp.getNif(), clienteTemp);
			}

		}

		reader.close();

		// System.out.println(file.exists());

		return clientes;
	}

	@Override
	public void createCliente(Reserva reserva) throws IOException {
		// TODO Auto-generated method stub

	}

}