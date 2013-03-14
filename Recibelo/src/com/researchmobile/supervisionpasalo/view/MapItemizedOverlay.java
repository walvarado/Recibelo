package com.researchmobile.supervisionpasalo.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MapItemizedOverlay extends BalloonItemizedOverlay<OverlayItem> {

	 private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	 
	 public MapItemizedOverlay(Drawable defaultMarker, Context context, MapView mapview) {
	    super(boundCenter(defaultMarker),mapview);
	    
	 }
	 
	 public void addOverlay(OverlayItem overlay) {
	     mOverlays.add(overlay);
	     populate();     
	 }
	 
	 @Override
	 protected OverlayItem createItem(int i) {
	   return mOverlays.get(i);
	 }
	  
	 @Override
	 protected boolean onBalloonTap(int index, OverlayItem item) {
	  return true;
	 }
	 
	 @Override
	 public int size() {
	   return mOverlays.size();
	 }

	}
