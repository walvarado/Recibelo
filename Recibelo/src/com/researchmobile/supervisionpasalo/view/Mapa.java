package com.researchmobile.supervisionpasalo.view;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.researchmobile.coretel.entity.CatalogoAnotacion;
import com.researchmobile.coretel.entity.CatalogoAsignacion;
import com.researchmobile.coretel.entity.CatalogoComunidad;
import com.researchmobile.coretel.utility.TokenizerUtility;
import com.researchmobile.coretel.ws.RequestWS;
import com.researchmobile.coretel.ws.RequestWSAsignacion;
import com.researchmobile.supervisionpasalo.view.MapItemizedOverlaySelect.OnSelectPOIListener;

public class Mapa extends MapActivity implements OnItemClickListener{
	private static final String LOG = "Recibelo - Mapa";
	private MapController mapController;
	private MyLocationOverlay myLocationOverlay;
	private MapView mapView;
	protected List<Overlay> mapOverlays;
	private MapItemizedOverlaySelect itemizedoverlay;
	private CatalogoAnotacion catalogoAnotacion;
	
	private Button btnSatelite = null;
	private Button btnCentrar = null;
	private Button btnAnimar = null;
	//Declare
	private LinearLayout slidingPanel;
	private boolean isExpanded;
	private DisplayMetrics metrics;	
	private RelativeLayout headerPanel;
	private RelativeLayout menuPanel;
	private int panelWidth;
	private ImageView menuViewButton;
	private ListView lView;
	private ProgressDialog pd = null;
	private CatalogoComunidad catalogoComunidad;
	private TokenizerUtility tokenizer =new TokenizerUtility();
	private RequestWSAsignacion requestWSAsignacion;
	private CatalogoAsignacion catalogoAsignacion;
	
	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters ;
	LinearLayout.LayoutParams listViewParameters;
	
	final List<GeoPoint> list = new ArrayList<GeoPoint>();
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        setRequestWSAsignacion(new RequestWSAsignacion());
        
        new buscaAnotacionesAsync().execute("");
    }
    
    
    private void setRequestWSAsignacion(RequestWSAsignacion requestWS2) {
		// TODO Auto-generated method stub
	}

	private void inicializar(){
    	/***
         * MENU
         */
        
        String lv_items[] = { "Mapa", "Asignaciones", "Cerrar sesión" };

      lView = (ListView) findViewById(R.id.lista);
      // Set option as Multiple Choice. So that user can able to select more the one option from list
      lView.setAdapter(new ArrayAdapter<String>(this,
      android.R.layout.simple_list_item_1, lv_items));
      lView.setOnItemClickListener(this);
      animationMenu();
        
        
//        Bundle bundle = (Bundle)getIntent().getExtras();
//        setCatalogoAnotacion((CatalogoAnotacion)bundle.get("anotaciones"));
        btnSatelite = (Button)findViewById(R.id.BtnSatelite);
        btnCentrar = (Button)findViewById(R.id.BtnCentrar);
        btnAnimar = (Button)findViewById(R.id.BtnAnimar);
        inicializeMap();
        mapOverlays = mapView.getOverlays();
        
    	
        itemizedoverlay = new MapItemizedOverlaySelect();     
        mapOverlays.add(itemizedoverlay);    
        VerificarPuntos(list);
        itemizedoverlay.setOnSelectPOIListener(new OnSelectPOIListener() {   
        	public void onSelectPOI(int latitud, int longitud) {
        		GeoPoint loc = new GeoPoint((int)(latitud), (int)(longitud));
        		list.add(loc);
        		agregaPuntos(loc, "nuevo", "nuevo punto");
        	}
        });
        	
		btnSatelite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try{
					if (mapView.isSatellite()){
						mapView.setSatellite(false);
					}else{
						mapView.setSatellite(true);
					}
				}catch(Exception exception){
					
				}
				
			}
		});

		btnCentrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try{
					GeoPoint loc = new GeoPoint(myLocationOverlay.getMyLocation().getLatitudeE6(), 
							myLocationOverlay.getMyLocation().getLongitudeE6());
					
					list.add(loc);
	        		agregaPuntos(loc, "nuevo", "nuevo punto");
	                mapController.animateTo(myLocationOverlay.getMyLocation());
	            }catch(Exception exception){
					
				}
		}
		});

		btnAnimar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try {
					GeoPoint loc = new GeoPoint(myLocationOverlay
							.getMyLocation().getLatitudeE6(), myLocationOverlay
							.getMyLocation().getLongitudeE6());

					mapController.animateTo(loc);

					int zoomActual = mapView.getZoomLevel();
					for (int i = zoomActual; i < 10; i++) {
						mapController.zoomIn();
					}
				} catch (Exception exception) {

				}

			}
		});
	
    }
    
