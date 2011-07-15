package no.uka.findmyapp.ukaprogram.activities;


import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import no.uka.findmyapp.ukaprogram.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class EventDetailsActivity extends Activity {

	private UkaEvent selectedEvent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_details);
		Log.v("EventDetailsAdapter", "Inside onCreate");

		Bundle extras = getIntent().getExtras();
		selectedEvent = new UkaEvent();
		
		if (extras != null) {
			selectedEvent = (UkaEvent) extras.getSerializable("SelectedEvent");

			TextView ageLimit = (TextView) findViewById(R.id.ageLimit);
			TextView price = (TextView) findViewById(R.id.price);
			TextView title = (TextView) findViewById(R.id.title);
			TextView time_and_place= (TextView) findViewById(R.id.time_and_place);
			TextView description = (TextView) findViewById(R.id.description);
			
			time_and_place.setText(selectedEvent.getShowingTime().getDay() + " " + selectedEvent.getDayNumber()+" okt. " + selectedEvent.getStartTime() + ", " + selectedEvent.getPlace());
			title.setText(selectedEvent.getTitle());
			description.setText(selectedEvent.getText());
			ageLimit.setText("Aldersgrense: " + selectedEvent.getAgeLimit() + " år");
			if(selectedEvent.isFree()){
				price.setText("Gratis");	
			}
			else{
				price.setText("Pris: legges til av team b");
				//price.setText("Pris: " + selectedEvent.getPrice() +" kr");
			}
		}
	}
}