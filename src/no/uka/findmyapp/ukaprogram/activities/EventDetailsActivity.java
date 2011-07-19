package no.uka.findmyapp.ukaprogram.activities;


import java.util.ArrayList;

import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.adapters.EventListAdapter;
import no.uka.findmyapp.ukaprogram.models.Event;
import android.R.color;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class EventDetailsActivity extends Activity {

	private Event selectedEvent;
	private ArrayList<String> friendList;
	private String TAG = "EventDetails";
	private ArrayAdapter<String> friendAdapter;
	private ListView friendListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_details);

		Bundle extras = getIntent().getExtras();
		selectedEvent = new Event();
		friendList = new ArrayList<String>();		
		
		if (extras != null) {
			selectedEvent = (Event) extras.getSerializable("SelectedEvent");

			TextView ageLimit = (TextView) findViewById(R.id.ageLimit);
			TextView price = (TextView) findViewById(R.id.price);
			TextView title = (TextView) findViewById(R.id.title);
			TextView time_and_place= (TextView) findViewById(R.id.time_and_place);
			TextView description = (TextView) findViewById(R.id.description);
			
			time_and_place.setText(selectedEvent.getWeekday() + " " + selectedEvent.getDayNumber()+" okt. " + selectedEvent.getStartTime() + ", " + selectedEvent.getPlace());
			title.setText(selectedEvent.getTitle());
			description.setText(selectedEvent.getDescription());
			ageLimit.setText("Aldersgrense: " + selectedEvent.getAgeLimit() + " år");
			if(selectedEvent.isFree()){
				price.setText("Gratis");
			}
			else{
				price.setText("Pris: " + selectedEvent.getPrice() +" kr");
			}

			/**Intent editContact = new Intent();
			editContact.putExtra("SelectedContact", selectedContact);

			TextView tv_firstname = (TextView) findViewById(R.id.lbl_name);
			TextView tv_phone = (TextView)findViewById(R.id.lbl_phone);
			TextView tv_mail = (TextView)findViewById(R.id.lbl_email);

			tv_firstname.setText(selectedContact.getFirstname() + " " + selectedContact.getLastname());
			tv_phone.setText("Phone: " + selectedContact.getPhone());
			tv_mail.setText("Mail: " + selectedContact.getEmail());
			 */
			
			Button friendsButton = (Button) findViewById(R.id.friendsOnEventButton);
			friendsButton.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) { 
	            	showPopupWindow();
	             }
	         });
		}
	}
	
	public void populateFriendList() {
		// Finn venner som skal på arrangementet og legg i liste
		friendList.clear();
		friendList.add("Audun");
		friendList.add("Kaare");
		friendList.add("Ole Christian");
	}

	public void showPopupWindow() {
		friendListView = new ListView(this);
		populateFriendList();
		friendAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, friendList);
		friendListView.setAdapter(friendAdapter);
		Dialog d = new Dialog(this);
		friendListView.setBackgroundColor(Color.WHITE);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Deltagende venner");
		builder.setView(friendListView);
		d = builder.create();
		d.show();
	}
}