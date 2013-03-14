package com.researchmobile.supervisionpasalo.view;

import java.io.Serializable;

import com.researchmobile.coretel.entity.RespuestaWS;

public class CatalogoAsignaciones implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Asignaciones[] asignaciones;
	private RespuestaWS respuesta;
	
	public Asignaciones[] getAsignaciones(){
		return asignaciones;
	}
	
	public void setAsignaciones(Asignaciones[] asignaciones){
		this.asignaciones = asignaciones;
	}
	
	public RespuestaWS getRespuesta(){
		return respuesta;
	}
	
	public void setRespuesta(RespuestaWS respuesta){
		this.respuesta = respuesta;
	}
}
