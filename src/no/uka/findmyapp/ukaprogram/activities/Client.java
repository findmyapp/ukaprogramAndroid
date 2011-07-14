package no.uka.findmyapp.ukaprogram.activities;

import java.net.URI;
import java.net.URISyntaxException;

import no.uka.findmyapp.android.rest.client.HttpType;
import no.uka.findmyapp.android.rest.client.ServiceDataFormat;
import no.uka.findmyapp.android.rest.client.model.ServiceModel;
import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import no.uka.findmyapp.ukaprogram.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

import com.google.gson.reflect.TypeToken;

public class Client extends TabActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent().setClass(this, EventListActivity.class);
		spec = tabHost.newTabSpec("eventList").setIndicator("Events").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, FavoritesListActivity.class);
		spec = tabHost.newTabSpec("favs").setIndicator("Favorites").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, CalendarActivity.class);
		spec = tabHost.newTabSpec("cal").setIndicator("Calendar").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, FiveNextActivity.class);
		spec = tabHost.newTabSpec("5next").setIndicator("De 5 neste").setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);



	} // end onCreate()

	public void updateRest(){
		try {
			ServiceModel sm = new ServiceModel(
					new URI("http://findmyapp.net/findmyapp/program/UKA11/events/"), 
					HttpType.GET, 
					ServiceDataFormat.JSON, 
					new TypeToken<UkaEvent>(){}.getType(), 
					UkaEventContract.EVENT_CONTENT_URI);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();   
		inflater.inflate(R.menu.main_menu, menu);   
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {  
		// Handle item selection  
		switch (item.getItemId()) {   
		case R.id.calendar:  
			openCalendar();   
			return true;
		case R.id.fiveNext:  
			openFiveNext(); 
			return true;
		case R.id.fullList:  
			openFullList(); 
			return true;
		default:  
			return super.onOptionsItemSelected(item); 
		}

	}

	public void openCalendar(){
		Intent intent;

		intent = new Intent().setClass(this, CalendarActivity.class);
		startActivity(intent);

	}
	public void openFiveNext(){
		Intent intent;

		intent = new Intent().setClass(this, FiveNextActivity.class);
		startActivity(intent);
	}
	public void openFullList(){
		Intent intent;

		intent = new Intent().setClass(this, EventListActivity.class);
		startActivity(intent);
	}
}