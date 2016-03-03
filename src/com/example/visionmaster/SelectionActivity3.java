package com.example.visionmaster;

import com.example.visionmaster.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectionActivity3 extends Activity {
	Button button1, button2, button3, button4, notsure;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectionactivity3);
		button1 = (Button) findViewById(id.button1);
		button2 = (Button) findViewById(id.button2);
		button3 = (Button) findViewById(id.button3);
		button4 = (Button) findViewById(id.button4);
		notsure = (Button) findViewById(R.id.notsure);
		SelectionActivity.sp = getSharedPreferences("saveyourdata",
				MODE_WORLD_WRITEABLE);
		SelectionActivity.spedit = SelectionActivity.sp.edit();

		if (R.id.image4 == FourthPage.image4.getId())

		{

			button1.setText("25");
			button1.setTextSize(70);
			button2.setText("76");
			button2.setTextSize(70);
			button3.setText("86");
			button3.setTextSize(70);
			button4.setText("2");
			button4.setTextSize(70);
			button1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (button1.getText().equals("25")) {
						SelectionActivity.spedit
								.putString("textvalue3", "null");
						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue3",
										"Failed in Question 4- Normal and those with colour defecients should see a number 25.");
						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
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
					if (button2.getText().equals("25")) {
						SelectionActivity.spedit
								.putString("textvalue3", "null");

						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue3",
										"Failed in Question 4- Normal and those with colour defecients should see a  number 25.");
						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
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
					if (button3.getText().equals("25")) {
						SelectionActivity.spedit
								.putString("textvalue3", "null");
						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue3",
										"Failed in Question 4- Normal and those with colour defecients should see a number 25.");
						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
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
					if (button4.getText().equals("25")) {
						SelectionActivity.spedit
								.putString("textvalue3", "null");
						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
						startActivity(mIntent);
						SelectionActivity.spedit.commit();
						Toast.makeText(getApplicationContext(),
								"you are correct", 0).show();
					} else {

						SelectionActivity.spedit
								.putString(
										"textvalue3",
										"Failed in Question 4- Normal and those with colour defecients should see a number 25.");
						Intent mIntent = new Intent(SelectionActivity3.this,
								Pagelast.class);
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
									"textvalue3",
									"Failed in Question 4- Normal and those with colour defecients should see a number 25.");
					Intent mIntent = new Intent(SelectionActivity3.this,
							Pagelast.class);
					startActivity(mIntent);
					SelectionActivity.spedit.commit();
					Toast.makeText(getApplicationContext(),
							"you are incorrect", 0).show();

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
		Intent intent = new Intent(SelectionActivity3.this, AllTest.class);
		startActivity(intent);
		finish();
	}
}
