package com.researchmobile.coretel.entity;

import android.content.Context;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

public class ChatUtility {
	private String regId = "";
	public String ChatId (Context context){
		GCMRegistrar.checkManifest(context);
 		if (GCMRegistrar.isRegistered(context)) {
 			Log.d("info", GCMRegistrar.getRegistrationId(context));
 		}
 		regId = GCMRegistrar.getRegistrationId(context);
 		if (regId.equals("")) {
 			// replace this with the project ID
 			GCMRegistrar.register(context, "197161168597");
 			regId = GCMRegistrar.getRegistrationId(context);
 			
 		}return regId;
	}

}
