package com.example.visionmaster;

import android.R.id;
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
		}
	}
}
