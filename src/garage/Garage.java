package garage;

import java.util.ArrayList;
import java.util.List;

public class Garage {

	private List<Plaza> plazas;

	public List<Plaza> getPlazas() {
		return plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return "Garage [plazas=" + plazas.size() + "]";
	}

}
