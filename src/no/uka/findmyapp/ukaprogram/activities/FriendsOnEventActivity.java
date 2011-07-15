package no.uka.findmyapp.ukaprogram.activities;

import java.util.ArrayList;

import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.models.Event;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

public class FriendsOnEventActivity extends ListActivity {

	private Event event = null;
	private ArrayList<String> friendList;
	private ListView friendsListView;
	private String TAG = "FriendsOnEventActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.id.friends_list_popup);
		friendList = new ArrayList<String>();
		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			event = (Event) extras.getSerializable("SelectedEvent");
		} else {
			Log.v(TAG, "extras is null");
			return;
		}

		friendsListView = (ListView)findViewById(R.id.friends_list_popup);
		Log.v(TAG, "friendsListView: "+friendsListView);
		populateFriendList();
		Log.v(TAG, "BEFORE SET_ADAPTER............");
		friendsListView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, friendList));
		Log.v(TAG, "AFTER SET_ADAPTER............");
		showPopupWindow();
	}

	public void populateFriendList() {
		// Finn venner som skal på arrangementet og legg i liste
		friendList.add("Audun Sørheim");
		friendList.add("Kåre Blakstad");
		friendList.add("Ole Christian Røed");
	}

	public void showPopupWindow() {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		PopupWindow pw = new PopupWindow(inflater.inflate(
				R.layout.friends_on_event_popup, null, false), 100, 100, true);
		pw.showAtLocation(this.findViewById(R.layout.event_details),
				Gravity.CENTER, 0, 0);
	}

}
