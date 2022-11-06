package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Cliente implements Denunciable {

	private String cuit;
	private String nombre;
	private Set<Dispositivo> dispositivosUtilizados;
	private Double saldo;
	
	public Cliente(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
		dispositivosUtilizados = new HashSet<Dispositivo>();
		this.saldo = 0.0;
	}
	
	public Cliente(String cuit, String nombre, Double saldo) {
		this.cuit = cuit;
		this.nombre = nombre;
		dispositivosUtilizados = new HashSet<Dispositivo>();
		this.setSaldo(saldo);
	}

	public void agregarDispositivo(Dispositivo nuevo) {
		dispositivosUtilizados.add(nuevo);
	}

	public String getCuit() {
		return this.cuit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Boolean existeDispositivo(Dispositivo buscado) {
		return dispositivosUtilizados.contains(buscado);
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
