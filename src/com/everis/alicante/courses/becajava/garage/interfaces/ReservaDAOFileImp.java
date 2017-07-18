package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.sun.security.ntlm.Client;

public class ReservaDAOFileImp implements ReservaDAO {

	@Override
	public void saveReserva(Reserva reserva) throws IOException {

		File file = new File("src/resources/Reservas.txt");

		FileWriter writer = new FileWriter(file, true);

		BufferedWriter buffer = new BufferedWriter(writer);

		buffer.newLine();

		buffer.write(reserva.toTxt());

		buffer.close();

	}

}
