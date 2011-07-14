package no.uka.findmyapp.ukaprogram.wrapper;


import java.util.ArrayList;
import java.util.Date;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;

public class EventDatabase {
	
	private static EventDatabase INSTANCE; 	
	private EventDatabase() {}	
	
	public static EventDatabase getInstance() {
		if(INSTANCE == null) {		
			INSTANCE = new EventDatabase();	
			return INSTANCE; 		
		}		
		return INSTANCE;	
	}
	
	public ArrayList<UkaEvent> getAllEvents(ContentResolver contentResolver){
		ContentValues contentValues = new ContentValues();
		UkaEvent ukaEvent;
		ArrayList<UkaEvent> eventList = new ArrayList<UkaEvent>();
		Cursor cursor = contentResolver.query(UkaEventContract.EVENT_CONTENT_URI, null, 		
				null, 			
				null, UkaEventContract.SHOWING_TIME);		
		
		
		cursor.moveToFirst();
		while (cursor != null) {	
			ukaEvent = getEventFromCursor(cursor);
			eventList.add(ukaEvent);
			cursor.moveToNext();	
			}
		return eventList;
	}
	
	public ArrayList<UkaEvent> getNextEventsFromCategory(ContentResolver contentResolver, int numberOfEvents, String eventType){
		ContentValues contentValues = new ContentValues();
		UkaEvent ukaEvent;
		Date now = new Date();
		ArrayList<UkaEvent> eventList = new ArrayList<UkaEvent>();
		Cursor cursor = contentResolver.query(UkaEventContract.EVENT_CONTENT_URI, null, 		
				UkaEventContract.EVENT_TYPE + "=" + eventType + " AND " + UkaEventContract.SHOWING_TIME + " > " + now.toString(), 			
				null, UkaEventContract.SHOWING_TIME);		
		
		
		cursor.moveToFirst();
		while (cursor != null) {	
			ukaEvent = getEventFromCursor(cursor);
			eventList.add(ukaEvent);
			cursor.moveToNext();	
			}
		return eventList;
	}

	private UkaEvent getEventFromCursor(Cursor cursor) {
		UkaEvent ukaEvent = new UkaEvent();
		ukaEvent.setAgeLimit(cursor.getInt(cursor.getColumnIndex(UkaEventContract.AGE_LIMIT)));			
		//ukaEvent.setCanceled(cursor.getInt(cursor.getColumnIndex(UkaEventContract.CANCELED)));
		ukaEvent.setEventType(cursor.getString(cursor.getColumnIndex(UkaEventContract.EVENT_TYPE)));
		ukaEvent.setId(cursor.getInt(cursor.getColumnIndex(UkaEventContract.EVENT_TYPE)));
		ukaEvent.setText(cursor.getString(cursor.getColumnIndex(UkaEventContract.TEXT)));
		//ukaEvent.setShowingTime(new Date().parse(cursor.getString(cursor.getColumnIndex(UkaEventContract.SHOWING_TIME))));
		ukaEvent.setPlace(cursor.getString(cursor.getColumnIndex(UkaEventContract.PLACE)));
		ukaEvent.setTitle(cursor.getString(cursor.getColumnIndex(UkaEventContract.TITLE)));
		return ukaEvent;
	}
}
