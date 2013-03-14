package com.researchmobile.supervisionpasalo.view;

import android.view.MotionEvent;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MapItemizedOverlaySelect extends Overlay {

	 private int LONGPRESS_TIME = 500;
	 private long timeInitPress = 0;
	 private long timeFinishPress = 0;
	 
	 private int latitud = 0;
	 private int longitud = 0;

	 private GeoPoint lastMapCenter;
	 
	 private boolean isLongPress(){
	  return ((timeInitPress >= 0) && ((timeFinishPress - timeInitPress) > LONGPRESS_TIME));   
	 }
	 
	 @Override
	    public boolean onTouchEvent(MotionEvent event, MapView mapView){   
	        
	        if (event.getAction() == MotionEvent.ACTION_DOWN) {
	         timeInitPress = event.getEventTime();
	         lastMapCenter = mapView.getMapCenter();
	            GeoPoint p = mapView.getProjection().fromPixels(
	                (int) event.getX(),
	                (int) event.getY());
	            
	           
	           latitud = p.getLatitudeE6();
	           longitud = p.getLongitudeE6();
	          
	        } 
	        
	        if (event.getAction() == MotionEvent.ACTION_MOVE) {
	         if (!mapView.getMapCenter().equals(lastMapCenter)) {
	          timeInitPress = -1;          
	         }
	        }
	        
	        if (event.getAction() == MotionEvent.ACTION_UP) {
	         timeFinishPress = event.getEventTime();
	         if(isLongPress()){
	          listenerSelectPOI.onSelectPOI(latitud, longitud);
	          
	         }
	        }
	        
	        if (event.getPointerCount() > 1) {
	         timeInitPress = -1;         
	        }
	        
	        return false;   
	    }
	 
	 
	 public interface OnSelectPOIListener{void onSelectPOI(int Latitud, int Longitud);}
	 private OnSelectPOIListener listenerSelectPOI; 
	 public void setOnSelectPOIListener(OnSelectPOIListener l){listenerSelectPOI = l;}
	}

