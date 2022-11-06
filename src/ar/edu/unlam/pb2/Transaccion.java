package ar.edu.unlam.pb2;

public abstract class Transaccion implements Monitoreable{
	
	private Integer codigo;
	private Cliente quienLaRealiza;
	private Dispositivo desdeDondeSerealiza;

	public Transaccion(Cliente quienLaRealiza, Dispositivo desdeDondeSeRealiza) {
		this.setQuienLaRealiza(quienLaRealiza);
		this.setDesdeDondeSerealiza(desdeDondeSeRealiza);
	}

	public Cliente getQuienLaRealiza() {
		return quienLaRealiza;
	}

	public void setQuienLaRealiza(Cliente quienLaRealiza) {
		this.quienLaRealiza = quienLaRealiza;
	}

	public Dispositivo getDesdeDondeSerealiza() {
		return desdeDondeSerealiza;
	}

	public void setDesdeDondeSerealiza(Dispositivo desdeDondeSerealiza) {
		this.desdeDondeSerealiza = desdeDondeSerealiza;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public void monitorear() {
		quienLaRealiza.agregarDispositivo(desdeDondeSerealiza);
	}
}
