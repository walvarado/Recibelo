package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class UserChat implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String usuario;
	private String comunidad;
	private String mensaje;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getComunidad() {
		return comunidad;
	}
	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
