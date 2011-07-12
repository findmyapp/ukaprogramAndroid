package no.uka.findmyapp.ukaprogram.activities;

import java.util.ArrayList;

import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.adapters.DayListAdapter;
import no.uka.findmyapp.ukaprogram.models.Event;
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
	ArrayList<Event> eventsArrayList;
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

		eventsArrayList = new ArrayList<Event>();
		eventListView = (ListView) findViewById(R.id.event_list_for_day_eventListView);
		dayAdapter = new DayListAdapter(this, R.layout.date_list_adapter, eventsArrayList);
		TextView header= (TextView) findViewById(R.id.event_list_for_day_day);




		eventListView.setAdapter(dayAdapter);


		eventsArrayList.clear();

		Event oktoberfest = new Event();
		oktoberfest.setTitle("Oktoberfest");
		oktoberfest.setPlace("D�dens dal");
		oktoberfest.setEventType("Revy & Teater");
		oktoberfest.setAgeLimit(18);
		oktoberfest.setStartTime("17.00");
		oktoberfest.setFree(false);
		oktoberfest.setWeekday("fre");
		oktoberfest.setDayNumber("29");
		oktoberfest.setPrice(300);
		oktoberfest.setDescription("Den 10. oktober 2011 kl. 13.00 braker det l�s i D�dens Dal, n�r feststemte mennesker if�rt lederhosen samles rundt langbordene for et �lgilde man ellers m� helt til Tyskland for � f� oppleve. �lglass p� h�ykant, allsang, dans og generelt god stemning st�r p� programmet for �rets Oktoberfest. Det blir ogs� livemusikk av b�de DJs og band i teltet. Det er ikke tilfeldig at dette er eventen som i f�lge historieb�kene blir raskest utsolgt. Tradisjonen kommer opprinnelig fra delstaten Bayern i Tyskland, men har med �rene ogs� blitt popul�r i lille Norge. Har man ikke muligheten til � dra s�rover for � oppleve det p� ekte tysk vis, kan man like s� godt dra p� seg lederhosen og slenge �lmagen p� bardisken her i Trondheim. UKA har arrangert Oktoberfester siden 2001, og festen har med �rene blitt en UKEtradisjon. Trondheims befolkning b�de forbinder og forventer denne festen av oss, og i �r tar vi den til helt nye h�yder. Finn frem kostymet og forbered deg til �rets fest. Billettene kommer med �god stemnings�-garanti. Dette vil du ikke g� glipp av!");
		eventsArrayList.add(oktoberfest);

		Event kaizers = new Event();
		kaizers.setTitle("Kaizers Orchestra");
		kaizers.setPlace("Storsalen");	
		kaizers.setEventType("Konsert");
		kaizers.setAgeLimit(18);
		kaizers.setStartTime("19:00");
		kaizers.setWeekday("l�r");
		kaizers.setDayNumber("30");
		kaizers.setPrice(350);
		kaizers.setDescription("Den 20. oktober 2011 kl. 13.00 braker det l�s i D�dens Dal, n�r feststemte mennesker if�rt lederhosen samles rundt langbordene for et �lgilde man ellers m� helt til Tyskland for � f� oppleve. �lglass p� h�ykant, allsang, dans og generelt god stemning st�r p� programmet for �rets Oktoberfest. Det blir ogs� livemusikk av b�de DJs og band i teltet. Det er ikke tilfeldig at dette er eventen som i f�lge historieb�kene blir raskest utsolgt. Tradisjonen kommer opprinnelig fra delstaten Bayern i Tyskland, men har med �rene ogs� blitt popul�r i lille Norge. Har man ikke muligheten til � dra s�rover for � oppleve det p� ekte tysk vis, kan man like s� godt dra p� seg lederhosen og slenge �lmagen p� bardisken her i Trondheim. UKA har arrangert Oktoberfester siden 2001, og festen har med �rene blitt en UKEtradisjon. Trondheims befolkning b�de forbinder og forventer denne festen av oss, og i �r tar vi den til helt nye h�yder. Finn frem kostymet og forbered deg til �rets fest. Billettene kommer med �god stemnings�-garanti. Dette vil du ikke g� glipp av!");

		kaizers.setFree(false);

		eventsArrayList.add(kaizers);


		eventsArrayList.add(oktoberfest);
		eventsArrayList.add(kaizers);

		
		header.setText(eventsArrayList.get(0).getWeekday() +". " + selectedDay + ". Okt");
		

		eventListView.setOnItemClickListener(new OnItemClickListener(){
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
