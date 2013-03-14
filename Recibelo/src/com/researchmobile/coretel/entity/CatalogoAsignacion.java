package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class CatalogoAsignacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private AnotacionAsignacion[] anotacionasignacion;
	private RespuestaWS respuesta;
	
	public AnotacionAsignacion[] getAnotacionasignacion() {
		return anotacionasignacion;
	}
	public void setAnotacionasignacion(AnotacionAsignacion[] anotacionasignacion) {
		this.anotacionasignacion = anotacionasignacion;
	}
	public RespuestaWS getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaWS respuesta) {
		this.respuesta = respuesta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
