package ar.edu.unlam.pb2;

public class Dispositivo implements Denunciable {
	
	private TipoDeAutenticacion autenticacion;
	private String localidad;
	
	public Dispositivo(TipoDeAutenticacion autenticacion) {
		this.autenticacion = autenticacion;
	}

	public TipoDeAutenticacion getAutenticacion() {
		return autenticacion;
	}

	public void setAutenticacion(TipoDeAutenticacion autenticacion) {
		this.autenticacion = autenticacion;
	}

	protected String getLocalidad() {
		return localidad;
	}

	protected void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

}
