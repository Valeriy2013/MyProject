package com.sokolovskiy.utils;


import java.util.HashMap;
import java.util.List;

import com.sokolovskiy.ukrbasketsuperleague.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BinderData extends BaseAdapter {

//<player>
//    <id>1</id>
//	<name>Иван Иванов</name>
//   <position>форвард</position>
//   <age>25</age>
//	<_height>212</_height>
//	<weight>111</weight>
//	<citizenship>Украина</citizenship>
//	<team>БК Одесса</team>
//	<photo>photo1</photo>
//</player>
	
	// XML node keys
    static final String KEY_TAG = "player"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_POS= "position";
    static final String KEY_AGE = "age";
    static final String KEY_HEIGHT = "_height";
    static final String KEY_WEIGHT = "weight";
    static final String KEY_CITIZ = "citizenship";
    static final String KEY_TEAM = "team";
    static final String KEY_PHOTO = "photo";
   
	
	LayoutInflater inflater;
	ImageView thumb_image;
	List<HashMap<String,String>> playersDataCollection;
	ViewHolder holder;
	public BinderData() {
		// TODO Auto-generated constructor stub
	}
	
	public BinderData(Activity act, List<HashMap<String,String>> map) {
		
		this.playersDataCollection = map;
		
		inflater = (LayoutInflater) act
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	

	public int getCount() {
		// TODO Auto-generated method stub
//		return idlist.size();
		return playersDataCollection.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		 
		View vi=convertView;
	    if(convertView==null){
	     
	      vi = inflater.inflate(R.layout.list_row, null);
	      holder = new ViewHolder();
	      
	      holder.tvId = (TextView)vi.findViewById(R.id.tvId); 
	      holder.tvName = (TextView)vi.findViewById(R.id.tvName); 
//	      holder.tvAge = (TextView)vi.findViewById(R.id.tvAge); 
	      holder.tvPosition =  (TextView)vi.findViewById(R.id.tvPosition); 
//	      holder.tvHeight =  (TextView)vi.findViewById(R.id.tvHeight); 
//	      holder.tvWeight =  (TextView)vi.findViewById(R.id.tvWeight); 
//	      holder.tvCitizenship =  (TextView)vi.findViewById(R.id.tvCitizenship); 
	      holder.tvTeam =  (TextView)vi.findViewById(R.id.tvTeam);
	      holder.tvPlayerPhoto =(ImageView)vi.findViewById(R.id.list_image); // thumb image
	 
	      vi.setTag(holder);
	    }
	    else{
	    	
	    	holder = (ViewHolder)vi.getTag();
	    }

	      // Setting all values in listview
	      holder.tvId.setText(playersDataCollection.get(position).get(KEY_ID));
	      holder.tvName.setText(playersDataCollection.get(position).get(KEY_NAME));
//	      holder.tvAge.setText(playersDataCollection.get(position).get(KEY_AGE));
	      holder.tvPosition.setText(playersDataCollection.get(position).get(KEY_POS));
//	      holder.tvHeight.setText(playersDataCollection.get(position).get(KEY_HEIGHT));
//	      holder.tvWeight.setText(playersDataCollection.get(position).get(KEY_WEIGHT));
//	      holder.tvCitizenship.setText(playersDataCollection.get(position).get(KEY_CITIZ));
	      holder.tvTeam.setText(playersDataCollection.get(position).get(KEY_TEAM));
	      
	      //Setting an image
	      String uri = "drawable/"+ playersDataCollection.get(position).get(KEY_PHOTO);
	      int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
	      Drawable image = vi.getContext().getResources().getDrawable(imageResource);
	      holder.tvPlayerPhoto.setImageDrawable(image);
	      
	      return vi;
	}	

	
	static class ViewHolder{
		
		TextView tvId;
		TextView tvName;
		TextView tvPosition;
		TextView tvAge;
		TextView tvHeight;
		TextView tvWeight;
		TextView tvCitizenship;
		TextView tvTeam;		
		ImageView tvPlayerPhoto;
	}
	
}
