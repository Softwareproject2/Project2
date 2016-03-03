package com.example.project;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectionActivity extends Activity {
	Button button1, button2, button3, button4, notsure;
	public static SharedPreferences sp;
	public static SharedPreferences.Editor spedit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectionactivity);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		notsure = (Button) findViewById(R.id.notsure);
		sp = getSharedPreferences("saveyourdata", MODE_WORLD_WRITEABLE);
		spedit = sp.edit();

		if (R.id.image1 == FirstPage.image1.getId())

		{

			button1.setText("16");
			button1.setTextSize(70);
			button2.setText("15");
			button2.setTextSize(70);
			button3.setText("75");
			button3.setTextSize(70);
			button4.setText("76");
			button4.setTextSize(70);
			button1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (button1.getText().equals("15")) {
						spedit.putString("textvalue", "null");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {
						spedit.putString(
								"textvalue",
								"Failed in Question 1- Normal and those with colour deficients should see the number 15.");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});
			button2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (button2.getText().equals("15")) {

						spedit.putString("textvalue", "null");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						spedit.putString(
								"textvalue",
								"Failed in Question 1- Normal and those with colour deficients should see the number 15.");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});

			button3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (button3.getText().equals("15")) {
						spedit.putString("textvalue", "null");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						spedit.putString(
								"textvalue",
								"Failed in Question 1- Normal and those with colour deficients should see the number 15.");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});
			button4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (button4.getText().equals("15")) {
						spedit.putString("textvalue", "null");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);

						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						spedit.putString(
								"textvalue",
								"Failed in Question 1- Normal and those with colour deficients should see the number 15.");

						Intent mIntent = new Intent(SelectionActivity.this,
								SecondPage.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are incorrect", 0).show();

					}

				}
			});
			notsure.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub

					spedit.putString(
							"textvalue",
							"Failed in Question 1- Normal and those with colour deficients should see the number 15.");

					Intent mIntent = new Intent(SelectionActivity.this,
							SecondPage.class);
					startActivity(mIntent);
					spedit.commit();
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
		Intent intent = new Intent(SelectionActivity.this,AllTest.class);
		startActivity(intent);
		finish();
	}
}
