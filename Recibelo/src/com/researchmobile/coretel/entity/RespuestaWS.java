package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class RespuestaWS implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean resultado;
	private String mensaje;
	public boolean isResultado() {
		return resultado;
	}
	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
