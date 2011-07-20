package no.uka.findmyapp.ukaprogram.activities;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.models.UkaEvent;
import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.adapters.EventListCursorAdapter;
import no.uka.findmyapp.ukaprogram.wrapper.EventDatabase;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class EventListActivity extends ListActivity implements OnClickListener{	
	private final static String debug = "EventListActivity";
	private final static String KONSERT = "Konsert";
	private final static String REVY = "Revy og Teater";
	private final static String KURS = "Kurs & Events";
	private final static String FEST = "Fest & Moro";
	private Drawable drawable;
	private int color;
	private int name;
	private String categoryName;
	private String whereStatement;
	private Cursor eventCursor;


	private final static String ORDER_BY = UkaEventContract.SHOWING_TIME + " asc";
	public final static String ITEM_CLICKED = "clicked";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.event_list);
		Bundle bundle = getIntent().getExtras();
		Button categoryButton = (Button) findViewById(R.id.event_list_category_button);
		LinearLayout line = (LinearLayout) findViewById(R.id.event_list_line);
		categoryButton.setOnClickListener(this);


/*
		if (bundle != null){
			drawable = getResources().getDrawable((int)bundle.getInt("drawable"));
			whereStatement = bundle.getString("whereStatement");
			color = bundle.getInt("color");
			categoryName = bundle.getInt("name");

			line.setBackgroundColor(getResources().getColor(color));
			categoryButton.setBackgroundDrawable(drawable);
			categoryButton.setText(categoryName);
			//if(bundle.getString("whereStatement").length() != 0 ){
				eventCursor = this.managedQuery(UkaEventContract.EVENT_CONTENT_URI, null, null, null, ORDER_BY);
			//}
		}
		**/
			eventCursor = this.managedQuery(UkaEventContract.EVENT_CONTENT_URI, null, null, null, ORDER_BY);
		

		this.setListAdapter(new EventListCursorAdapter(this, eventCursor));


	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Cursor c = (Cursor) l.getItemAtPosition(position);

		UkaEvent event = EventDatabase.getInstance().getEventFromCursor(c);
		Log.v(debug, event.toString());

		Intent intent = new Intent(this, EventDetailsActivity.class); 
		intent.putExtra(ITEM_CLICKED, event);

		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		registerForContextMenu(v);
		v.setLongClickable(false);
		openContextMenu(v);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.category_menu, menu);

	}

	@Override
	public boolean onContextItemSelected(MenuItem item){
		Intent intent;
		switch (item.getItemId()){
		case R.id.category_menu_alle:
			drawable = getResources().getDrawable(R.drawable.katbuttonalle);
			color = R.color.alle;
			categoryName = getResources().getString(R.string.alle);
			refresh();
			return true;

		case R.id.category_menu_fest:
			whereStatement = UkaEventContract.EVENT_TYPE + " = " + FEST;
			drawable = getResources().getDrawable(R.drawable.katbuttonfest);
			color = R.color.fest;
			categoryName = getResources().getString(R.string.fest);
			refresh();
			return true;

		case R.id.category_menu_konsert:
			whereStatement = UkaEventContract.EVENT_TYPE + " = " + KONSERT;
			drawable = getResources().getDrawable(R.drawable.katbuttonkonsert);
			color = R.color.konsert;
			categoryName = getResources().getString(R.string.konsert);
			refresh();
			return true;

		case R.id.category_menu_kurs:
			whereStatement = UkaEventContract.EVENT_TYPE + " = " + KURS;
			drawable = getResources().getDrawable(R.drawable.katbuttonkurs);
			color = R.color.kurs;
			categoryName = getResources().getString(R.string.kurs);
			refresh();
			return true;

		case R.id.category_menu_revy:
			whereStatement =  UkaEventContract.EVENT_TYPE  + " = " + "'" + REVY  + "'";
			drawable = getResources().getDrawable(R.drawable.katbuttonrevy);
			color = R.color.revy;
			categoryName = getResources().getString(R.string.revy);
			refresh();
			return true;

		default:
			return super.onContextItemSelected(item);
		}
	}
	
	private void refresh(){
		Log.v(debug, "Refreshing page");
		Button categoryButton = (Button) findViewById(R.id.event_list_category_button);
		LinearLayout line = (LinearLayout) findViewById(R.id.event_list_line);
		line.setBackgroundColor(getResources().getColor(color));
		categoryButton.setBackgroundDrawable(drawable);
		categoryButton.setText(categoryName);
		whereStatement = UkaEventContract.TITLE + " = 'Oktoberfest'";
		eventCursor = this.managedQuery(UkaEventContract.EVENT_CONTENT_URI, null, whereStatement, null, ORDER_BY);
	}

}