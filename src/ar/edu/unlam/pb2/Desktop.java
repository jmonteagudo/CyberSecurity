package ar.edu.unlam.pb2;

public class Desktop extends Dispositivo {

	private String ip;
	
	public Desktop(String ip, TipoDeAutenticacion autenticacion) {
		super(autenticacion);
		this.setIp(ip);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
}
