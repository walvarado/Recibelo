package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class Miembro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String fecha_registro;
	private String id_comunidad;
	private String id_usuario;
	private String usuario_invito;
	private String nombreUsuario;
	private String nombreUsuarioInvito;
	private String nombreComunidad;
	private String telefono;
	private String email;
	public String toString(){
		return nombreUsuario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getId_comunidad() {
		return id_comunidad;
	}
	public void setId_comunidad(String id_comunidad) {
		this.id_comunidad = id_comunidad;
	}
	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUsuario_invito() {
		return usuario_invito;
	}
	public void setUsuario_invito(String usuario_invito) {
		this.usuario_invito = usuario_invito;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombreUsuarioInvito() {
		return nombreUsuarioInvito;
	}
	public void setNombreUsuarioInvito(String nombreUsuarioInvito) {
		this.nombreUsuarioInvito = nombreUsuarioInvito;
	}
	public String getNombreComunidad() {
		return nombreComunidad;
	}
	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
