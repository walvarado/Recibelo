package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class CatalogoMiembro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Miembro[] miembro;
	private RespuestaWS respuestaWS;
	public Miembro[] getMiembro() {
		return miembro;
	}
	public void setMiembro(Miembro[] miembro) {
		this.miembro = miembro;
	}
	public RespuestaWS getRespuestaWS() {
		return respuestaWS;
	}
	public void setRespuestaWS(RespuestaWS respuestaWS) {
		this.respuestaWS = respuestaWS;
	}

	
}
