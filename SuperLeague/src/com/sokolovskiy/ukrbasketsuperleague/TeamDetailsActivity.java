package com.sokolovskiy.ukrbasketsuperleague;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TeamDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_team_details);
		String value = getIntent().getExtras().getString("teamDetails");
		TextView tv = (TextView)findViewById(R.id.tv);
		tv.setBackgroundResource(R.drawable.backrepeat);
		tv.setText(value);	
//		WebView webView = (WebView) findViewById(R.id.webView1);
//		webView.getSettings().setJavaScriptEnabled(true);
//		webView.loadUrl("http://www.superleague.ua/club/4008.htm");
		
	}
}
