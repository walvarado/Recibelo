package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class CatalogoComunidad implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private DetalleComunidad[] comunidad;
	private RespuestaWS respuestaWS;

	public DetalleComunidad[] getComunidad() {
		return comunidad;
	}

	public void setComunidad(DetalleComunidad[] comunidad) {
		this.comunidad = comunidad;
	}

	public RespuestaWS getRespuestaWS() {
		return respuestaWS;
	}

	public void setRespuestaWS(RespuestaWS respuestaWS) {
		this.respuestaWS = respuestaWS;
	}
	
	
}
