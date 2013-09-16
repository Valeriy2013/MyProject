package com.sokolovskiy.activities;

import com.sokolovskiy.mainpackage.WebViewStandingsClient;
import com.sokolovskiy.ukrbasketsuperleague.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;


public class StandingsActivity extends Activity {
	WebView wv;
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_standings);
		wv = (WebView) findViewById(R.id.wv);
		wv.setWebViewClient(new WebViewStandingsClient());		
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setDefaultTextEncodingName("UTF-8");
		wv.getSettings().setUseWideViewPort(true);
		wv.getSettings().setBuiltInZoomControls(true);		
		wv.setInitialScale(30);
//		AssetManager am = getAssets();
//		try {
//			String[] files = am.list("index.html");
//			File f = new File(files[0]);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		wv.loadUrl("file:///android_asset/index.html");
		
		//StandingsActivity.WebView webView = (WebView)findViewById(R.id.webView);
		//String str = "<div class=\"mbt-content\" id=\"5-301-standings-container\"><div class=\"mbt-subheader\">Регул�?рний чемпіонат</div><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mbt-table mbt-complex\">   <tbody><tr><th class=\"first\" width=\"40\">№</th><th class=\"mbt-left\">клуб</th>  <th width=\"40\" title=\"ігри\">	І   </th>  <th width=\"40\" title=\"виграші\"> 	В   </th>   <th width=\"40\" title=\"поразки\">  	П      </th> <th width=\"40\">%</th>  </tr>   <tr class=\"row1\">	<td class=\"first\" nowrap=\"nowrap\" style=\"\">  1.  </td>          <td class=\"mbt-left\">Будивельник  </td><td>39      </td>       <td>28</td>     <td>11</td>       <td>71.8</td> </tr>    <tr class=\"row2\">	<td class=\"first\" nowrap=\"nowrap\" style=\"\">  2.  </td>          <td class=\"mbt-left\">пвапвапвапвап  </td><td>39      </td>       <td>28</td>     <td>11</td>       <td>71.8</td> </tr>    ";
		//webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
//		TextView textView1 = (TextView) findViewById(R.id.txtView);		
//		//textView1.append("Турнирна�? таблица \n\n");
//		textView1.append("№     Клуб                                         И    В    П    %\n");
//		textView1.append("1.    БК Будівельник (Київ)       39  28  11  71.8\n");
//		textView1.append("2.    БК �?зовмаш (Маріуполь)      39  28  11  71.8\n");
//		textView1.append("3.    БК Ферро - З�?ТУ (Запоріжж�?)\n");
//		textView1.append("4.    БК Політехніка - Галичина (Львів)\n");
//		textView1.append("5.    БК Хімік (Южне)\n");
//		textView1.append("6.    БК Донецьк (Донецьк)\n");
//		textView1.append("7.    БК Черка�?ькі Мавпи (Черка�?и)\n");
//		textView1.append("8.    БК Говерла (Івано-Франків�?ьк)\n");
//		textView1.append("9.    БК Кривба�?ба�?кет (Кривий Ріг)\n");
//		textView1.append("10.  МБК Миколаїв (Миколаїв)\n");
//		textView1.append("11.  БК Дніпро (Дніпропетров�?ьк)\n");
//		textView1.append("12.  БК ОДЕС�? (Оде�?а)\n");
//		textView1.append("13.  БК Дніпро-�?зот (Дніпродзержин�?ьк)\n");
//		textView1.append("14.  БК Київ (Київ)\n");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.standings, menu);
		return true;
	}

}
