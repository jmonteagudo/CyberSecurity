package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaParcial {

	@Test
	public void queSePuedaCrearUnCliente() {
		// Preparación
		String CUIT_ESPERADO = "20-33546852-0";
		String NOMBRE_ESPERADO = "Victor Cuesta";
		Denunciable nuevo = new Cliente(CUIT_ESPERADO, NOMBRE_ESPERADO);
		
		// Ejecución
		Cliente nuevoCliente = ((Cliente)nuevo); 
		
		// Verificación
		assertEquals(CUIT_ESPERADO, nuevoCliente.getCuit());
		assertEquals(NOMBRE_ESPERADO, nuevoCliente.getNombre());
	}
	
	@Test
	public void queSePuedaCrearUnDispositivo() {
		// Preparación
		String IP_ESPERADA = "162.168.140.10";
		TipoDeAutenticacion TIPO_AUTENTICACION_ESPERADA = TipoDeAutenticacion.CLAVE_ALFANUMERICA; 
		String LOCALIDAD_ESPERADA = "San Justo";

		Dispositivo pcEscritorio = new Desktop(IP_ESPERADA, TIPO_AUTENTICACION_ESPERADA);
		
		// Ejecución
		pcEscritorio.setLocalidad(LOCALIDAD_ESPERADA);
		
		// Verificación
		assertEquals(IP_ESPERADA, ((Desktop)pcEscritorio).getIp());
		assertEquals(TIPO_AUTENTICACION_ESPERADA, pcEscritorio.getAutenticacion());
		assertEquals(LOCALIDAD_ESPERADA, pcEscritorio.getLocalidad());

	}
	
	@Test
	public void queSePuedaMonitorearUnaExtraccion() {
		// Preparación
		String CUIT_ESPERADO = "20-33546852-0";
		String NOMBRE_ESPERADO = "Victor Cuesta";
		String LOCALIDAD_ESPERADA = "San Justo";
		Double MONTO_ESPERADO = 20000.0;
		
		Denunciable nuevo = new Cliente(CUIT_ESPERADO, NOMBRE_ESPERADO);
		Dispositivo link = new Cajero("168.150.10.21", TipoDeAutenticacion.CLAVE_NUMERICA);
		
		link.setLocalidad(LOCALIDAD_ESPERADA);
		Cliente nuevoCliente = ((Cliente)nuevo); 
		
		// Ejecución
		Extraccion nueva = new Extraccion(nuevoCliente, link, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(nueva, enLinea.obtenerUltimaTransaccionDelCliente(nuevoCliente));
	}
	
	@Test
	public void queSePuedaMonitorearUnaTransferencia() {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		// Ejecución
		Transferencia nueva = new Transferencia(origen, android, destino, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(nueva, enLinea.obtenerUltimaTransaccionDelCliente(origen));
		assertEquals(destino, ((Transferencia)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getDestino());
	}
	
	@Test
	public void queSePuedaMonitorearUnPagoConQR() {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		Integer CODIGO_QR = 1234987531;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		// Ejecución
		PagoConQR nueva = new PagoConQR(origen, android, destino, CODIGO_QR, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(nueva, enLinea.obtenerUltimaTransaccionDelCliente(origen));
		assertEquals(CODIGO_QR, ((PagoConQR)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getCodigoQR());
		assertEquals(destino, ((PagoConQR)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getDestino());
	}
	
	@Test
	public void queSePuedaMonitorearUnPagoDeServicio() {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		Integer CODIGO_LINK = 1234987531;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		// Ejecución
		PagoDeServicio nueva = new PagoDeServicio(origen, android, destino, CODIGO_LINK, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(nueva, enLinea.obtenerUltimaTransaccionDelCliente(origen));
		assertEquals(CODIGO_LINK, ((PagoDeServicio)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getCodigoDePagpLinkOBanelco());
		assertEquals(destino, ((PagoDeServicio)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getDestino());
	}
	
	@Test
	public void queSePuedaMonitorearUnAltaDeUsuario() {
		// Preparación
		String CUIT_USUARIO = "20-33546852-0";
		String NOMBRE_USUARIO = "Victor Cuesta";
		String LOCALIDAD_ESPERADA = "San Justo";
		
		Cliente nuevo = new Cliente(CUIT_USUARIO, NOMBRE_USUARIO);	
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		// Ejecución
		AltaDeUsuario nueva = new AltaDeUsuario(nuevo, android);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(AltaDeUsuario.class, ((Monitoreable)enLinea.obtenerUltimaTransaccionDelCliente(nuevo)).getClass());
	}
	
	@Test
	public void queSePuedaMonitorearUnCambioDeContraseña() {
		// Preparación
		String CUIT_USUARIO = "20-33546852-0";
		String NOMBRE_USUARIO = "Victor Cuesta";
		String LOCALIDAD_ESPERADA = "San Justo";
		
		Cliente nuevo = new Cliente(CUIT_USUARIO, NOMBRE_USUARIO);	
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		// Ejecución
		CambioDeContrasenia nueva = new CambioDeContrasenia(nuevo, android);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(CambioDeContrasenia.class, ((Monitoreable)enLinea.obtenerUltimaTransaccionDelCliente(nuevo)).getClass());
	}
	
	
	@Test
	public void queElScoreDeUnaTransaccionRechazableSinAntecedentesDeCero() {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		Double SALDO = 100000.0;
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		Integer SCORE_ESPERADO = 0;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN, SALDO);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		// Ejecución
		Transferencia anterior = new Transferencia(origen, android, destino, MONTO_ESPERADO);
		Transferencia nueva = new Transferencia(origen, android, destino, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(anterior);
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(SCORE_ESPERADO, ((Rechazable)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getScore());
	}
	
	@Test
	public void queUnaTransaccionAlertablePuedaSerMarcadaComoFraudulenta() {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		Integer CODIGO_LINK = 1234987531;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		PagoDeServicio nueva = new PagoDeServicio(origen, android, destino, CODIGO_LINK, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			e.printStackTrace();
		}
		
		// Ejecución
		enLinea.reportarSospechoso(nueva);
		
		// Verificación
		assertTrue(((PagoDeServicio)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getCasoSospechoso());
	}
	
	@Test
	public void queElScoreDeUnaTransaccionRechazableConNuevoDispositivoDe20Puntos() {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		Double SALDO_ESPERADO = 100000.0;
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		Integer SCORE_ESPERADO = 20;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN, SALDO_ESPERADO);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		Transferencia nueva = new Transferencia(origen, android, destino, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		
		// Ejecución

		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(SCORE_ESPERADO, ((Rechazable)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getScore());
	}
	
	
	@Test
	public void QueUnaTransaccionDeMasDe60PuntosYMenosDeOchentaSeaAlertadaPeroAprobada() {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		Double SALDO = 20000.0;
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		Integer SCORE_ESPERADO = 60;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN, SALDO);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO, SALDO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
		
		Transferencia nueva = new Transferencia(origen, android, destino, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		
		// Ejecución

		try {
			enLinea.monitorear(nueva);
		} catch (FraudeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificación
		assertEquals(SCORE_ESPERADO, ((Rechazable)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getScore());
		assertTrue(((Alertable)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getCasoSospechoso());
	}
	
	
	@Test (expected = FraudeException.class)
	public void queUnaTransaccionDeMasDe80PuntosLanceLaExcepcionFraudeException() throws FraudeException {
		// Preparación
		String CUIT_ORIGEN = "20-33546852-0";
		String NOMBRE_ORIGEN = "Victor Cuesta";
		Double SALDO = 20000.0;
		String LOCALIDAD_ESPERADA = "San Justo";
		String CUIT_DESTINO = "20-38332600-2";
		String NOMBRE_DESTINO = "Delfina Sadous";		
		Double MONTO_ESPERADO = 20000.0;
		Integer SCORE_ESPERADO = 60;
		
		Cliente origen = new Cliente(CUIT_ORIGEN, NOMBRE_ORIGEN, SALDO);
		Cliente destino = new Cliente(CUIT_DESTINO, NOMBRE_DESTINO, SALDO);		
		Dispositivo android = new Celular("A0001A0001", TipoDeAutenticacion.HUELLA);
		
		android.setLocalidad(LOCALIDAD_ESPERADA);
	
		Transferencia fraudulenta = new Transferencia(origen, android, destino, MONTO_ESPERADO);
		Transferencia nueva = new Transferencia(origen, android, destino, MONTO_ESPERADO);
		Monitor enLinea = new Monitor();
		
		// Ejecución
		enLinea.monitorear(fraudulenta);
		enLinea.reportar(fraudulenta);
		enLinea.monitorear(nueva);

		// Verificación
		assertEquals(SCORE_ESPERADO, ((Rechazable)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getScore());
		assertTrue(((Alertable)enLinea.obtenerUltimaTransaccionDelCliente(origen)).getCasoSospechoso());
	}
}
