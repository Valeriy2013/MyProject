package com.sokolovskiy.ukrbasketsuperleague;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		 showVideo();
    }
 private void showVideo()
 {
     VideoView vd = (VideoView)findViewById(R.id.videoview);
     Uri uri = Uri.parse("http://www.youtube.com/watch?v=3rJ_7MqIlSY");
     MediaController mc = new MediaController(this);
     vd.setMediaController(mc);
     vd.setVideoURI(uri);
     vd.start();
 }
}