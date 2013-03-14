package com.researchmobile.supervisionpasalo.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.researchmobile.coretel.entity.ChatUtility;
import com.researchmobile.coretel.entity.RespuestaWS;
import com.researchmobile.coretel.utility.ConnectState;
import com.researchmobile.coretel.utility.Mensaje;
import com.researchmobile.coretel.utility.PhoneInformation;
import com.researchmobile.coretel.ws.ConnectWS;
import com.researchmobile.coretel.ws.RequestWS;

public class Registrar extends Activity implements OnClickListener, OnKeyListener{
	private EditText nombreEditText;
	private EditText emailEditText;
	private EditText telefonoEditText;
	private EditText usuarioEditText;
	private Button enviarButton;
	private Mensaje mensaje;
	private ProgressDialog pd = null;
	private RespuestaWS respuesta;
	private boolean enviado;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        
        setRespuesta(new RespuestaWS());
        
        setMensaje(new Mensaje());
        setNombreEditText((EditText)findViewById(R.id.registrar_nombre_edittext));
        setUsuarioEditText((EditText)findViewById(R.id.registrar_usuario_edittext));
        setEmailEditText((EditText)findViewById(R.id.registrar_email_edittext));
        setTelefonoEditText((EditText)findViewById(R.id.registrar_telefono_edittext));
        setEnviarButton((Button)findViewById(R.id.registrar_enviar_button));
        
        getNombreEditText().setOnKeyListener(this);
        getUsuarioEditText().setOnKeyListener(this);
        getEmailEditText().setOnKeyListener(this);
        getTelefonoEditText().setOnKeyListener(this);
        getEnviarButton().setOnClickListener( this );
        
        MostrarNumeroTelefono();
    }

	private void MostrarNumeroTelefono() {
		PhoneInformation information = new PhoneInformation();
		getTelefonoEditText().setText(information.LineNumber1(Registrar.this));
	}

	@Override
	public void onClick(View view) {
		if (view == getEnviarButton()){
			new RegistroAsync().execute("");
		}
	}
	
	private boolean EnviarDatos() {
		try{
			ConnectState con = new ConnectState();
			if (con.isConnectedToInternet(Registrar.this)){
				String nombre = getNombreEditText().getText().toString();
				String usuario = getUsuarioEditText().getText().toString();
				String email = getEmailEditText().getText().toString();
				String telefono = getTelefonoEditText().getText().toString();
				if(CamposLlenos(nombre, usuario, email, telefono)){
					RequestWS request = new RequestWS();
					setRespuesta(request.CrearUsuario(nombre, usuario, email, telefono));
					if(getRespuesta().isResultado()){
//						RegistrarChat(usuario, nombre);
						return true;
					}else{
						return false;
					}
				}
			}else{
				getRespuesta().setMensaje("No cuenta con internet");
				getRespuesta().setResultado(false);
				getMensaje().SinConexion(this);
				return false;
			}
		}catch(Exception exception){
			getMensaje().IntenteNuevamente(this);
			return false;
		}
		return false;
	}
	
	private void RegistrarChat(String usuario, String nombre) {
		ConnectState connect = new ConnectState();
		ChatUtility chatUtility = new ChatUtility();
		String regId = chatUtility.ChatId(Registrar.this);
		if (connect.isConnectedToInternet(Registrar.this)){
			ConnectWS connectWS = new ConnectWS();
			connectWS.CrearUsuarioChat(usuario, nombre, regId);
		}
		
	}

	// Clase para ejecutar en Background
    class RegistroAsync extends AsyncTask<String, Integer, Integer>{

      //Metodo que prepara lo que usara en background, Prepara el progress
            @Override
            protected void onPreExecute(){
                  pd = ProgressDialog. show(Registrar. this, "ENVIANDO DATOS", "ESPERE UN MOMENTO");
                  pd.setCancelable( false );
           }
           
            //Metodo con las instrucciones que se realizan en background
            @Override
            protected Integer doInBackground(String... urlString) {
                  try {
                	  EnviarDatos();
                 } catch (Exception exception){
                       
                 }
                  return null ;
           }
            //Metodo con las instrucciones al finalizar lo ejectuado en background
            protected void onPostExecute(Integer resultado){
                  pd.dismiss();
                  if (getRespuesta() != null){
                	  getMensaje().VerMensaje(Registrar.this,getRespuesta().getMensaje());
                	  if (getRespuesta().isResultado()){
                		  finish();
                	  }
                  }
           }
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        		moveTaskToBack( true);     
            return true;
        }
        
        return super.onKeyDown(keyCode, event);
    }


    public void DialogoConfirmacion(Context ctx){
    	new AlertDialog.Builder(ctx)
        .setIcon(ctx.getResources().getDrawable(R.drawable.alert))
        .setTitle("REGISTRO EXITOSO")
        .setMessage("Verifique el correo que registro para conocer su contraseña")
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                     finish();
                }
        })
        .show();

    }

	private void LimpiaCampos() {
		getNombreEditText().setText("");
		getEmailEditText().setText("");
		getTelefonoEditText().setText("");
		
	}

	private boolean CamposLlenos(String nombre, String usuario, String email, String telefono) {
		if (!nombre.equalsIgnoreCase("") && !email.equalsIgnoreCase("") && !telefono.equalsIgnoreCase("") && !usuario.equalsIgnoreCase("")){
			return true;
		}
		setRespuesta(new RespuestaWS());
		getRespuesta().setResultado(false);
		getRespuesta().setMensaje("Debe llenar todos los campos");
		return false;
	}

	@Override
	public boolean onKey(View view, int keyCode, KeyEvent event) {
		 if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP)
         {
             if (view == getNombreEditText()){
            	 getUsuarioEditText().requestFocus();
             }else if(view == getUsuarioEditText()){
            	 getEmailEditText().requestFocus();
             }else if (view == getEmailEditText()){
            	 getTelefonoEditText().requestFocus();
             }else if (view == getTelefonoEditText()){
            	 InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            	 imm.hideSoftInputFromWindow(getTelefonoEditText().getWindowToken(), 0);
                 return true;
             }
             return true;
         }
         if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)
         {
             //TODO: When the enter key is pressed
             return true;
         }
         return false;
	}
	
	
	

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public EditText getNombreEditText() {
		return nombreEditText;
	}

	public void setNombreEditText(EditText nombreEditText) {
		this.nombreEditText = nombreEditText;
	}

	public EditText getEmailEditText() {
		return emailEditText;
	}

	public void setEmailEditText(EditText emailEditText) {
		this.emailEditText = emailEditText;
	}

	public EditText getTelefonoEditText() {
		return telefonoEditText;
	}

	public void setTelefonoEditText(EditText telefonoEditText) {
		this.telefonoEditText = telefonoEditText;
	}

	public Button getEnviarButton() {
		return enviarButton;
	}

	public void setEnviarButton(Button enviarButton) {
		this.enviarButton = enviarButton;
	}

	public boolean isEnviado() {
		return enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

	public RespuestaWS getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(RespuestaWS respuesta) {
		this.respuesta = respuesta;
	}

	public EditText getUsuarioEditText() {
		return usuarioEditText;
	}

	public void setUsuarioEditText(EditText usuarioEditText) {
		this.usuarioEditText = usuarioEditText;
	}

	
}
