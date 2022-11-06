package ar.edu.unlam.pb2;

import java.util.Set;

public interface Rechazable {
	
	public void monitorear(Set<Denunciable> listaNegra) throws FraudeException;
	public Integer calcularScore(Set<Denunciable> listaNegra);
	public Integer getScore();
	public Integer UMBRAL_RECHAZO = 80;
	public Integer UMBRAL_ALERTA = 60;
	public Integer SCORE_DISPOSITIVO_NUEVO = 20;
	public Integer SCORE_IMPORTE_IGUAL_AL_SALDO = 40;
	public Integer SCORE_CUIT_INVOLUCRADO_EN_FRAUDE_PREVIO = 80;
	public Integer SCORE_DISPOSITIVO_INVOLUCRADO_EN_FRAUDE_PREVIO = 80;


}
