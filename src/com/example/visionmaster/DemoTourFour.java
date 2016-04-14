package com.example.visionmaster;

import com.example.visionmaster.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DemoTourFour extends Activity {
	ImageView moverightfourth, moveleftfourth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demotourfour);
		moverightfourth = (ImageView) findViewById(R.id.moverightfourth);
		moveleftfourth = (ImageView) findViewById(R.id.moveleftfourth);
		moverightfourth.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DemoTourFour.this,
						DemoTourFive.class);
				startActivity(intent);
			}
		});
		moveleftfourth.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DemoTourFour.this,
						DemoTourThree.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DemoTourFour.this, Demoalltestscreen.class);
		startActivity(intent);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
