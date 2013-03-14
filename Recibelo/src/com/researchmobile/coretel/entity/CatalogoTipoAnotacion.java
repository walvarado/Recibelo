package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class CatalogoTipoAnotacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	TipoAnotacion[] tipoAnotacion;
	RespuestaWS respuestaWS;
	public TipoAnotacion[] getTipoAnotacion() {
		return tipoAnotacion;
	}
	public void setTipoAnotacion(TipoAnotacion[] tipoAnotacion) {
		this.tipoAnotacion = tipoAnotacion;
	}
	public RespuestaWS getRespuestaWS() {
		return respuestaWS;
	}
	public void setRespuestaWS(RespuestaWS respuestaWS) {
		this.respuestaWS = respuestaWS;
	}
	
	
}
