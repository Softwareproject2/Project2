package com.example.visionmaster;

import com.example.visionmaster.R.id;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectionActivity1 extends Activity {
	Button button1, button2, button3, button4, notsure;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectionactivity);
		button1 = (Button) findViewById(id.button1);
		button2 = (Button) findViewById(id.button2);
		button3 = (Button) findViewById(id.button3);
		button4 = (Button) findViewById(id.button4);
		notsure = (Button) findViewById(R.id.notsure);
		SelectionActivity.sp = getSharedPreferences("saveyourdata",
				MODE_WORLD_WRITEABLE);
		SelectionActivity.spedit = SelectionActivity.sp.edit();

		if (R.id.image2 == SecondPage.image2.getId())

		{

			button1.setText("28");
			button1.setTextSize(70);
			button2.setText("75");
			button2.setTextSize(70);
			button3.setText("26");
			button3.setTextSize(70);
			button4.setText("76");
			button4.setTextSize(70);
			button1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (button1.getText().equals("26")) {
						SelectionActivity.spedit
								.putString("textvalue1", "null");

						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue1",
										"Failed in Question 2- People with normal color vision see 26. But defected eyes will see 6 faint 2 who are red color blind and 2 faint 6 who are green color blind people. ");

						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});
			button2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (button2.getText().equals("26")) {
						SelectionActivity.spedit
								.putString("textvalue1", "null");
						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue1",
										"Failed in Question 2- People with normal color vision see 26. But defected eyes will see 6 faint 2 who are red color blind and 2 faint 6 who are green color blind people. ");

						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});

			button3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (button3.getText().equals("26")) {
						SelectionActivity.spedit
								.putString("textvalue1", "null");
						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue1",
										"Failed in Question 2- People with normal color vision see 26. But defected eyes will see 6 faint 2 who are red color blind and 2 faint 6 who are green color blind people. ");

						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});
			button4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (button4.getText().equals("26")) {
						SelectionActivity.spedit
								.putString("textvalue1", "null");
						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue1",
										"Failed in Question 2- People with normal color vision see 26. But defected eyes will see 6 faint 2 who are red color blind and 2 faint 6 who are green color blind people. ");

						Intent mIntent = new Intent(SelectionActivity1.this,
								ThirdPage.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});
			notsure.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub

					SelectionActivity.spedit
							.putString(
									"textvalue1",
									"Failed in Question 2- People with normal color vision see 26. But defected eyes will see 6 faint 2 who are red color blind and 2 faint 6 who are green color blind people. ");

					Intent mIntent = new Intent(SelectionActivity1.this,
							ThirdPage.class);
					startActivity(mIntent);
					SelectionActivity.spedit.commit();
				}
			});

		}

	}

	@Override
	protected void onPause() {
		finish();
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(SelectionActivity1.this,AllTest.class);
		startActivity(intent);
		finish();
	}
}
