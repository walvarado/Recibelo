package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class Multimedia implements Serializable {
 private static final long serialVersionUID = 1L;

 private Integer id;
 private Integer tipo_multimedia;
 private String dato;
 private Integer anotacion;
 private String nombreTipoMultimedia;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getTipo_multimedia() {
	return tipo_multimedia;
}
public void setTipo_multimedia(Integer tipo_multimedia) {
	this.tipo_multimedia = tipo_multimedia;
}
public String getDato() {
	return dato;
}
public void setDato(String dato) {
	this.dato = dato;
}
public Integer getAnotacion() {
	return anotacion;
}
public void setAnotacion(Integer anotacion) {
	this.anotacion = anotacion;
}
public String getNombreTipoMultimedia() {
	return nombreTipoMultimedia;
}
public void setNombreTipoMultimedia(String nombreTipoMultimedia) {
	this.nombreTipoMultimedia = nombreTipoMultimedia;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
 
 
 
}
