package com.example.visionmaster;

import com.example.visionmaster.R.id;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Pagelast extends Activity {
	public static TextView text1, text2, text3, text4, failedtest;
	Button finish, nexttest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pagelast);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		text3 = (TextView) findViewById(R.id.text3);
		text4 = (TextView) findViewById(R.id.text4);
		finish = (Button) findViewById(id.finish);
		nexttest = (Button) findViewById(id.nexttest);
		failedtest = (TextView) findViewById(R.id.failedtest);
		SelectionActivity.sp = getSharedPreferences("saveyourdata", 0);
		text1.setText(SelectionActivity.sp.getString("textvalue", " "));
		text2.setText(SelectionActivity.sp.getString("textvalue1", " "));
		text3.setText(SelectionActivity.sp.getString("textvalue2", " "));
		text4.setText(SelectionActivity.sp.getString("textvalue3", " "));
		failedtest.setText("Your eyes have failed in some color tests.");

		if (text1.getText().toString().equals("null")) {
			text1.setVisibility(View.GONE);
		}
		if (text2.getText().toString().equals("null")) {
			text2.setVisibility(View.GONE);
		}

		if (text3.getText().toString().equals("null")) {
			text3.setVisibility(View.GONE);
		}

		if (text4.getText().toString().equals("null")) {
			text4.setVisibility(View.GONE);
		}
		if (text1.getText().toString().equals("null")
				&& text2.getText().toString().equals("null")) {
			text1.setVisibility(View.GONE);
			text2.setVisibility(View.GONE);
		}
		if (text1.getText().toString().equals("null")
				&& text3.getText().toString().equals("null")) {
			text1.setVisibility(View.GONE);
			text3.setVisibility(View.GONE);
		}
		if (text1.getText().toString().equals("null")
				&& text4.getText().toString().equals("null")) {
			text1.setVisibility(View.GONE);
			text4.setVisibility(View.GONE);
		}
		if (text2.getText().toString().equals("null")
				&& text3.getText().toString().equals("null")) {
			text2.setVisibility(View.GONE);
			text3.setVisibility(View.GONE);
		}
		if (text2.getText().toString().equals("null")
				&& text4.getText().toString().equals("null")) {
			text2.setVisibility(View.GONE);
			text4.setVisibility(View.GONE);
		}
		if (text3.getText().toString().equals("null")
				&& text4.getText().toString().equals("null")) {
			text3.setVisibility(View.GONE);
			text4.setVisibility(View.GONE);
		}
		if (text1.getText().toString().equals("null")
				&& text2.getText().toString().equals("null")
				&& text3.getText().toString().equals("null")) {
			text1.setVisibility(View.GONE);
			text2.setVisibility(View.GONE);
			text3.setVisibility(View.GONE);
		}

		if (text2.getText().toString().equals("null")
				&& text3.getText().toString().equals("null")
				&& text4.getText().toString().equals("null")) {
			text2.setVisibility(View.GONE);
			text3.setVisibility(View.GONE);
			text4.setVisibility(View.GONE);
		}
		if (text4.getText().toString().equals("null")
				&& text2.getText().toString().equals("null")
				&& text1.getText().toString().equals("null")) {
			text4.setVisibility(View.GONE);
			text2.setVisibility(View.GONE);
			text1.setVisibility(View.GONE);
		}
		if (text4.getText().toString().equals("null")
				&& text3.getText().toString().equals("null")
				&& text1.getText().toString().equals("null")) {
			text4.setVisibility(View.GONE);
			text3.setVisibility(View.GONE);
			text1.setVisibility(View.GONE);
		}
		if (text1.getText().toString().equals("null")
				&& text2.getText().toString().equals("null")
				&& text3.getText().toString().equals("null")
				&& text4.getText().toString().equals("null")) {
			text1.setVisibility(View.GONE);
			text2.setVisibility(View.GONE);
			text3.setVisibility(View.GONE);
			text4.setVisibility(View.GONE);
			failedtest.setVisibility(View.GONE);
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
				Intent intent = new Intent(Pagelast.this, Question1.class);
				startActivity(intent);
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
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Pagelast.this);
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
								Intent intent = new Intent(Pagelast.this,
										AllTest.class);
								startActivity(intent);
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

}
