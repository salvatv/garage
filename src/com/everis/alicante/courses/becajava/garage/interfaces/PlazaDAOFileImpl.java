package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Plaza;

public class PlazaDAOFileImpl implements PlazaDAO {

	@Override
	public List<Plaza> readPlazas() throws IOException {

		List plazas = new ArrayList<Plaza>();

		String linea;

		File file = new File("src/resources/Plazas.txt");

		FileReader reader = new FileReader(file);

		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {

			if (!linea.contains("NUMERO_PLAZA")) {
				System.out.println(linea);

				Plaza plazaTemp = new Plaza();
				
				String[] temp = linea.split(";");
				
				plazaTemp.setNumeroPlaza(Integer.parseInt(temp[0]));
				
				plazaTemp.setPrecio(Double.parseDouble(temp[1]));				

				plazas.add(plazaTemp);
			}

		}

		reader.close();

		// System.out.println(file.exists());

		return plazas;
	}

	@Override
	public void write(Plaza[] plazas) {

	}

	public static void main(String args[]) throws FileNotFoundException, IOException {

		PlazaDAO dao = new PlazaDAOFileImpl();

		dao.readPlazas();

	}

}