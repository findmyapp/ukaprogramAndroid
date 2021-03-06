package no.uka.findmyapp.ukaprogram.adapters;

import java.util.List;

import no.uka.findmyapp.android.rest.datamodels.models.UkaEvent;
import no.uka.findmyapp.ukaprogram.R;
import no.uka.findmyapp.ukaprogram.utils.DateUtils;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DayListAdapter extends ArrayAdapter<UkaEvent> {
	private int textViewResourceId;

	public DayListAdapter(Context context, int textViewResourceId, List<UkaEvent> items) {	
		super(context, textViewResourceId, items);
		this.textViewResourceId = textViewResourceId;
	}

	public View getView(int position, View convertView, ViewGroup parent){
		LinearLayout eventView = null;
		UkaEvent event = getItem(position);

		if(convertView == null){
			eventView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
			vi.inflate(textViewResourceId, eventView, true);
		}
		else
		{
			eventView = (LinearLayout) convertView;
		}

		TextView title = (TextView) eventView.findViewById(R.id.date_list_title);
		TextView startTime = (TextView) eventView.findViewById(R.id.date_list_time);
		TextView place = (TextView) eventView.findViewById(R.id.date_list_place);
		TextView category = (TextView) eventView.findViewById(R.id.date_list_event_type);
		
		title.setText(event.getTitle());
		place.setText(event.getPlace());
		startTime.setText(new DateUtils().getTimeFromTimestamp(event.getShowingTime()));
		category.setText(event.getEventType());
		
		return eventView;
	}
}
