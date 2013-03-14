package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class AnotacionAsignacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private Integer activo;
	private Integer id_estado;
	private String fecha_registro;
	private float latitud;
	private float longitud;
	private String archivo;
	private String nombreComunidad;
	private String nombreUsuario;
	private String id;
	private String estadoAnotacion;
	private String nombreTipoAnotacion;
	private String icono;
	private Integer visto;
	private String asignado;
	private String respuesta;
	private String nombreSupervisor;
	private String orden;
	private Integer id_comunidad;
	private String format_fecha_asignado;
	private Multimedia[] multimedia;
	private String hace_tiempo;
	
	public String getHace_tiempo() {
		return hace_tiempo;
	}
	public void setHace_tiempo(String hace_tiempo) {
		this.hace_tiempo = hace_tiempo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getNombreComunidad() {
		return nombreComunidad;
	}
	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEstadoAnotacion() {
		return estadoAnotacion;
	}
	public void setEstadoAnotacion(String estadoAnotacion) {
		this.estadoAnotacion = estadoAnotacion;
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
	public String getNombreSupervisor() {
		return nombreSupervisor;
	}
	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}
	
	
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public Integer getVisto() {
		return visto;
	}
	public void setVisto(Integer visto) {
		this.visto = visto;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Integer getId_comunidad() {
		return id_comunidad;
	}
	public void setId_comunidad(Integer id_comunidad) {
		this.id_comunidad = id_comunidad;
	}
	public String getFormat_fecha_asignado() {
		return format_fecha_asignado;
	}
	public void setFormat_fecha_asignado(String format_fecha_asignado) {
		this.format_fecha_asignado = format_fecha_asignado;
	}
	public Multimedia[] getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia[] multimedia) {
		this.multimedia = multimedia;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getAsignado() {
		return asignado;
	}
	public void setAsignado(String asignado) {
		this.asignado = asignado;
	}
}
