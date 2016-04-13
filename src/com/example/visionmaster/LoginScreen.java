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

import com.example.visionmaster.R.id;

public class LoginScreen extends Activity {
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
		setContentView(R.layout.loginscreen);

		// set the custom Text
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/DroidSerif-BoldItalic.ttf");
		shared = getSharedPreferences("EyeTest", MODE_WORLD_WRITEABLE);
		final SharedPreferences.Editor spedit = shared.edit();
		texttitle = (TextView) findViewById(id.textTitle);
		texttitle.setTypeface(tf);
		saveandsubmit = (Button) findViewById(id.saveandsubmit);
		settings = (Button) findViewById(id.settings);
		physicianid = (EditText) findViewById(id.physicianid);
		patientId = (EditText) findViewById(id.patientId);
		settings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				inflater = LayoutInflater.from(getBaseContext());
				View view = inflater.inflate(R.layout.settinginflate, null);
				final Dialog dialog = new Dialog(LoginScreen.this);
				dialog.setContentView(view);
				final EditText newpassfield=(EditText)view. findViewById(id.newpassfield);
				final Button savepass = (Button)view. findViewById(id.savenewpassword);
				savepass.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						spedit.putString("PATIENT_ID", newpassfield.getText()
								.toString().trim());
						spedit.commit();
						patientId.setText(shared.getString("PATIENT_ID", ""));
						dialog.dismiss();
					}
				});
				dialog.show();
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
						Dialog dialog = new Dialog(LoginScreen.this);
						dialog.setTitle("Please enter correct id's");
						dialog.show();
					} else {
						spedit.putString("PATIENT_ID", patientId.getText()
								.toString().trim());
						spedit.putString("PHYSICIAN_ID", physicianid.getText()
								.toString().trim());
						spedit.commit();

						///////here add gps coding
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
