package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Monitor {
	
	private Set<Denunciable> listaNegra;
	private List<Monitoreable> transacciones;
	private List<Alertable> casosSospechosos;
	
	public Monitor() {
		this.listaNegra = new HashSet<Denunciable>();
		this.transacciones = new ArrayList<Monitoreable>();
		this.casosSospechosos = new ArrayList<Alertable>();
	}

	public void monitorear(Monitoreable nueva) throws FraudeException{
		if(nueva instanceof Rechazable) {
			((Rechazable)nueva).monitorear(this.listaNegra);	
		}
		else {
			nueva.monitorear();
		}
		
		this.transacciones.add(nueva);
	}

	public Monitoreable obtenerUltimaTransaccionDelCliente(Cliente buscado) {
		for(Integer i= transacciones.size()-1; i>=0; i--) {
			Transaccion actual = (Transaccion)transacciones.get(i);
			if(actual.getQuienLaRealiza().equals(buscado)) {
				return transacciones.get(i);		
			}
		}
		return null;
	}

	public void reportarSospechoso(Alertable nueva) {

		Monitoreable buscada = transacciones.get(transacciones.indexOf(nueva));
		if(buscada instanceof Alertable) {
			((Alertable)buscada).marcarComoCasoSospechoso();
		}
		
	}

	public void reportar(Alertable fraudulenta) {
		Monitoreable buscada = transacciones.get(transacciones.indexOf(fraudulenta));
		if(buscada instanceof Alertable) {
			((Alertable)buscada).confirmarSiFueFraude(true);
			listaNegra.add(((Transaccion)buscada).getQuienLaRealiza());
			listaNegra.add(((Transaccion)buscada).getDesdeDondeSerealiza());
		}
		
	}

}
