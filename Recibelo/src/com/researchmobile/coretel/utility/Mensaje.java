package com.researchmobile.coretel.utility;

import android.content.Context;
import android.widget.Toast;

public class Mensaje {
	
	public static void LoginCamposVacios(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

	public void EnProceso(Context context) {
		Toast.makeText(context, "En Proceso de Desarrollo", Toast.LENGTH_LONG).show();
	}

	public void SinConexion(Context context) {
		Toast.makeText(context, "No cuenta con conexion estable", Toast.LENGTH_LONG).show();
	}

	public void ClavesNuevasDiferente(Context context) {
		Toast.makeText(context, "Las claves nuevas no coinsiden", Toast.LENGTH_LONG).show();
	}

	public void ClaveActualDiferente(Context context) {
		Toast.makeText(context, "La clave actual no es correcta", Toast.LENGTH_LONG).show();
		
	}

	public void CamposVacios(Context context) {
		Toast.makeText(context, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
		
	}

	public void UsuarioCreado(Context context) {
		Toast.makeText(context, "El usuario se creo exitosamente", Toast.LENGTH_LONG).show();
		
	}

	public void IntenteNuevamente(Context context) {
		Toast.makeText(context, "Intente nuevamente", Toast.LENGTH_LONG).show();
		
	}

	public void VerMensaje(Context context, String mensaje) {
		Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
		
	}

}
