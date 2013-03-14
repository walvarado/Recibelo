package com.researchmobile.coretel.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
	
	
		private Calendar calendar = Calendar.getInstance();
		
		public int Semana (){
			int semana = getCalendar().get(Calendar.WEEK_OF_MONTH);
			return semana;
		}
		
		public String Dia (){
			String dia = null;
			if (getCalendar().get(Calendar.DAY_OF_WEEK) == 1){
	        	dia = "DOMINGO";
	        }else if (getCalendar().get(Calendar.DAY_OF_WEEK) == 2){
	        	dia = "LUNES";
	        }else if (getCalendar().get(Calendar.DAY_OF_WEEK) == 3){
	        	dia = "MARTES";
	        } else if (getCalendar().get(Calendar.DAY_OF_WEEK) == 4){
	        	dia = "MIERCOLES";
	        }else if (getCalendar().get(Calendar.DAY_OF_WEEK) == 5){
	        	dia = "JUEVES";
	        }else if (getCalendar().get(Calendar.DAY_OF_WEEK) == 6){
	        	dia = "VIERNER";
	        }else if (getCalendar().get(Calendar.DAY_OF_WEEK) == 7){
	        	dia = "SABADO";
	        }
			
			return dia;
		}
		
		public String FechaHoy () {
			int dia = 0;
			int mes = 0;
			int anio = 0;
			String fecha = null;
			
			dia = getCalendar().get(Calendar.DAY_OF_MONTH);
			mes = getCalendar().get(Calendar.MONTH ) + 1;
			anio = getCalendar().get(Calendar.YEAR);
			fecha = ""+dia+"/"+mes+"/"+anio;
			
			return fecha;
		}
		
		public String Hora(){
			String hora = null;
			String minuto = null;
			String segundo = null;
			
			String horaFinal = null;
			
			hora = "" + getCalendar().get(Calendar.HOUR);
			minuto = "" + getCalendar().get(Calendar.MINUTE);
			
			horaFinal = hora + ":" + minuto;
			
			return horaFinal;
		}
		
		public String semanaSiguiente(){
			int dia = 0;
			//int mes = 0;
			//int anio = 0;
			String fecha = null;
			dia = getCalendar().get(Calendar.DAY_OF_MONTH);
			//mes = getCalendar().get(Calendar.MONTH);
			//fecha = ""+anio+"/"+mes+"/"+(dia + 3);
			
			getCalendar().set(Calendar.DAY_OF_MONTH, dia + 4);
			Date f = getCalendar().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			fecha = sdf.format(f);
			return fecha;
		}
		
		public Calendar getCalendar() {
			return calendar;
		}
		public void setCalendar(Calendar calendar) {
			this.calendar = calendar;
		}
	}
