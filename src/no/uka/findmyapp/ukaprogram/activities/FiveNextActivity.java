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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;



public class FiveNextActivity extends Activity {
	EventListAdapter eventAdapter;
	ArrayList<UkaEvent> eventsArrayList;
	ListView eventListView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five_next_list);

		eventsArrayList = new ArrayList<UkaEvent>();
		Log.i("re","TESTETSE");
		eventListView = (ListView) findViewById(R.id.eventListView);
		eventAdapter = new EventListAdapter(this, R.layout.list_adapter, eventsArrayList);
		eventListView.setAdapter(eventAdapter);
		////////
		populateListView();
		initializeSpinner();
	} // end onCreate()

	public void initializeSpinner(){
		Spinner spinner = (Spinner) findViewById(R.id.category_spinner);   
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(   
				this, R.array.category_array, android.R.layout.simple_spinner_item);    
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnCategorySelectedListener());
	}
	public class OnCategorySelectedListener implements OnItemSelectedListener {
		@Override
		public void onItemSelected(AdapterView<?> parent,        
				View view, int pos, long id) {      
			populateListView(1, pos);
			//			Toast.makeText(parent.getContext(), "The category is " +         
			//					parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();    
		}    
		@Override
		public void onNothingSelected(AdapterView<?> parent) 
		{     
			// Do nothing.   
		}
	}


	@Override
	public void onResume() {
		super.onResume();
	}	

	private void populateListView(int event_variable, int value){

		eventsArrayList.clear();
		Log.i("position", value + "");  
		
		if (value == 1){


			eventsArrayList.clear();
			EventDatabase eb = EventDatabase.getInstance();
			eventsArrayList = eb.getAllEvents(this.getContentResolver());
		}
		else if(value == 0){
			eventsArrayList.clear();
			EventDatabase eb = EventDatabase.getInstance();
			eventsArrayList = eb.getAllEvents(this.getContentResolver());
		}
			eventAdapter.notifyDataSetChanged();

	}
	private void populateListView() {
		eventsArrayList.clear();

		eventsArrayList.clear();
		EventDatabase eb = EventDatabase.getInstance();
		eventsArrayList = eb.getAllEvents(this.getContentResolver());




		
		eventListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				//viewContact.setClass(getApplicationContext(), ContactDetailsActivity.class);
				/**
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

