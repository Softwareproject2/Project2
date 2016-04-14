package com.example.visionmaster;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MotorTestvideo extends Activity {
	VideoView video_player_view;
	DisplayMetrics dm;
	SurfaceView sur_View;
	MediaController media_Controller;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.motortesttutorial);
		getInit();
	}

	public void getInit() {
		video_player_view = (VideoView) findViewById(R.id.video_player_view);
		media_Controller = new MediaController(this);

		Uri uri = Uri
				.parse("android.resource://com.example.videotut/raw/motortest");
		video_player_view.setMediaController(media_Controller);
		video_player_view.setVideoURI(uri);
		video_player_view.start();
	}

	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(MotorTestvideo.this, Demoalltestscreen.class);
		startActivity(intent);
		finish();
	}
}
