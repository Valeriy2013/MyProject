package com.sokolovskiy.activities;


import com.sokolovskiy.mainpackage.ImageAdapter;
import com.sokolovskiy.ukrbasketsuperleague.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class PhotoActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);
	    ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
	    ImageAdapter adapter = new ImageAdapter(this);
	    viewPager.setAdapter(adapter);
	}	
}
