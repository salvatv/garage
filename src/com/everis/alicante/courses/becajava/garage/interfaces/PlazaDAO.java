package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;

public interface PlazaDAO {

	List <Plaza> readPlazas() throws FileNotFoundException, IOException;
	
	void write(Plaza[] plazas);
	
}
