package ar.edu.unlam.pb2;

public class Monetaria extends Transaccion{

	private Double monto;
	
	public Monetaria(Cliente cliente, Dispositivo dispositivo, Double monto) {
		super(cliente, dispositivo);
		this.setMonto(monto);
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
}
