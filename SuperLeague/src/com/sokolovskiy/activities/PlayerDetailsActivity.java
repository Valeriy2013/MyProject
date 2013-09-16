package com.sokolovskiy.activities;

import com.sokolovskiy.ukrbasketsuperleague.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;



public class PlayerDetailsActivity extends Activity {
	
//    static final String KEY_ID = "id";
//    static final String KEY_NAME = "name";
//    static final String KEY_POS= "position";
//    static final String KEY_AGE = "age";
//    static final String KEY_HEIGHT = "_height";
//    static final String KEY_WEIGHT = "weight";
//    static final String KEY_CITIZ = "citizenship";
//    static final String KEY_TEAM = "team";
//    static final String KEY_PHOTO = "photo";
	
	String id = "";
	String name = "";
	String position = "";
	String age = "";
	String _height = "";
	String weight = "";
	String citizenship = "";
	String team = "";
	String photo = "";
	ImageButton imgTeamIcon;
	
	TextView tvName;
	TextView tvPosition;
	TextView tvAge;
	TextView tvHeight;
	TextView tvWeight;
	TextView tvCitizenship;
	TextView tvTeam;
	TextView tvNumber;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        
		try {
			
			
			imgTeamIcon = (ImageButton) findViewById(R.id.imageButtonAlpha);
			tvNumber = (TextView)findViewById(R.id.tvNumber);
			tvName = (TextView) findViewById(R.id.tvName);
			tvPosition = (TextView) findViewById(R.id.tvPosition);
			tvAge = (TextView) findViewById(R.id.tvAge);
			tvHeight = (TextView) findViewById(R.id.tvHeight);
			tvWeight = (TextView) findViewById(R.id.tvWeight);
			tvCitizenship = (TextView) findViewById(R.id.tvCitizen);
			tvTeam = (TextView) findViewById(R.id.tvTeam);			
			
			// Get position to display
	        Intent i = getIntent();
	        
	        //this.position = i.getStringExtra("position");
	        this.id = i.getStringExtra("id");
	        this.name = i.getStringExtra("name");
	        this.position =	i.getStringExtra("position");
	        this.age=	i.getStringExtra("age");
	        this._height =  i.getStringExtra("_height");
	        this.weight =  i.getStringExtra("weight");
	        this.citizenship =  i.getStringExtra("citizenship");
	        this.team =  i.getStringExtra("team");
	        this.photo = i.getStringExtra("photo");
	        
	        String uri = "drawable/"+ photo;   //HERE image name
	        int imageBtnResource = getResources().getIdentifier(uri, null, getPackageName());
		    Drawable dimgbutton = getResources().getDrawable(imageBtnResource);
		
		    
		    //text elements
		    tvName.setText(name);
		    tvNumber.setText(id);
		    tvPosition.setText(position);
		    tvAge.setText("Возра�?т: "+ age);
		    tvHeight.setText("Ро�?т: " + _height);
		    tvWeight.setText("Ве�?: "+ weight);
		    tvCitizenship.setText("Гражд.: "+ citizenship);
		    tvTeam.setText("Клуб: "+ team);
		    //tvTeam.append(" Карьера.. Таблица где играл раньше");
		    
		    //thumb_image.setImageDrawable(image);
		    imgTeamIcon.setImageDrawable(dimgbutton);
		
			
		}
		
		catch (Exception ex) {
			Log.e("Error", "Loading exception");
		}
		
    } 
   
}
