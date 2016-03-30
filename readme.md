A simple cordova plugin that allows to check to see if GPS is enabled or not.

---------------------------------------------------------
INSTALATION
---------------------------------------------------------
1.Copy gpsdetector folder  under platforms/android/src/com.

2.In your config.xml file add the following(config.xml under the  platforms/android/res/xml).

<feature name="GpsDetectionPlugin">
        <param name="android-package" value="com.gpsdetector.plugins.GPSDetectionPlugin" />
    </feature>

3.Include the gpsDetectionPlugin.js file in your index.html file

-----------------------------------------------------------
USAGE
-----------------------------------------------------------

gpsDetect = cordova.require('cordova/plugin/gpsDetectionPlugin');

gpsDetect.checkGPS(onGPSSuccess, onGPSError);

//callback success
function onGPSSuccess(isGps){
   //GPS enables
   if(isGps){
     alert("GPS enabled");
   }else{
    //GPS not enabled
    //redirect to location settings
    cordova.require('cordova/plugin/gpsDetectionPlugin').switchToLocationSettings();
   }
}
         
//callback error
function onGPSError(err){

 console.log("Error");
}

------------------------------------------------
NOTE
-----------------------------------------------

Don't forgot add the necessary permissions in android manifest file.