private void CargarAsignaciones() {
		RequestWSAsignacion requestWS = new RequestWSAsignacion();
		setCatalogoAsignacion(requestWS.CatalogoAsignacion("1"));
		System.out.println(getCatalogoAsignacion().getRespuesta().getMensaje());
}

//Metodo que prepara lo que usara en background, Prepara el progress
protected void onPreExecute() {
      pd = ProgressDialog. show(Mapa.this, "VERIFICANDO DATOS", "ESPERE UN MOMENTO");
      pd.setCancelable( false);
}

// Metodo con las instrucciones que se realizan en background
protected Integer doInBackground(String... urlString) {
      try {
      	CargarAsignaciones();
     } catch (Exception exception) {

     }
      return null ;
}

// Metodo con las instrucciones al finalizar lo ejectuado en background
protected void onPostExecute(Integer resultado) {
      pd.dismiss();
      inicializar();

}   
 
private void animationMenu(){
    	//Initialize
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels)*0.75);
	
		headerPanel = (RelativeLayout) findViewById(R.id.header);
		headerPanelParameters = (LinearLayout.LayoutParams) headerPanel.getLayoutParams();
		headerPanelParameters.width = metrics.widthPixels;
		headerPanel.setLayoutParams(headerPanelParameters);
		
		menuPanel = (RelativeLayout) findViewById(R.id.menuPanel);
		menuPanelParameters = (FrameLayout.LayoutParams) menuPanel.getLayoutParams();
		menuPanelParameters.width = panelWidth;
		menuPanel.setLayoutParams(menuPanelParameters);
		
		slidingPanel = (LinearLayout) findViewById(R.id.slidingPanel);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);
		
		//Slide the Panel	
		menuViewButton = (ImageView) findViewById(R.id.menuViewButton);
		menuViewButton.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		    	if(!isExpanded){
		    		expandMenu();
		    	}else{
		    		collapseMenu();
		    	}         	   
		    }
		});
    }
    
    private void expandMenu(){
    	//Expand
    	isExpanded = true;
		new ExpandAnimation(slidingPanel, panelWidth,
	    Animation.RELATIVE_TO_SELF, 0.0f,
	    Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);
    }
    
    private void collapseMenu(){
    	//Collapse
    	isExpanded = false;
		new CollapseAnimation(slidingPanel,panelWidth,
	    TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
	    TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);
    }
    private void VerificarPuntos(List<GeoPoint> list) {
    	if(getCatalogoAsignacion().getAnotacionasignacion() != null)
    	{
    	int tamano = getCatalogoAsignacion().getAnotacionasignacion().length;
    	for (int i = 0; i < tamano; i++){
    		System.out.println("Verificando llenado de puntos" + getCatalogoAsignacion().getAnotacionasignacion()[i].getLongitud());
    		list.add(new GeoPoint((int)(getCatalogoAsignacion().getAnotacionasignacion()[i].getLatitud() *1E6), (int)(getCatalogoAsignacion().getAnotacionasignacion()[i].getLongitud() * 1E6)));
    		String titulo = getCatalogoAsignacion().getAnotacionasignacion()[i].getNombreTipoAnotacion() + "=+=" 
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getId() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getId_comunidad() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getNombreUsuario() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getNombreTipoAnotacion() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getIcono();
    		String desc = getCatalogoAsignacion().getAnotacionasignacion()[i].getDescripcion() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getFecha_registro() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getNombreUsuario() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getNombreComunidad() + "=+="
    			+ getCatalogoAsignacion().getAnotacionasignacion()[i].getArchivo();
    		agregaPuntos(list.get(i), titulo, desc);
    	}
      }	
    }

	protected void agregaPuntito(int latitud, int longitud) {
    	
    	//mapOverlays = mapView.getOverlays();
    	Drawable drawable = getResources().getDrawable(R.drawable.marker);
        MapItemizedOverlay itemizedoverlay = new MapItemizedOverlay(drawable, mapView.getContext(), mapView);
    	OverlayItem overlayItem = new OverlayItem(new GeoPoint((int)(latitud * 1E6), (int)(longitud * 1E6)), "punto ", "descripcion ");     
        itemizedoverlay.addOverlay(overlayItem);
        mapOverlays.add(itemizedoverlay);
    }
    
    private void agregaPuntos(GeoPoint list, String titulo, String desc) {
    	
    	//for (int i = 0; i < list.size(); i++){
    		//Toast.makeText(getBaseContext(), String.valueOf(i), Toast.LENGTH_SHORT).show();
    	
    	
    	//imageView.setImageResource(mThumbIds[position]);
    	
    	BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 0;
		Bitmap bm = BitmapFactory.decodeFile("sdcard/" + tokenizer.icono(titulo), options);
        
		Drawable drawable = tokenizer.iconoResource(this, titulo);
//    		Drawable drawable = new BitmapDrawable(bm);
        	MapItemizedOverlay itemizedoverlay = new MapItemizedOverlay(drawable, mapView.getContext(), mapView);
    		OverlayItem overlayItem = new OverlayItem(list, titulo, desc);
    		Log.e("TT", "22 titulo completo = " + overlayItem.getTitle());
            itemizedoverlay.addOverlay(overlayItem);
            mapOverlays.add(itemizedoverlay);
    		
    	//}
    }

	private void inicializeMap(){
        mapView = (MapView) findViewById(R.id.map);
        mapView.setBuiltInZoomControls(true);        
        mapController = mapView.getController();
        mapController.setZoom(20);
        int latitud = (int) (14.627853 * 1E6);
        int longitud = (int) (-90.517584 * 1E6);
        mapController.animateTo(new GeoPoint(latitud,longitud));
        centerMyPosition();
   }
    
    private void centerMyPosition(){
        myLocationOverlay = new MyLocationOverlay(this, mapView);
        mapView.getOverlays().add(myLocationOverlay);
        myLocationOverlay.enableCompass();
        myLocationOverlay.enableMyLocation();
        myLocationOverlay.runOnFirstFix(new Runnable() {
            public void run() {
            	mapController.animateTo(myLocationOverlay.getMyLocation());
            }
        });
    }
    
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }

	public CatalogoAnotacion getCatalogoAnotacion() {
		return catalogoAnotacion;
	}

	public void setCatalogoAnotacion(CatalogoAnotacion catalogoAnotacion) {
		this.catalogoAnotacion = catalogoAnotacion;
	}
	public CatalogoAsignacion getCatalogoAsignacion() {
		return catalogoAsignacion;
	}

	public void setCatalogoAsignacion(CatalogoAsignacion catalogoAsignacion) {
		this.catalogoAsignacion = catalogoAsignacion;
	}
	
	private void opcionesMenu(int opcion){
		switch(opcion){
		case 0:
			new buscaAnotacionesAsync().execute("");
			break;
		case 1:
			Intent intentAsignaciones = new Intent(Mapa.this, Asignaciones.class);
			intentAsignaciones.putExtra("catalogo", getCatalogoAsignacion());
			startActivity(intentAsignaciones);
			break;
		case 2:
			Intent intentCerrar = new Intent(Mapa.this, LoginRecibelo.class);
			startActivity(intentCerrar);
			break;
        default:
            break;

		}
	}


	//Clase para ejecutar en Background
	class buscaAnotacionesAsync extends AsyncTask<String, Integer, Integer> {

	      // Metodo que prepara lo que usara en background, Prepara el progress
	      @Override
	      protected void onPreExecute() {
	            pd = ProgressDialog. show(Mapa.this, "VERIFICANDO DATOS", "ESPERE UN MOMENTO");
	            pd.setCancelable( false);
	     }

	      // Metodo con las instrucciones que se realizan en background
	      @Override
	      protected Integer doInBackground(String... urlString) {
	            try {
	            	CargarAsignaciones();
	           } catch (Exception exception) {

	           }
	            return null ;
	     }
	      
	   // Metodo con las instrucciones al finalizar lo ejectuado en background
	      protected void onPostExecute(Integer resultado) {
	            pd.dismiss();
	            inicializar();

	     }


	      	
	}	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		opcionesMenu(arg2);
		collapseMenu();
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	      if (keyCode == KeyEvent.KEYCODE_BACK) {
	            // Preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR     
	            return true;
	      }
	      
	      return super.onKeyDown(keyCode, event);
  }
	
	    
}
