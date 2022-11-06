package ar.edu.unlam.pb2;

import java.util.Set;

public class PagoConQR extends Monetaria implements Rechazable{

	private Integer codigoQR;
	private Cliente destino;
	
	public PagoConQR(Cliente origen, Dispositivo dispositivo, Cliente destino, Integer codigoQR, Double monto) {
		super(origen, dispositivo, monto);
		this.setCodigoQR(codigoQR);
		this.setDestino(destino);
	}

	public Integer getCodigoQR() {
		return codigoQR;
	}

	public void setCodigoQR(Integer codigoQR) {
		this.codigoQR = codigoQR;
	}

	public Cliente getDestino() {
		return destino;
	}

	public void setDestino(Cliente destino) {
		this.destino = destino;
	}

	@Override
	public void monitorear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void monitorear(Set<Denunciable> listaNegra) throws FraudeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer calcularScore(Set<Denunciable> listaNegra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getScore() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
