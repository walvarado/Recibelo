package com.researchmobile.coretel.entity;

public class ItemChat {
	protected long id;
	protected String nombre;
	protected String mensaje;
	
	
	public ItemChat() {
		this.nombre = "";
		this.mensaje = "";
	}
	
	public ItemChat(long id, String nombre, String mensaje) {
		this.id = id;
		this.nombre = nombre;
		this.mensaje = mensaje;
	}
	
	public ItemChat(long id, String nombre, String mensaje, String rutaImagen) {
		this.id = id;
		this.nombre = nombre;
		this.mensaje = mensaje;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
