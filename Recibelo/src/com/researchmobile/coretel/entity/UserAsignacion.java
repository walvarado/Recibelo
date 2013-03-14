package com.researchmobile.coretel.entity;

import java.io.Serializable;

public class UserAsignacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static String username;
	private static String password;
	private static String userId;
	private static String email;
	private RespuestaWS respuestaWs;
	
	public RespuestaWS getRespuestaWs() {
		return respuestaWs;
	}
	public void setRespuestaWs(RespuestaWS respuestaWs) {
		this.respuestaWs = respuestaWs;
	}
	public static String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
