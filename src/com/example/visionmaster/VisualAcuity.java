package com.example.visionmaster;

import java.util.Locale;

import com.example.visionmaster.R.id;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class VisualAcuity extends Activity {
	TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, seeText;
	Button stop, next;
	boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualacuity);
		tv1 = (TextView) findViewById(R.id.tv1);
		tv1.setTextColor(Color.BLACK);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv2.setTextColor(Color.BLACK);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv3.setTextColor(Color.BLACK);
		tv4 = (TextView) findViewById(R.id.tv4);
		tv4.setTextColor(Color.BLACK);
		tv5 = (TextView) findViewById(R.id.tv5);
		tv5.setTextColor(Color.BLACK);
		tv6 = (TextView) findViewById(R.id.tv6);
		tv6.setTextColor(Color.BLACK);
		tv7 = (TextView) findViewById(R.id.tv7);
		tv7.setTextColor(Color.BLACK);
		tv8 = (TextView) findViewById(R.id.tv8);
		tv8.setTextColor(Color.BLACK);
		tv9 = (TextView) findViewById(R.id.tv9);
		tv9.setTextColor(Color.BLACK);
		seeText = (TextView) findViewById(R.id.seeText);
		seeText.setTextColor(Color.BLACK);
		next = (Button) findViewById(R.id.btnnext);
		stop = (Button) findViewById(R.id.btnstop);
		final String speech = "Kindly place the device, 30 cm away from your eyes and press Ok";
		final String stop_speech = "You are unable to clear this test.";
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				VisualAcuity.this);
		// set title

		// set dialog message
		alertDialogBuilder
				.setMessage(
						"Kindly place the device, 30 cm apart from your eyes.")
				.setCancelable(false)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();

		seeText.setText("If you can read all the numbers, click Next.If you cannot read all the numbers, click Stop.");

		tv3.setText("M");
		tv3.setTextSize(31);

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (next.getText().toString().equals("Next")) {
					if (tv3.getText().toString().equals("M")) {

						tv3.setText("Z");
						tv3.setTextSize(28);
						tv4.setText("A");

						tv4.setTextSize(28);

					} else if (tv3.getText().toString().equals("Z")) {

						tv3.setText("K");
						tv3.setTextSize(25);
						tv4.setText("H");
						tv4.setTextSize(25);
						tv5.setText("L");
						tv5.setTextSize(25);

					} else if (tv3.getText().toString().equals("K")) {
						tv3.setText("R");
						tv3.setTextSize(22);
						tv4.setText("E");
						tv4.setTextSize(22);
						tv5.setText("T");
						tv5.setTextSize(22);
						tv2.setText("G");
						tv2.setTextSize(22);

					} else if (tv3.getText().toString().equals("R")) {
						tv3.setText("A");
						tv3.setTextSize(19);
						tv4.setText("W");
						tv4.setTextSize(19);
						tv5.setText("U");
						tv5.setTextSize(19);
						tv2.setText("Q");
						tv2.setTextSize(19);
						tv6.setText("F");
						tv6.setTextSize(19);

					} else if (tv3.getText().toString().equals("A")) {
						tv3.setText("P");
						tv3.setTextSize(16);
						tv4.setText("D");
						tv4.setTextSize(16);
						tv5.setText("W");
						tv5.setTextSize(16);
						tv2.setText("N");
						tv2.setTextSize(16);
						tv6.setText("O");
						tv6.setTextSize(16);
						tv9.setText("S");
						tv9.setTextSize(16);

					} else if (tv3.getText().toString().equals("P")) {
						tv3.setText("U");
						tv3.setTextSize(13);
						tv4.setText("S");
						tv4.setTextSize(13);
						tv5.setText("A");
						tv5.setTextSize(13);
						tv2.setText("L");
						tv2.setTextSize(13);
						tv6.setText("C");
						tv6.setTextSize(13);
						tv9.setText("X");
						tv9.setTextSize(13);
						tv7.setText("N");
						tv7.setTextSize(13);

					} else if (tv3.getText().toString().equals("U")) {

						tv3.setText("B");
						tv3.setTextSize(10);
						tv4.setText("D");
						tv4.setTextSize(10);
						tv5.setText("J");
						tv5.setTextSize(10);
						tv2.setText("A");
						tv2.setTextSize(10);
						tv6.setText("K");
						tv6.setTextSize(10);
						tv9.setText("W");
						tv9.setTextSize(10);
						tv7.setText("M");
						tv7.setTextSize(10);
						tv1.setText("I");
						tv1.setTextSize(10);

					} else if (tv3.getText().toString().equals("B")) {

						tv3.setText("D");
						tv3.setTextSize(8);
						tv4.setText("R");
						tv4.setTextSize(8);
						tv5.setText("J");
						tv5.setTextSize(8);
						tv2.setText("A");
						tv2.setTextSize(8);
						tv6.setText("K");
						tv6.setTextSize(8);
						tv9.setText("W");
						tv9.setTextSize(8);
						tv7.setText("M");
						tv7.setTextSize(8);
						tv1.setText("I");
						tv1.setTextSize(8);
						tv8.setText("Z");
						tv8.setTextSize(8);
						seeText.setText("If you can read all the numbers, click Finish.If you cannot read all the numbers, click Stop.");
						next.setText("Finish");

					} else if (tv3.getText().toString().equals("D")) {

					}
				} else if (next.getText().toString().equals("Finish")) {
					LayoutInflater factory = LayoutInflater
							.from(VisualAcuity.this);
					final View view = factory.inflate(
							R.layout.visiondialoginflate, null);
					final Button home = (Button) view.findViewById(R.id.home);
					final TextView textViewdetail = (TextView) view
							.findViewById(id.textViewdetail);
					textViewdetail.setText("Kindly proceed to next test.");
					final Button nexttest = (Button) view
							.findViewById(R.id.totest);
					home.setVisibility(Button.GONE);
					nexttest.setText("Next Test");
//					nexttest.setOnClickListener(new OnClickListener() {

//						@Override
//						public void onClick(View v) {
//							// TODO Auto-generated method stub
//							Intent intent = new Intent(VisualAcuity.this,
//									MotorTest.class);
//							startActivity(intent);
//						}
//					});
					final TextView alerttitle = new TextView(VisualAcuity.this);
					// You Can Customise your Title here
					alerttitle.setText("Congrats! You have cleared this Test.");
					alerttitle.setGravity(Gravity.CENTER);
					alerttitle.setTextColor(Color.WHITE);
					alerttitle.setTextSize(20);
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							VisualAcuity.this);
					// set title

					// set dialog message

					alertDialogBuilder.setView(view).setCancelable(false)
							.setCustomTitle(alerttitle);

					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();

					// show it
					alertDialog.show();

				}

			}

		});
		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater factory = LayoutInflater.from(VisualAcuity.this);
				final View view = factory.inflate(R.layout.visiondialoginflate,
						null);
				final Button home = (Button) view.findViewById(R.id.home);
				final Button gonext = (Button) view.findViewById(R.id.totest);
//				gonext.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View v) {
//						// TODO Auto-generated method stub
//						Intent intent = new Intent(VisualAcuity.this,
//								MotorTest.class);
//						startActivity(intent);
//					}
//				});

				final TextView alerttitle = new TextView(VisualAcuity.this);

				// You Can Customize your Title here
				alerttitle.setText("You are unable to clear this Test!");
				alerttitle.setGravity(Gravity.CENTER);
				alerttitle.setTextColor(Color.WHITE);
				alerttitle.setTextSize(20);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						VisualAcuity.this);
				// set title

				// set dialog message

				alertDialogBuilder.setView(view).setCancelable(false)
						.setCustomTitle(alerttitle);

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
				home.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						flag = true;
						onBackPressed();
					}
				});

			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (flag) {
			super.onBackPressed();

			Intent intent = new Intent(VisualAcuity.this, AllTest.class);
			startActivity(intent);
			finish();

		} else {

		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
