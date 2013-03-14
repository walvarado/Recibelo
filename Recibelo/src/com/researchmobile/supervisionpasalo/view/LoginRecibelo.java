package com.researchmobile.supervisionpasalo.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.researchmobile.coretel.entity.UserAsignacion;
import com.researchmobile.coretel.utility.Mensaje;
import com.researchmobile.coretel.ws.RequestWSAsignacion;


public class LoginRecibelo extends Activity implements OnClickListener, OnKeyListener {

	private static final String LOGTAG = "MYLOG";
	private static final String LLENAR_CAMPOS = "Ingresa datos en todos los campos";
	private EditText usuarioEditText;
	private EditText claveEditText;
	private Button entrarButton;
	private TextView olvidoTextView;
	private Mensaje mensaje;
	private UserAsignacion user;
	private ProgressDialog pd = null;
	private boolean logeado;
	private RequestWSAsignacion requestWSAsignacion;
	private AlertDialog.Builder dialogActiveGPS = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginrecibelo);
		
		try
		{
			System.out.println(LoginRecibelo.this);
			setUser(new UserAsignacion());
			setMensaje(new Mensaje());
			setUsuarioEditText((EditText)findViewById(R.id.loginrecibelo_usuario_edittext));
			setClaveEditText((EditText)findViewById(R.id.loginrecibelo_clave_edittext));
			setEntrarButton((Button)findViewById(R.id.loginrecibelo_entrar_button));
			setOlvidoTextView((TextView)findViewById(R.id.loginrecibelo_olvido_textview));
			setRequestWSAsignacion(new RequestWSAsignacion());
			verificaGps();
			
			getOlvidoTextView().setOnKeyListener(this);
			getEntrarButton().setOnClickListener(this);
			getClaveEditText().setOnKeyListener(this);
			getUsuarioEditText().setOnKeyListener(this);
			getUsuarioEditText().setText("");
			getClaveEditText().setText("");
			
		}catch(Exception exception){
			Log.i(LOGTAG, exception.getLocalizedMessage());
		}
	}


	//USO ONCLICK ENTRARBUTTON
	public void onClick(View view) 
	{
	 try
	 {
		 if(view == getEntrarButton())
		 {
			 new LoginAsync().execute("");
			 
		 }
		 
	 } 
	 catch(Exception exception)
	 {
		Log.i(LOGTAG, exception.getLocalizedMessage()); 
	 }
	}	


	//USO DEL ONKEYDOWN
	public boolean onKeyDow(int keyCode, KeyEvent event)
	{
		if(keyCode == KeyEvent.KEYCODE_BACK)
		{
			moveTaskToBack(true);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	private void registrar(){
		Intent intent = new Intent(LoginRecibelo.this, Registrar.class);
		startActivity(intent);
	}
	
	private void Entrar()
	{
		Requerido();
		System.out.println(isLogeado());
	}

	private boolean Requerido() {
		if(CamposLlenos()){
			RequestWSAsignacion request = new RequestWSAsignacion();
			 if(request.LoginRecibelo(getUser()))
			 {
				 setLogeado(true);
				 return true;
			 }else{
				 return false;
			 }
			
		}
		return false;
	}

	//Cargar Anotaciones
	
	
	//METODO CAMPOS LLENOS
	private boolean CamposLlenos() {
		String usernameString = getUsuarioEditText().getText().toString();
		String passwordString = getClaveEditText().getText().toString();
		 if(getUsuarioEditText().getText().toString().equalsIgnoreCase("") || getClaveEditText().getText().toString().equalsIgnoreCase(""))
		 {
			 getMensaje().LoginCamposVacios(this, LLENAR_CAMPOS);
			 return false;
		 }
		 else
		 {
			 getUser().setPassword(passwordString);
			 getUser().setUsername(usernameString);
			 return true;
		 }
	}
		
	//Clase para ejecutar en Background
    class LoginAsync extends AsyncTask<String, Integer, Integer>{

   	 //Metodo que prepara lo que usara en background, Prepara el progress
		@Override
		protected void onPreExecute(){
			pd = ProgressDialog.show(LoginRecibelo.this, "VERIFICANDO DATOS","ESPERE UN MOMENTO");
			pd.setCancelable(false);
		}
		
		//Metodo con las instrucciones que se realizan en background
		@Override
		protected Integer doInBackground(String... urlString) {
			try{
				Entrar();
			}catch(Exception exception){
				
			}
			return null;
		}
		//Metodo con las instrucciones al finalizar lo ejectuado en background
		protected void onPostExecute(Integer resultado){
			pd.dismiss();
			if(isLogeado()){
				Intent intent = new Intent(LoginRecibelo.this, Mapa.class);
	            startActivity(intent);
			}else{
				getMensaje().VerMensaje(LoginRecibelo.this, "NO EXISTE USUARIO");
	 			LimpiaCampos();
			}
			
		}
		//LIMPIA CAMPOS
		private void LimpiaCampos() {
			getClaveEditText().setText("");
			getUsuarioEditText().setText("");
		}
    }

	//VERIFICA GPS
	private void verificaGps()
	{
		dialogActiveGPS = new AlertDialog.Builder(this);
		AlertDialog.Builder dialogActiveGPS = new AlertDialog.Builder(this);
		dialogActiveGPS.setMessage("Desea activarlo ahora?");
		dialogActiveGPS.setCancelable(false);
		dialogActiveGPS.setPositiveButton("Si", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{
				Intent myIntent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
				startActivity(myIntent);
			}
		});
			dialogActiveGPS.setNegativeButton("No", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialog, int which)
				{
					
				}
			});
			LocationManager locationService = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	         LocationListener myLocationListener = new MyLocationListener();
	 		locationService.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, myLocationListener);
	 		if(!locationService.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER ))
	 		{
	 			AlertDialog alert = dialogActiveGPS.create();
	 	        alert.setTitle("NECESITA ACTIVAR GPS");
	 	        alert.show();
	 		}
	}
	public class MyLocationListener implements LocationListener {
 		public void onLocationChanged(Location location) {
 			LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
 			LocationListener locationListener = new MyLocationListener();
 			locationManager.removeUpdates(locationListener);
 		}
 
 		public void onProviderDisabled(String provider) {
			//Toast.makeText(getApplicationContext(), "Gps Desactivado", Toast.LENGTH_SHORT).show();
			
		}

		public void onProviderEnabled(String provider) {
			//Toast.makeText(getApplicationContext(), "Gps Activo", Toast.LENGTH_SHORT).show();
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
 	 }
		
	
	//get y set
	public TextView getOlvidoTextView() {
		return olvidoTextView;
	}

	public void setOlvidoTextView(TextView olvidoTextView) {
		this.olvidoTextView = olvidoTextView;
	}

	public EditText getUsuarioEditText() {
		return usuarioEditText;
	}

	public void setUsuarioEditText(EditText usuarioEditText) {
		this.usuarioEditText = usuarioEditText;
	}

	public EditText getClaveEditText() {
		return claveEditText;
	}

	public void setClaveEditText(EditText claveEditText) {
		this.claveEditText = claveEditText;
	}

	public Button getEntrarButton() {
		return entrarButton;
	}

	public void setEntrarButton(Button entrarButton) {
		this.entrarButton = entrarButton;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public UserAsignacion getUser() {
		return user;
	}

	public void setUser(UserAsignacion user) {
		this.user = user;
	}

	public ProgressDialog getPd() {
		return pd;
	}

	public void setPd(ProgressDialog pd) {
		this.pd = pd;
	}


	public AlertDialog.Builder getDialogActiveGPS() {
		return dialogActiveGPS;
	}

	public void setDialogActiveGPS(AlertDialog.Builder dialogActiveGPS) {
		this.dialogActiveGPS = dialogActiveGPS;
	}

	public static String getLogtag() {
		return LOGTAG;
	}

	public static String getLlenarCampos() {
		return LLENAR_CAMPOS;
	}
	
	public boolean isLogeado(){
		return logeado;
	}
	
	public void setLogeado (boolean logeado){
		this.logeado = logeado;
	}
	

	public RequestWSAsignacion getRequestWSAsignacion() {
		return requestWSAsignacion;
	}

	public void setRequestWSAsignacion(RequestWSAsignacion requestWSAsignacion) {
		this.requestWSAsignacion = requestWSAsignacion;
	}

	
	public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}
