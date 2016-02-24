package com.example.visionmaster;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginPage extends Activity {
	LinearLayout linearlayout;
	Button saveandsubmit, settings;
	TextView texttitle;
	LayoutInflater inflater;
	static String EMAIL = "physiciansid@gmail.com";
	public static SharedPreferences shared;
	public static EditText physicianid, patientId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage);

		// set the custom Text
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/DroidSerif-BoldItalic.ttf");
		shared = getSharedPreferences("EyeTest", MODE_WORLD_WRITEABLE);
		final SharedPreferences.Editor spedit = shared.edit();
		texttitle = (TextView) findViewById(R.id.textTitle);
		texttitle.setTypeface(tf);
		saveandsubmit = (Button) findViewById(R.id.saveandsubmit);
		
		physicianid = (EditText) findViewById(R.id.physicianid);
		patientId = (EditText) findViewById(R.id.patientId);
		settings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
			
			}
		});

		patientId.setText(shared.getString("PATIENT_ID", ""));
		physicianid.setText(shared.getString("PHYSICIAN_ID", ""));
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(patientId.getWindowToken(), 0);
		imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(physicianid.getWindowToken(), 0);
		if (patientId.getText().toString()
				.equals(shared.getString("PATIENT_ID", ""))) {
			patientId.setEnabled(false);
			physicianid.setEnabled(false);
			saveandsubmit.setText("Login");
		}
		if (patientId.getText().toString().equals("")
				&& physicianid.getText().toString().equals("")) {
			patientId.setEnabled(true);
			physicianid.setEnabled(true);
			saveandsubmit.setText("Save");
		} else {
			// do nothing
		}
		saveandsubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// saveandsubmit.setBackgroundDrawabl8q e(null);
				if (saveandsubmit.getText().toString().equals("Save")) {
					if (patientId.getText().toString().equals("")
							|| physicianid.getText().toString().equals("")
							|| !physicianid.getText().toString().equals(EMAIL)) {
						Dialog dialog = new Dialog(LoginPage.this);
						dialog.setTitle("Please enter correct id's");
						dialog.show();
					} else {
						spedit.putString("PATIENT_ID", patientId.getText()
								.toString().trim());
						spedit.putString("PHYSICIAN_ID", physicianid.getText()
								.toString().trim());
						spedit.commit();

						
					}
				} else if (saveandsubmit.getText().toString().equals("Login")) {
					Intent intent = new Intent(LoginPage.this, MainPage.class);
					startActivity(intent);
				} else {

				}
			}
		});
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
		System.exit(0);
	}

}