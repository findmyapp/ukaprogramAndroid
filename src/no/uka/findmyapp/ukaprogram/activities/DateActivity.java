package no.uka.findmyapp.ukaprogram.activities;

import java.util.ArrayList;

import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.adapters.DayListAdapter;
import no.uka.findmyapp.ukaprogram.wrapper.EventDatabase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class DateActivity extends Activity {

	DayListAdapter dayAdapter;
	ArrayList<UkaEvent> eventsArrayList;
	ListView eventListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("h","YOU ARE IN THE DATE ACTIVITY!");
		setContentView(R.layout.event_list_for_day);
		//TextView tv = (TextView) findViewById(R.id.date_list_date);
		Bundle extras = getIntent().getExtras();
		int selectedDay = extras.getInt("SelectedDate");
		//get the selected date
		//tv.setText((extras.getInt("SelectedDate"))+ "");

		eventsArrayList = new ArrayList<UkaEvent>();
		eventListView = (ListView) findViewById(R.id.event_list_for_day_eventListView);
		dayAdapter = new DayListAdapter(this, R.layout.date_list_adapter, eventsArrayList);
		TextView header= (TextView) findViewById(R.id.event_list_for_day_day);

		eventListView.setAdapter(dayAdapter);

		eventsArrayList.clear();
		EventDatabase eb = EventDatabase.getInstance();
		eventsArrayList = eb.getAllEvents(this.getContentResolver());
		
		header.setText(eventsArrayList.get(0).getShowingTime().getDay() +". " + selectedDay + ". Okt");

		eventListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				Intent viewEvent = new Intent();
				viewEvent.setClass(getApplicationContext(), EventDetailsActivity.class);
				viewEvent.putExtra("SelectedEvent", eventsArrayList.get(position));///////
				startActivity(viewEvent); 
			}
		});
	}
}
