package com.gpssettings.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;


import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
public class GPSDetectionPlugin extends CordovaPlugin {

	Context mContext;
	@Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) {
    	
    	PluginResult result = null;
        boolean gpsEnabled = false;
        String GPSDetectionAction = "gpsDetection";
        
        if (action.equals(GPSDetectionAction)) {
        	
	        	android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
	        	gpsEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.GPS_PROVIDER);
	        	result = new PluginResult(Status.OK, gpsEnabled);
        }else if(action.equals("switchToLocationSettings")){
        		switchToLocationSettings();
        		callbackContext.success();    
        		result = new PluginResult(Status.OK, gpsEnabled);
        }
        else {
            result = new PluginResult(Status.INVALID_ACTION);
        }
        
        callbackContext.sendPluginResult(result);
        
        return true;
        
    }
	public void switchToLocationSettings() {
        //Log.d(TAG, "Switch to Location Settings");
        Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        cordova.getActivity().startActivity(settingsIntent);
    }
}