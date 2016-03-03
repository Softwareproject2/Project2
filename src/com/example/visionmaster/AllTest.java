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
		visualacuity = (ImageButton) findViewById(id.visualAcuity);
		visualacuity.setOnClickListener(this);
		cameraApplication = (ImageButton) findViewById(id.cameraApplication);
		cameraApplication.setOnClickListener(this);
		questions = (ImageButton) findViewById(R.id.questions);
		questions.setOnClickListener(this);
		motorTest = (ImageButton) findViewById(R.id.motorTest);
		motorTest.setOnClickListener(this);
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
		case R.id.visualAcuity:
			intent = new Intent(AllTest.this, VisualAcuity.class);
			startActivity(intent);
			break;
//		case R.id.cameraApplication:
//			intent = new Intent(AllTest.this, CameraActivity.class);
//			startActivity(intent);
//			break;
		case R.id.questions:
			intent = new Intent(AllTest.this, Question1.class);
			startActivity(intent);
			break;
//		case R.id.motorTest:
//			intent = new Intent(AllTest.this, MotorTest.class);
//			startActivity(intent);
//			break;
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

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(AllTest.this, LoginScreen.class);
		startActivity(intent);
		Toast.makeText(getApplicationContext(), "You are logged out.", 0)
				.show();
	}
}
