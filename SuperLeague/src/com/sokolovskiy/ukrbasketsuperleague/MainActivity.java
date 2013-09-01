package com.sokolovskiy.ukrbasketsuperleague;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageButton btn = (ImageButton)findViewById(R.id.btn_super_league);
		btn.setOnClickListener(this);		
	}
	
	@Override
	public void onClick(View v) {
		Intent i  = new Intent(this, MainMenuActivity.class);
		startActivity(i);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
