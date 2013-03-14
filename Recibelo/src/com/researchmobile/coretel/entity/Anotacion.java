package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class Anotacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String idAnotacion;
	private String idcomunidad;
	private String descripcion;
	private String fecha_registro;
	private int activo;
	private String usuario_anoto;
	private String tipo_anotacion;
	private String nombreUsuario;
	private String nombreComunidad;
	private String nombreTipoAnotacion;
	private String icono;
	private String imagen;
	private float latitud;
	private float longitud;
	public String getIdAnotacion() {
		return idAnotacion;
	}
	public void setIdAnotacion(String idAnotacion) {
		this.idAnotacion = idAnotacion;
	}
	public String getIdcomunidad() {
		return idcomunidad;
	}
	public void setIdcomunidad(String idcomunidad) {
		this.idcomunidad = idcomunidad;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getUsuario_anoto() {
		return usuario_anoto;
	}
	public void setUsuario_anoto(String usuario_anoto) {
		this.usuario_anoto = usuario_anoto;
	}
	public String getTipo_anotacion() {
		return tipo_anotacion;
	}
	public void setTipo_anotacion(String tipo_anotacion) {
		this.tipo_anotacion = tipo_anotacion;
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
	public String getNombreTipoAnotacion() {
		return nombreTipoAnotacion;
	}
	public void setNombreTipoAnotacion(String nombreTipoAnotacion) {
		this.nombreTipoAnotacion = nombreTipoAnotacion;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	

}
