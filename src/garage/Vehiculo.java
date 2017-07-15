package garage;

public class Vehiculo {

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + "]";
	}

	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
