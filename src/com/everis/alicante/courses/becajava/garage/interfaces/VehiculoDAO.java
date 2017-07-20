package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;
import java.util.Map;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;

public interface VehiculoDAO {

	void createVehiculo(Vehiculo vehiculo);

	Map<String, Vehiculo> readVehiculos() throws IOException;

}
