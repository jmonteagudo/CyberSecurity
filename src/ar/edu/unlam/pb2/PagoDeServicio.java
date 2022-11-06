package ar.edu.unlam.pb2;

import java.util.Set;

public class PagoDeServicio extends Monetaria implements Alertable{

	private Integer codigoDePagpLinkOBanelco;
	private Cliente destino;
	private Boolean casoSospechoso;
	private Boolean fueFraude;
	
	public PagoDeServicio(Cliente origen, Dispositivo dispositivo, Cliente destino, Integer codigoDePagoLinkOBanelco, Double monto) {
		super(origen, dispositivo, monto);
		this.setCodigoDePagpLinkOBanelco(codigoDePagoLinkOBanelco);
		this.setDestino(destino);
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

	public Integer getCodigoDePagpLinkOBanelco() {
		return codigoDePagpLinkOBanelco;
	}



	public void setCodigoDePagpLinkOBanelco(Integer codigoDePagpLinkOBanelco) {
		this.codigoDePagpLinkOBanelco = codigoDePagpLinkOBanelco;
	}

	@Override
	public void marcarComoCasoSospechoso() {
		this.setCasoSospechoso(true);
	}

	@Override
	public void confirmarSiFueFraude(Boolean fueFraude) {
		this.setFueFraude(fueFraude);
	}

	public Boolean getCasoSospechoso() {
		return casoSospechoso;
	}

	public void setCasoSospechoso(Boolean casoSospechoso) {
		this.casoSospechoso = casoSospechoso;
	}

	public Boolean getFueFraude() {
		return fueFraude;
	}

	public void setFueFraude(Boolean fueFraude) {
		this.fueFraude = fueFraude;
	}
	

}
