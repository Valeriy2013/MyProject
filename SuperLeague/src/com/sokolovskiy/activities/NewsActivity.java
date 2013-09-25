package com.sokolovskiy.activities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;

import com.perm.kate.api.Api;
import com.perm.kate.api.KException;
import com.perm.kate.api.WallMessage;
import com.sokolovskiy.constants.Constants;
import com.sokolovskiy.mainpackage.Account;
import com.sokolovskiy.mainpackage.ExpandableListAdapter;
import com.sokolovskiy.mainpackage.Parent;
import com.sokolovskiy.ukrbasketsuperleague.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

public class NewsActivity extends Activity {

	private final int REQUEST_LOGIN = 1;

	private ImageButton authorizeButton;
	private ImageButton logoutButton;		
	private ExpandableListView mExpandableList;
	private ArrayList<WallMessage> al = new ArrayList<WallMessage>();
	private ArrayList<Parent> arrayParents = new ArrayList<Parent>();
	private ArrayList<String> arrayChildren = new ArrayList<String>();
	Account account = new Account();
	Api vkapi;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		setupUI();

		// Во�?�?тановление �?охранённой �?е�?�?ии
		account.restore(this);

		// Е�?ли �?е�?�?и�? е�?ть �?оздаём API дл�? обращени�? к �?ерверу
		if (account.access_token != null)
			vkapi = new Api(account.access_token, Constants.API_ID);

		showButtons();

	}

	private void setupUI() {
		authorizeButton = (ImageButton) findViewById(R.id.authorizeVK);
		logoutButton = (ImageButton) findViewById(R.id.logout);		
		mExpandableList = (ExpandableListView) findViewById(R.id.expandable_list);		
		authorizeButton.setOnClickListener(authorizeClick);
		logoutButton.setOnClickListener(logoutClick);		
	}

	private OnClickListener authorizeClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			startLoginActivity();
		}
	};

	private OnClickListener logoutClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			logOut();
		}
	};


	private void startLoginActivity() {
		Intent intent = new Intent();
		intent.setClass(this, LoginActivity.class);
		startActivityForResult(intent, REQUEST_LOGIN);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_LOGIN) {
			if (resultCode == RESULT_OK) {
				// авторизовали�?ь у�?пешно
				account.access_token = data.getStringExtra("token");
				account.user_id = data.getLongExtra("user_id", 0);
				account.save(NewsActivity.this);
				vkapi = new Api(account.access_token, Constants.API_ID);
				showButtons();				
				
			}
		}
	}

	private void displayNews() {
		new Thread() {
			@Override
			public void run() {
				try {		
					arrayParents = new ArrayList<Parent>();
					arrayChildren = new ArrayList<String>();
					al = vkapi.getWallMessages(Constants.VK_GROUP_ID,
							Constants.AMOUNT_OF_NEW_POSTS, 0, "all");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (KException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < Constants.AMOUNT_OF_NEW_POSTS; i++) {
					// for each "i" create a new Parent object to set the title and the children
					Parent parent = new Parent();
					
					if(!al.get(i).text.equals("") && al.get(i).text.length() > 30){
					parent.setTitle(" " + al.get(i).text.substring(0, 30).toString() + "...");

					arrayChildren = new ArrayList<String>();					
					arrayChildren.add(" " + al.get(i).text.toString());				
					parent.setArrayChildren(arrayChildren);

					// in this array we add the Parent object. We will use the
					// arrayParents at the setAdapter
					arrayParents.add(parent);
					}
				}
				runOnUiThread(new Runnable() {
					public void run() {						
						mExpandableList.setAdapter(new ExpandableListAdapter(
								NewsActivity.this, arrayParents));
					}
				});

			}
		}.start();
	}

	private void logOut() {
		vkapi = null;
		account.access_token = null;
		account.user_id = 0;
		account.save(NewsActivity.this);		
		showButtons();
	}

	void showButtons() {
		if (vkapi != null) {
			authorizeButton.setVisibility(View.GONE);
			logoutButton.setVisibility(View.VISIBLE);			
			mExpandableList.setVisibility(View.VISIBLE);
			displayNews();
		} else {
			authorizeButton.setVisibility(View.VISIBLE);
			logoutButton.setVisibility(View.GONE);			
			mExpandableList.setVisibility(View.GONE);			
		}
	}
}