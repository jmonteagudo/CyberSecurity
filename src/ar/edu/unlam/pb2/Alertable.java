package ar.edu.unlam.pb2;

public interface Alertable {

	public void marcarComoCasoSospechoso();
	public void confirmarSiFueFraude(Boolean fueFraude);
	public Boolean getCasoSospechoso();
	public Boolean getFueFraude();
	
}
