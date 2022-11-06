package ar.edu.unlam.pb2;

public class Celular extends Dispositivo {

	private String iMei;

	public Celular(String iMei, TipoDeAutenticacion autenticacion) {

		super(autenticacion);
		this.iMei = iMei;
	}

}
