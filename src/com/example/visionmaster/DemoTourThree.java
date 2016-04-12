package com.example.visionmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.visionmaster.R.id;

public class DemoTourThree extends Activity {
	ImageView moverightthird, moveleftthird;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demotourthree);
		moverightthird = (ImageView) findViewById(id.moverightthird);
		moveleftthird = (ImageView) findViewById(id.moveleftthird);
		moverightthird.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoTourThree.this,
						DemoTourFour.class);
				startActivity(intent);
			}
		});
		moveleftthird.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DemoTourThree.this,
						DemoTourTwo.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DemoTourThree.this, Demoalltestscreen.class);
		startActivity(intent);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
