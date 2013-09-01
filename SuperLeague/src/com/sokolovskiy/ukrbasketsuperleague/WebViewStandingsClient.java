package com.sokolovskiy.ukrbasketsuperleague;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewStandingsClient extends WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		return true;
	}

}
