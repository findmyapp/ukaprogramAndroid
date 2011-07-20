package no.uka.findmyapp.ukaprogram.activities;


/*

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
		public void onItemSelected(AdapterView<?> parent,        
				View view, int pos, long id) {      
			populateListView(1, pos);
			//			Toast.makeText(parent.getContext(), "The category is " +         
			//					parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();    
		}    
		public void onNothingSelected(AdapterView<?> parent) 
		{     
			// Do nothing.   
		}
	}


	public void onResume() {
		super.onResume();
	}	

	private void populateListView(int event_variable, int value){

		eventsArrayList.clear();
		Log.i("position", value + "");  
		
		if (value == 1){


			UkaEvent oktoberfest = new UkaEvent();
			oktoberfest.setTitle("Oktoberfest");
			oktoberfest.setPlace("D�dens dal");
			oktoberfest.setEventType("Revy & Teater");
			oktoberfest.setAgeLimit(18);
			oktoberfest.setShowingTime(1234);
			oktoberfest.setFree(false);

			oktoberfest.setPrice(300);
			oktoberfest.setText("Den 10. oktober 2011 kl. 13.00 braker det l�s i D�dens Dal, n�r feststemte mennesker if�rt lederhosen samles rundt langbordene for et �lgilde man ellers m� helt til Tyskland for � f� oppleve. �lglass p� h�ykant, allsang, dans og generelt god stemning st�r p� programmet for �rets Oktoberfest. Det blir ogs� livemusikk av b�de DJs og band i teltet. Det er ikke tilfeldig at dette er eventen som i f�lge historieb�kene blir raskest utsolgt. Tradisjonen kommer opprinnelig fra delstaten Bayern i Tyskland, men har med �rene ogs� blitt popul�r i lille Norge. Har man ikke muligheten til � dra s�rover for � oppleve det p� ekte tysk vis, kan man like s� godt dra p� seg lederhosen og slenge �lmagen p� bardisken her i Trondheim. UKA har arrangert Oktoberfester siden 2001, og festen har med �rene blitt en UKEtradisjon. Trondheims befolkning b�de forbinder og forventer denne festen av oss, og i �r tar vi den til helt nye h�yder. Finn frem kostymet og forbered deg til �rets fest. Billettene kommer med �god stemnings�-garanti. Dette vil du ikke g� glipp av!");
			eventsArrayList.add(oktoberfest);
		}
		else if(value == 0){
			UkaEvent kaizers = new UkaEvent();
			kaizers.setTitle("Kaizers Orchestra");
			kaizers.setPlace("Storsalen");	
			kaizers.setEventType("Konsert");
			kaizers.setAgeLimit(18);
			kaizers.setShowingTime(2353);

			kaizers.setPrice(350);
			kaizers.setText("Den 20. oktober 2011 kl. 13.00 braker det l�s i D�dens Dal, n�r feststemte mennesker if�rt lederhosen samles rundt langbordene for et �lgilde man ellers m� helt til Tyskland for � f� oppleve. �lglass p� h�ykant, allsang, dans og generelt god stemning st�r p� programmet for �rets Oktoberfest. Det blir ogs� livemusikk av b�de DJs og band i teltet. Det er ikke tilfeldig at dette er eventen som i f�lge historieb�kene blir raskest utsolgt. Tradisjonen kommer opprinnelig fra delstaten Bayern i Tyskland, men har med �rene ogs� blitt popul�r i lille Norge. Har man ikke muligheten til � dra s�rover for � oppleve det p� ekte tysk vis, kan man like s� godt dra p� seg lederhosen og slenge �lmagen p� bardisken her i Trondheim. UKA har arrangert Oktoberfester siden 2001, og festen har med �rene blitt en UKEtradisjon. Trondheims befolkning b�de forbinder og forventer denne festen av oss, og i �r tar vi den til helt nye h�yder. Finn frem kostymet og forbered deg til �rets fest. Billettene kommer med �god stemnings�-garanti. Dette vil du ikke g� glipp av!");
			eventsArrayList.add(kaizers);
		}
			eventAdapter.notifyDataSetChanged();

	}
	private void populateListView() {
		eventsArrayList.clear();

		UkaEvent oktoberfest = new UkaEvent();
		oktoberfest.setTitle("Oktoberfest");
		oktoberfest.setPlace("D�dens dal");
		oktoberfest.setEventType("Revy & Teater");
		oktoberfest.setAgeLimit(18);

		oktoberfest.setFree(false);

		oktoberfest.setPrice(300);
		oktoberfest.setText("Den 10. oktober 2011 kl. 13.00 braker det l�s i D�dens Dal, n�r feststemte mennesker if�rt lederhosen samles rundt langbordene for et �lgilde man ellers m� helt til Tyskland for � f� oppleve. �lglass p� h�ykant, allsang, dans og generelt god stemning st�r p� programmet for �rets Oktoberfest. Det blir ogs� livemusikk av b�de DJs og band i teltet. Det er ikke tilfeldig at dette er eventen som i f�lge historieb�kene blir raskest utsolgt. Tradisjonen kommer opprinnelig fra delstaten Bayern i Tyskland, men har med �rene ogs� blitt popul�r i lille Norge. Har man ikke muligheten til � dra s�rover for � oppleve det p� ekte tysk vis, kan man like s� godt dra p� seg lederhosen og slenge �lmagen p� bardisken her i Trondheim. UKA har arrangert Oktoberfester siden 2001, og festen har med �rene blitt en UKEtradisjon. Trondheims befolkning b�de forbinder og forventer denne festen av oss, og i �r tar vi den til helt nye h�yder. Finn frem kostymet og forbered deg til �rets fest. Billettene kommer med �god stemnings�-garanti. Dette vil du ikke g� glipp av!");
		eventsArrayList.add(oktoberfest);

		UkaEvent kaizers = new UkaEvent();
		kaizers.setTitle("Kaizers Orchestra");
		kaizers.setPlace("Storsalen");	
		kaizers.setEventType("Konsert");
		kaizers.setAgeLimit(18);

		kaizers.setText("Den 20. oktober 2011 kl. 13.00 braker det l�s i D�dens Dal, n�r feststemte mennesker if�rt lederhosen samles rundt langbordene for et �lgilde man ellers m� helt til Tyskland for � f� oppleve. �lglass p� h�ykant, allsang, dans og generelt god stemning st�r p� programmet for �rets Oktoberfest. Det blir ogs� livemusikk av b�de DJs og band i teltet. Det er ikke tilfeldig at dette er eventen som i f�lge historieb�kene blir raskest utsolgt. Tradisjonen kommer opprinnelig fra delstaten Bayern i Tyskland, men har med �rene ogs� blitt popul�r i lille Norge. Har man ikke muligheten til � dra s�rover for � oppleve det p� ekte tysk vis, kan man like s� godt dra p� seg lederhosen og slenge �lmagen p� bardisken her i Trondheim. UKA har arrangert Oktoberfester siden 2001, og festen har med �rene blitt en UKEtradisjon. Trondheims befolkning b�de forbinder og forventer denne festen av oss, og i �r tar vi den til helt nye h�yder. Finn frem kostymet og forbered deg til �rets fest. Billettene kommer med �god stemnings�-garanti. Dette vil du ikke g� glipp av!");

		kaizers.setFree(false);

		eventsArrayList.add(kaizers);


		eventsArrayList.add(oktoberfest);
		eventsArrayList.add(kaizers);

		eventListView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				//viewContact.setClass(getApplicationContext(), ContactDetailsActivity.class);
				/**
					databaseHandler.open();
					databaseHandler.removePerson(contactArrayList.get(position).getId());
					databaseHandler.close();
					populateList();
				 
				Intent viewEvent = new Intent();
				viewEvent.setClass(getApplicationContext(), EventDetailsActivity.class);
				viewEvent.putExtra("SelectedEvent", eventsArrayList.get(position));///////
				startActivity(viewEvent); 
			}
		});

	} 

}

*/