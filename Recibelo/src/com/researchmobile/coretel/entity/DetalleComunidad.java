package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class DetalleComunidad implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nombre;
	private String descripcion;
	private String activo;
	RespuestaWS respuestaWS;
	
	
	public String toString(){
		return nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public RespuestaWS getRespuestaWS() {
		return respuestaWS;
	}
	public void setRespuestaWS(RespuestaWS respuestaWS) {
		this.respuestaWS = respuestaWS;
	}
	
	
}


