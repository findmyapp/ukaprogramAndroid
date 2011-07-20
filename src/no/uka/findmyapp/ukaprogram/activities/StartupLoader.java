package no.uka.findmyapp.ukaprogram.activities;

import no.uka.findmyapp.android.rest.client.RestServiceHelper;
import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.utils.EventsUpdater;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class StartupLoader extends Activity {
	private static final String debug = "StartupLoader";

	private static RestServiceHelper serviceHelper = RestServiceHelper.getInstance(); 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
		
		Log.v(debug, "Loading UkaProgram");
		
		EventsUpdater eu = new EventsUpdater(getApplicationContext());
		eu.initUpdate(); 
	}
}
