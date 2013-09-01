package com.sokolovskiy.ukrbasketsuperleague;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamsArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
 
	public TeamsArrayAdapter(Context context, String[] values) {
		super(context, R.layout.list_of_teams, values);
		this.context = context;
		this.values = values;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.list_of_teams, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
		
		System.out.println(s);
 
		if (s.equals("Одесса")) {
			imageView.setImageResource(R.drawable.team_odessa);
		} else if (s.equals("Азовмаш")) {
			imageView.setImageResource(R.drawable.team_azomash);
		} else if (s.equals("Донецк")) {
			imageView.setImageResource(R.drawable.team_donetsk);
		} else if (s.equals("Киев")){
			imageView.setImageResource(R.drawable.team_kiev);
		} else if (s.equals("Говерла")){
			imageView.setImageResource(R.drawable.team_goverla);
		} else if (s.equals("Будивельник")){
			imageView.setImageResource(R.drawable.team_budka);
		} else if (s.equals("Химик")){
			imageView.setImageResource(R.drawable.team_khimik);
		} else if (s.equals("Черкасские мавпы")){
			imageView.setImageResource(R.drawable.team_cherkasi);
		} else if (s.equals("Ферро-ЗНТУ")){
			imageView.setImageResource(R.drawable.team_ferro);
		} else if (s.equals("Крывбассбаскет")){
			imageView.setImageResource(R.drawable.team_krivbas);
		} else if (s.equals("Галичина")){
			imageView.setImageResource(R.drawable.team_galichina);
		} else if (s.equals("Днепр")){
			imageView.setImageResource(R.drawable.team_dnepr);
		} else if (s.equals("Днепр-Азот")){
			imageView.setImageResource(R.drawable.team_azot);
		} else if (s.equals("Николаев")){
			imageView.setImageResource(R.drawable.team_nikolaev);
		}		
 
		return rowView;
	}
}