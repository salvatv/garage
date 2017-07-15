package garage;

public class Cliente {

	private String nombreCliente, nif;
	
	private Vehiculo vehiculo;

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNif() {
		return nif;
	}

	@Override
	public String toString() {
		return "Cliente [nombreCliente=" + nombreCliente + ", nif=" + nif + ", vehiculo=" + vehiculo + "]";
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
