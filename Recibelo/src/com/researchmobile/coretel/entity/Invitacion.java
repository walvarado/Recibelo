package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class Invitacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String fechaIntento;
	private String fechaRegistro;
	private String idUsuario;
	private String idComunicad;
	private String usuarioInvito;
	private String codigoInvitacion;
	private String email;
	private String telefono;
	private String estado;
	private String intentos;
	private String nombreUsuario;
	private String nombreComunidad;
	private String usuarioInvita;
	private String miembros;
	
	public String toString(){
		return nombreComunidad;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFechaIntento() {
		return fechaIntento;
	}
	public void setFechaIntento(String fechaIntento) {
		this.fechaIntento = fechaIntento;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdComunicad() {
		return idComunicad;
	}
	public void setIdComunicad(String idComunicad) {
		this.idComunicad = idComunicad;
	}
	public String getUsuarioInvito() {
		return usuarioInvito;
	}
	public void setUsuarioInvito(String usuarioInvito) {
		this.usuarioInvito = usuarioInvito;
	}
	public String getCodigoInvitacion() {
		return codigoInvitacion;
	}
	public void setCodigoInvitacion(String codigoInvitacion) {
		this.codigoInvitacion = codigoInvitacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIntentos() {
		return intentos;
	}
	public void setIntentos(String intentos) {
		this.intentos = intentos;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombreComunidad() {
		return nombreComunidad;
	}
	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}
	public String getUsuarioInvita() {
		return usuarioInvita;
	}
	public void setUsuarioInvita(String usuarioInvita) {
		this.usuarioInvita = usuarioInvita;
	}
	public String getMiembros() {
		return miembros;
	}
	public void setMiembros(String miembros) {
		this.miembros = miembros;
	}
	
}

