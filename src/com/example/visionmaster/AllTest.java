package com.example.visionmaster;

import com.example.visionmaster.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class AllTest extends Activity implements OnClickListener {
	ImageButton colortest, visualacuity, cameraApplication, questions,motorTest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alltest);
		colortest = (ImageButton) findViewById(id.colorTest);
		colortest.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.colorTest:
			intent = new Intent(AllTest.this, FirstPage.class);
			startActivity(intent);
			break;
				default:
			break;
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
