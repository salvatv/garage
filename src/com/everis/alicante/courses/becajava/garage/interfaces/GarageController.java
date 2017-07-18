package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;

public interface GarageController {

	void listarPlazasLibres();
	void listarPLazasOcupadas();
	boolean reservarPlaza() throws IOException;
}
