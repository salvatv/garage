package garage;

import java.util.Arrays;

public class Garage {
	
	private Plaza[] plazas;

	public Plaza[] getPlazas() {
		return plazas;
	}

	public void setPlazas(Plaza[] plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return "Garage [plazas=" + Arrays.toString(plazas) + "]";
	}
	
	

}
