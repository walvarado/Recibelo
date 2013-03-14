package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class CatalogoInvitacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Invitacion[] invitacion;
	private RespuestaWS respuestaWS;
	public Invitacion[] getInvitacion() {
		return invitacion;
	}
	public void setInvitacion(Invitacion[] invitacion) {
		this.invitacion = invitacion;
	}
	public RespuestaWS getRespuestaWS() {
		return respuestaWS;
	}
	public void setRespuestaWS(RespuestaWS respuestaWS) {
		this.respuestaWS = respuestaWS;
	}
}
