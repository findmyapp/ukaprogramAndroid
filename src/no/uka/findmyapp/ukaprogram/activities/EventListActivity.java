package no.uka.findmyapp.ukaprogram.activities;

import java.util.ArrayList;

import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.adapters.EventListAdapter;
import no.uka.findmyapp.ukaprogram.wrapper.EventDatabase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class EventListActivity extends Activity {
	private EventListAdapter eventAdapter;
	private ArrayList<UkaEvent> eventsArrayList;
	private ListView eventListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v("EventListActivity", "Inside onCreate");
		setContentView(R.layout.event_list);

		this.eventsArrayList = new ArrayList<UkaEvent>();
		this.eventListView = (ListView) findViewById(R.id.eventListView);
		this.eventAdapter = new EventListAdapter(this, R.layout.list_adapter, eventsArrayList);
		this.eventListView.setAdapter(eventAdapter);
		////////
		populateListView();
	} // end onCreate()

	@Override
	public void onResume() {
		super.onResume();
	}	
	private void populateListView() {
		Log.v("EventListActivity", "Inside populateListView");
		eventsArrayList.clear();
		EventDatabase eb = EventDatabase.getInstance();
		eventsArrayList = eb.getAllEvents(this.getContentResolver());

		eventListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				//viewContact.setClass(getApplicationContext(), ContactDetailsActivity.class);
				/*
					databaseHandler.open();
					databaseHandler.removePerson(contactArrayList.get(position).getId());
					databaseHandler.close();
					populateList();
				 */
				Intent viewEvent = new Intent();
				viewEvent.setClass(getApplicationContext(), EventDetailsActivity.class);
				viewEvent.putExtra("SelectedEvent", eventsArrayList.get(position));///////
				startActivity(viewEvent); 
			}
		});

	} 

}

