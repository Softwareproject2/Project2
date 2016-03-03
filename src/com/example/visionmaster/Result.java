package com.example.visionmaster;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.visionmaster.R.id;

public class Result extends Activity {
	public static TextView text1, text2, text3;
	Button finish, nexttest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		text3 = (TextView) findViewById(R.id.text3);
		finish = (Button) findViewById(id.finish);
		nexttest = (Button) findViewById(id.nexttest);
		Question1.sp = getSharedPreferences("datasaved", 0);
		text1.setText(Question1.sp.getString("textvalue", "null"));
		text2.setText(Question1.sp.getString("textvalue1", "null"));
		text3.setText(Question1.sp.getString("textvalue2", "null"));

		if (text1.getText().toString().equals("null")) {
			text1.setVisibility(View.GONE);
		}
		if (text2.getText().toString().equals("null")) {
			text2.setVisibility(View.GONE);
		}
		if (text3.getText().toString().equals("null")) {
			text3.setVisibility(View.GONE);
		}
		finish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		nexttest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Result.this);
		// set title
		alertDialogBuilder
				.setTitle("Warning! All the saved data will be deleted.");

		// set dialog message
		alertDialogBuilder
				.setMessage("Do you want to continue ?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								// Intent intent = new Intent(Result.this,
								// 		AllTest.class);
								// startActivity(intent);
								finish();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
