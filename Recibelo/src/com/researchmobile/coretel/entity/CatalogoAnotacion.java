package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class CatalogoAnotacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Anotacion[] anotacion;
	private RespuestaWS respuesta;

	public Anotacion[] getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(Anotacion[] anotacion) {
		this.anotacion = anotacion;
	}

	public RespuestaWS getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(RespuestaWS respuesta) {
		this.respuesta = respuesta;
	}
}
