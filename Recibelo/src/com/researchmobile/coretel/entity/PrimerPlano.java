package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class PrimerPlano implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static boolean estado;

	public static boolean isEstado() {
		return estado;
	}

	public static void setEstado(boolean estado) {
		PrimerPlano.estado = estado;
	}
	
}
