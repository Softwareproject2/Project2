package com.example.visionmaster;

import com.example.visionmaster.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DemoTourTwo extends Activity {
	ImageView moverightsecond, moveleftsecond;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demotourtwo);
		moverightsecond = (ImageView) findViewById(id.moverightsecond);
		moveleftsecond = (ImageView) findViewById(id.moveleftsecond);
		moverightsecond.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DemoTourTwo.this,
						DemoTourThree.class);
				startActivity(intent);
			}
		});
		moveleftsecond.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DemoTourTwo.this, DemoTourOne.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DemoTourTwo.this, Demoalltestscreen.class);
		startActivity(intent);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
