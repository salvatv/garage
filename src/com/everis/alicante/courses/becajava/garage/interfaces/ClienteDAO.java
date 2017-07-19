package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;
import java.util.Map;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;

public interface ClienteDAO {

	void createCliente(Reserva reserva) throws IOException;

	Map<String, Cliente> readClientes() throws IOException;

}
