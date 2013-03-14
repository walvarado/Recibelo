package com.researchmobile.coretel.utility;

import android.content.Context;
import android.telephony.TelephonyManager;

public class PhoneInformation {
	TelephonyManager tm = null;
	
	public String Imei(Context context){
		String imei = null;
		tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);//
		imei = tm.getDeviceId();
		return imei;
	}
	
	public String SoftwareVersion(Context context){
		String softwareVersion = null;
		tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);//
		softwareVersion = tm.getDeviceSoftwareVersion();
		return softwareVersion;
	}
	
	public String LineNumber1(Context context){
		String lineNumber1 = null;
		tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);//
		lineNumber1 = tm.getLine1Number();
		return lineNumber1;
	}
	
	public String SimOperatorName(Context context){
		String simOperatorName = null;
		tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);//
		simOperatorName = tm.getSimOperatorName();
		return simOperatorName;
	}
}	
	/*
	public static String fetch_tel_status(Context cx) {
		    str += "NetworkCountryIso = " + tm.getNetworkCountryIso() + "\n";
		    str += "NetworkOperator = " + tm.getNetworkOperator() + "\n";
		    str += "NetworkOperatorName = " + tm.getNetworkOperatorName() + "\n";
		    str += "NetworkType = " + tm.getNetworkType() + "\n";
		    str += "PhoneType = " + tm.getPhoneType() + "\n";
		    str += "SimCountryIso = " + tm.getSimCountryIso() + "\n";
		    str += "SimOperator = " + tm.getSimOperator() + "\n";
		    str += "SimOperatorName = " + tm.getSimOperatorName() + "\n";
		    str += "SimSerialNumber = " + tm.getSimSerialNumber() + "\n";
		    str += "SimState = " + tm.getSimState() + "\n";
		    str += "SubscriberId(IMSI) = " + tm.getSubscriberId() + "\n";
		    str += "VoiceMailNumber = " + tm.getVoiceMailNumber() + "\n";

		    int mcc = cx.getResources().getConfiguration().mcc;
		    int mnc = cx.getResources().getConfiguration().mnc;
		    str += "IMSI MCC (Mobile Country Code):" + String.valueOf(mcc) + "\n";
		    str += "IMSI MNC (Mobile Network Code):" + String.valueOf(mnc) + "\n";
		    result = str;
		    return result;
		  }
*/

