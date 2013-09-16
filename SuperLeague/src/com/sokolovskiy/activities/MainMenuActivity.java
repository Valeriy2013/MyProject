package com.sokolovskiy.activities;

import com.sokolovskiy.ukrbasketsuperleague.R;

import android.os.Bundle;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainMenuActivity extends Activity implements OnClickListener {// OnTouchListener
																			// {

	AnimatorSet pressDown, pressUp;
	Button teamsBtn, playersBtn, newsBtn, videoBtn, photoBtn, statsBtn,
			tableBtn;
	ObjectAnimator objAntranslateX;
	ObjectAnimator objAntranslateY;
	final int dxy = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		teamsBtn = (Button) findViewById(R.id.btn_teams);
		playersBtn = (Button) findViewById(R.id.btn_players);
		newsBtn = (Button) findViewById(R.id.btn_news);
		videoBtn = (Button) findViewById(R.id.btn_video);
		photoBtn = (Button) findViewById(R.id.btn_photo);
		statsBtn = (Button) findViewById(R.id.btn_stats);
		tableBtn = (Button) findViewById(R.id.btn_table);		

		teamsBtn.setOnClickListener(this);
		playersBtn.setOnClickListener(this);
		newsBtn.setOnClickListener(this);
		videoBtn.setOnClickListener(this);
		photoBtn.setOnClickListener(this);
		statsBtn.setOnClickListener(this);
		tableBtn.setOnClickListener(this);

		pressUp = (AnimatorSet) AnimatorInflater.loadAnimator(this,
				R.animator.animation_up);
		pressDown = (AnimatorSet) AnimatorInflater.loadAnimator(this,
				R.animator.animation_down);

		pressDown.setTarget(teamsBtn);
		pressUp.setTarget(teamsBtn);

	}

	/*
	 * @Override public boolean onTouch(View v, MotionEvent event) { Intent
	 * intent;
	 * 
	 * switch (event.getActionMasked()) { case MotionEvent.ACTION_DOWN: switch
	 * (v.getId()) { case R.id.btn_teams: pressDown = new AnimatorSet();
	 * //pressUp = new AnimatorSet(); objAntranslateX =
	 * ObjectAnimator.ofFloat(teamsBtn, "X", teamsBtn.getX(),
	 * teamsBtn.getX()+dxy); objAntranslateY = ObjectAnimator.ofFloat(teamsBtn,
	 * "Y", teamsBtn.getY(), teamsBtn.getY()+dxy);
	 * pressDown.play(objAntranslateX).with(objAntranslateY); pressDown.start();
	 * // objAntranslateX = ObjectAnimator.ofFloat(teamsBtn, "X",
	 * teamsBtn.getX(), teamsBtn.getX()-dxy); // objAntranslateY =
	 * ObjectAnimator.ofFloat(teamsBtn, "Y", teamsBtn.getY(),
	 * teamsBtn.getY()-dxy); //
	 * pressDown.play(objAntranslateX).with(objAntranslateY); //
	 * pressDown.start(); intent = new Intent(this, TeamsActivity.class);
	 * startActivity(intent); break; case R.id.btn_players: pressDown = new
	 * AnimatorSet(); objAntranslateX = ObjectAnimator.ofFloat(playersBtn, "X",
	 * playersBtn.getX(), playersBtn.getX()+dxy); objAntranslateY =
	 * ObjectAnimator.ofFloat(playersBtn, "Y", playersBtn.getY(),
	 * playersBtn.getY()+dxy);
	 * pressDown.play(objAntranslateX).with(objAntranslateY); pressDown.start();
	 * intent = new Intent(this, PlayersActivity.class); startActivity(intent);
	 * break; case R.id.btn_photo: pressDown = new AnimatorSet();
	 * objAntranslateX = ObjectAnimator.ofFloat(photoBtn, "X", photoBtn.getX(),
	 * photoBtn.getX()+dxy); objAntranslateY = ObjectAnimator.ofFloat(photoBtn,
	 * "Y", photoBtn.getY(), photoBtn.getY()+dxy);
	 * pressDown.play(objAntranslateX).with(objAntranslateY); pressDown.start();
	 * intent = new Intent(this, PhotoActivity.class); startActivity(intent);
	 * break; case R.id.btn_news: pressDown = new AnimatorSet(); objAntranslateX
	 * = ObjectAnimator.ofFloat(newsBtn, "X", newsBtn.getX(),
	 * newsBtn.getX()+dxy); objAntranslateY = ObjectAnimator.ofFloat(newsBtn,
	 * "Y", newsBtn.getY(), newsBtn.getY()+dxy);
	 * pressDown.play(objAntranslateX).with(objAntranslateY); pressDown.start();
	 * intent = new Intent(this, NewsActivity.class); startActivity(intent);
	 * break; case R.id.btn_video: pressDown = new AnimatorSet();
	 * objAntranslateX = ObjectAnimator.ofFloat(videoBtn, "X", videoBtn.getX(),
	 * videoBtn.getX()+dxy); objAntranslateY = ObjectAnimator.ofFloat(videoBtn,
	 * "Y", videoBtn.getY(), videoBtn.getY()+dxy);
	 * pressDown.play(objAntranslateX).with(objAntranslateY); pressDown.start();
	 * intent = new Intent(this, VideoActivity.class); startActivity(intent);
	 * break; case R.id.btn_table: pressDown = new AnimatorSet();
	 * objAntranslateX = ObjectAnimator.ofFloat(tableBtn, "X", tableBtn.getX(),
	 * tableBtn.getX()+dxy); objAntranslateY = ObjectAnimator.ofFloat(tableBtn,
	 * "Y", tableBtn.getY(), tableBtn.getY()+dxy);
	 * pressDown.play(objAntranslateX).with(objAntranslateY); pressDown.start();
	 * intent = new Intent(this, StandingsActivity.class);
	 * startActivity(intent); break; case R.id.btn_stats: pressDown = new
	 * AnimatorSet(); objAntranslateX = ObjectAnimator.ofFloat(statsBtn, "X",
	 * statsBtn.getX(), statsBtn.getX()+dxy); objAntranslateY =
	 * ObjectAnimator.ofFloat(statsBtn, "Y", statsBtn.getY(),
	 * statsBtn.getY()+dxy);
	 * pressDown.play(objAntranslateX).with(objAntranslateY); pressDown.start();
	 * intent = new Intent(this, StatsActivity.class); startActivity(intent);
	 * break; } break; case MotionEvent.ACTION_UP: switch (v.getId()) { case
	 * R.id.btn_teams: pressUp = new AnimatorSet(); objAntranslateX =
	 * ObjectAnimator.ofFloat(teamsBtn, "X", teamsBtn.getX(),
	 * teamsBtn.getX()-dxy); objAntranslateY = ObjectAnimator.ofFloat(teamsBtn,
	 * "Y", teamsBtn.getY(), teamsBtn.getY()-dxy);
	 * pressUp.play(objAntranslateX).with(objAntranslateY); pressUp.start();
	 * break; case R.id.btn_players: pressUp = new AnimatorSet();
	 * objAntranslateX = ObjectAnimator.ofFloat(playersBtn, "X",
	 * playersBtn.getX(), playersBtn.getX()-dxy); objAntranslateY =
	 * ObjectAnimator.ofFloat(playersBtn, "Y", playersBtn.getY(),
	 * playersBtn.getY()-dxy);
	 * pressUp.play(objAntranslateX).with(objAntranslateY); pressUp.start();
	 * break; case R.id.btn_photo: pressUp = new AnimatorSet(); objAntranslateX
	 * = ObjectAnimator.ofFloat(photoBtn, "X", photoBtn.getX(),
	 * photoBtn.getX()-dxy); objAntranslateY = ObjectAnimator.ofFloat(photoBtn,
	 * "Y", photoBtn.getY(), photoBtn.getY()-dxy);
	 * pressUp.play(objAntranslateX).with(objAntranslateY); pressUp.start();
	 * break; case R.id.btn_news: pressUp = new AnimatorSet(); objAntranslateX =
	 * ObjectAnimator.ofFloat(newsBtn, "X", newsBtn.getX(), newsBtn.getX()-dxy);
	 * objAntranslateY = ObjectAnimator.ofFloat(newsBtn, "Y", newsBtn.getY(),
	 * newsBtn.getY()-dxy); pressUp.play(objAntranslateX).with(objAntranslateY);
	 * pressUp.start(); break; case R.id.btn_video: pressUp = new AnimatorSet();
	 * objAntranslateX = ObjectAnimator.ofFloat(videoBtn, "X", videoBtn.getX(),
	 * videoBtn.getX()-dxy); objAntranslateY = ObjectAnimator.ofFloat(videoBtn,
	 * "Y", videoBtn.getY(), videoBtn.getY()-dxy);
	 * pressUp.play(objAntranslateX).with(objAntranslateY); pressUp.start();
	 * break; case R.id.btn_table: pressUp = new AnimatorSet(); objAntranslateX
	 * = ObjectAnimator.ofFloat(tableBtn, "X", tableBtn.getX(),
	 * tableBtn.getX()-dxy); objAntranslateY = ObjectAnimator.ofFloat(tableBtn,
	 * "Y", tableBtn.getY(), tableBtn.getY()-dxy);
	 * pressUp.play(objAntranslateX).with(objAntranslateY); pressUp.start();
	 * break; case R.id.btn_stats: pressUp = new AnimatorSet(); objAntranslateX
	 * = ObjectAnimator.ofFloat(statsBtn, "X", statsBtn.getX(),
	 * statsBtn.getX()-dxy); objAntranslateY = ObjectAnimator.ofFloat(statsBtn,
	 * "Y", statsBtn.getY(), statsBtn.getY()-dxy);
	 * pressUp.play(objAntranslateX).with(objAntranslateY); pressUp.start();
	 * break; } break; }
	 * 
	 * return false; }
	 */

	@Override
	public void onClick(View v) {
		 final Animation animTranslate = AnimationUtils.loadAnimation(this,
		 R.anim.anim_translate);
		 final Animation animAlpha = AnimationUtils.loadAnimation(this,
		 R.anim.anim_alpha);
		// final Animation animScale = AnimationUtils.loadAnimation(this,
		 //R.anim.anim_scale);
		 final Animation animRotate = AnimationUtils.loadAnimation(this,
		 R.anim.anim_rotate);

		Intent intent;

		switch (v.getId()) {
		case R.id.btn_teams:
			 v.startAnimation(animAlpha);
			intent = new Intent(this, TeamsActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_players:
			 v.startAnimation(animTranslate);
			intent = new Intent(this, PlayersActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_photo:
			 v.startAnimation(animTranslate);
			intent = new Intent(this, PhotoActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_news:
			 v.startAnimation(animAlpha);
			intent = new Intent(this, NewsActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_video:
			 v.startAnimation(animAlpha);
			intent = new Intent(this, VideoActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_table:
			 v.startAnimation(animRotate);
			intent = new Intent(this, StandingsActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_stats:
			 v.startAnimation(animTranslate);
			intent = new Intent(this, StatsActivity.class);
			startActivity(intent);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		// Операции дл�? выбранного пункта меню
		switch (item.getItemId()) {
		case R.id.action_news:
			intent = new Intent(this, NewsActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_photo:
			intent = new Intent(this, PhotoActivity.class);
			startActivity(intent);			
			return true;
		case R.id.action_players:
			intent = new Intent(this, PlayersActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_standings:
			intent = new Intent(this, StandingsActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_stats:
			intent = new Intent(this, StatsActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_teams:
			intent = new Intent(this, TeamsActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_video:
			intent = new Intent(this, VideoActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
