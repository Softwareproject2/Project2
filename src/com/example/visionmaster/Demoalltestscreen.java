package com.example.visionmaster;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.visionmaster.*;

public class Demoalltestscreen extends Activity implements OnClickListener {
	ImageButton democolortest, demovisualacuity, democameraApplication,
			demoquestions, demomotorTest;
	Dialog dialog;
	AlertDialog alertDialog;
	LayoutInflater factory;
	AlertDialog.Builder alertDialogBuilder;
	Button gotit, tutorial;
	View view;
	TextView alltestdescfirst, alltestdescsecond;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demoalltestscreen);
		democolortest = (ImageButton) findViewById(R.id.democolorTest);
		democolortest.setOnClickListener(this);
		demovisualacuity = (ImageButton) findViewById(R.id.demovisualAcuity);
		demovisualacuity.setOnClickListener(this);
		democameraApplication = (ImageButton) findViewById(R.id.democameraApplication);
		democameraApplication.setOnClickListener(this);
		demoquestions = (ImageButton) findViewById(R.id.demoquestions);
		demoquestions.setOnClickListener(this);
		demomotorTest = (ImageButton) findViewById(R.id.demomotorTest);
		demomotorTest.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.democolorTest:
			LayoutInflater factory = LayoutInflater
					.from(Demoalltestscreen.this);
			View view = factory
					.inflate(R.layout.demoalltestscreeninflate, null);
			Button gotit = (Button) view.findViewById(R.id.gotit);
			tutorial = (Button) view.findViewById(R.id.tutorial);
			tutorial.setVisibility(Button.GONE);
			alltestdescfirst = (TextView) view
					.findViewById(R.id.alltestdescfirst);
			alltestdescfirst
					.setText("This test is designed to test any colour weakness in your eyes.Colour efficiency is a common problem.");
			alltestdescsecond = (TextView) view
					.findViewById(R.id.alltestdescsecond);
			alltestdescsecond
					.setText("Wear your contacts or glasses if you normally wear them.A coloured pattern will be displayed composed of circular dots.You must try to identify the number in the pattern.");
			gotit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
					alertDialog.cancel();
				}
			});
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					Demoalltestscreen.this);
			alertDialogBuilder.setView(view).setCancelable(false);
			alertDialog = alertDialogBuilder.create();
			alertDialog.show();

			break;
		case R.id.demovisualAcuity:
			factory = LayoutInflater.from(Demoalltestscreen.this);
			view = factory.inflate(R.layout.demoalltestscreeninflate, null);
			gotit = (Button) view.findViewById(R.id.gotit);
			tutorial = (Button) view.findViewById(R.id.tutorial);
			tutorial.setVisibility(Button.GONE);
			alltestdescfirst = (TextView) view
					.findViewById(R.id.alltestdescfirst);
			alltestdescfirst
					.setText("This test is designed to test your clearness of vision and your eye's ability to distinguish object details and shapes.");
			alltestdescsecond = (TextView) view
					.findViewById(R.id.alltestdescsecond);
			alltestdescsecond
					.setText("Wear your contacts or glasses if you normally wear them.Hold your device 30cm away from your eyes.A letter will be displayed and you must answer with which letter you saw.");
			gotit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
					alertDialog.cancel();
				}
			});
			alertDialogBuilder = new AlertDialog.Builder(Demoalltestscreen.this);
			alertDialogBuilder.setView(view).setCancelable(false);
			alertDialog = alertDialogBuilder.create();
			alertDialog.show();
			break;
		case R.id.democameraApplication:
			factory = LayoutInflater.from(Demoalltestscreen.this);
			view = factory.inflate(R.layout.demoalltestscreeninflate, null);
			gotit = (Button) view.findViewById(R.id.gotit);
			tutorial = (Button) view.findViewById(R.id.tutorial);
			tutorial.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Demoalltestscreen.this,DemoTourOne.class);
					startActivity(intent);
				}
			});
			alltestdescfirst = (TextView) view
					.findViewById(R.id.alltestdescfirst);
			alltestdescfirst
					.setText("The Camera Capture provides an interface through which you can click pictures of your eyes.");
			alltestdescsecond = (TextView) view
					.findViewById(R.id.alltestdescsecond);
			alltestdescsecond
					.setText("Lit the room properly and carefully place your eyes inside the grids provided on the camera screen.Follow the audio instructions and proceed further towards the next step. ");
			gotit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
					alertDialog.cancel();
				}
			});
			alertDialogBuilder = new AlertDialog.Builder(Demoalltestscreen.this);
			alertDialogBuilder.setView(view).setCancelable(false);
			alertDialog = alertDialogBuilder.create();
			alertDialog.show();
			break;
		case R.id.demoquestions:
			factory = LayoutInflater.from(Demoalltestscreen.this);
			view = factory.inflate(R.layout.demoalltestscreeninflate, null);
			gotit = (Button) view.findViewById(R.id.gotit);
			tutorial = (Button) view.findViewById(R.id.tutorial);
			tutorial.setVisibility(Button.GONE);
			alltestdescfirst = (TextView) view
					.findViewById(R.id.alltestdescfirst);
			alltestdescfirst
					.setText("This test contains some general questions related to your daily life.");
			alltestdescsecond = (TextView) view
					.findViewById(R.id.alltestdescsecond);
			alltestdescsecond
					.setText("You just have to answer these questions and some suggestions will be given to you in the end.");
			gotit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
					alertDialog.cancel();
				}
			});
			alertDialogBuilder = new AlertDialog.Builder(Demoalltestscreen.this);
			alertDialogBuilder.setView(view).setCancelable(false);
			alertDialog = alertDialogBuilder.create();
			alertDialog.show();
			break;
		case R.id.demomotorTest:
			factory = LayoutInflater.from(Demoalltestscreen.this);
			view = factory.inflate(R.layout.demoalltestscreeninflate, null);
			gotit = (Button) view.findViewById(R.id.gotit);
			tutorial = (Button) view.findViewById(R.id.tutorial);
			tutorial.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Demoalltestscreen.this,R.id.class);
					startActivity(intent);
				}
			});
			alltestdescfirst = (TextView) view
					.findViewById(R.id.alltestdescfirst);
			alltestdescfirst
					.setText("This test is designed to calculate the accuracy of your eyes in which a red ball moves horizontally over the screen 2 times.");
			alltestdescsecond = (TextView) view
					.findViewById(R.id.alltestdescsecond);
			alltestdescsecond
					.setText("The test starts in few seconds.In this you have to place your index finger on the ball and move the finger along with the ball.See the video tutorial for more clearance. ");
			gotit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
					alertDialog.cancel();
				}
			});
			alertDialogBuilder = new AlertDialog.Builder(Demoalltestscreen.this);
			alertDialogBuilder.setView(view).setCancelable(false);
			alertDialog = alertDialogBuilder.create();
			alertDialog.show();
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

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(Demoalltestscreen.this,MainPage.class);
		startActivity(intent);
	}
}
