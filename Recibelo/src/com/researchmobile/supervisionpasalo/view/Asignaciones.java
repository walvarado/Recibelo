package com.researchmobile.supervisionpasalo.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Asignaciones extends Activity {

	private EditText CreacionEditText;
	private EditText AsignacionEditText;
	private EditText ResueltoEditText;
	private TextView ComunidadTextView;
	private TextView TipoTextView;
	
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.asignaciones);
		
			setCreacionEditText((EditText)findViewById(R.id.asignaciones_creacion_edittext));
			setAsignacionEditText((EditText)findViewById(R.id.asignaciones_asignacion_edittext));
			setResueltoEditText((EditText)findViewById(R.id.asignaciones_resuelto_edittext));
			setComunidadTextView((TextView)findViewById(R.id.asignaciones_comunidad_textview));
			setTipoTextView((TextView)findViewById(R.id.asignaciones_tipo_textview));
			
		}



		public EditText getCreacionEditText() {
			return CreacionEditText;
		}

		public void setCreacionEditText(EditText creacionEditText) {
			CreacionEditText = creacionEditText;
		}

		public EditText getAsignacionEditText() {
			return AsignacionEditText;
		}

		public void setAsignacionEditText(EditText asignacionEditText) {
			AsignacionEditText = asignacionEditText;
		}

		public EditText getResueltoEditText() {
			return ResueltoEditText;
		}

		public void setResueltoEditText(EditText resueltoEditText) {
			ResueltoEditText = resueltoEditText;
		}

		public TextView getComunidadTextView() {
			return ComunidadTextView;
		}

		public void setComunidadTextView(TextView comunidadTextView) {
			ComunidadTextView = comunidadTextView;
		}

		public TextView getTipoTextView() {
			return TipoTextView;
		}

		public void setTipoTextView(TextView tipoTextView) {
			TipoTextView = tipoTextView;
		}

		
}
