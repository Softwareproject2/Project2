package com.example.visionmaster;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Question2 extends Activity {
	public static Button yes, no;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question2);

		yes = (Button) findViewById(R.id.buttonyes2);
		no = (Button) findViewById(R.id.button_no2);
		Question1.sp = getSharedPreferences("datasaved", 0);
		Question1.spedit = Question1.sp.edit();
		
		yes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent mIntent = new Intent(Question2.this, Question3.class);
				startActivity(mIntent);

				Question1.spedit
						.putString(
								"textvalue1",
								"Failed Question 2: It's quite possible your local registered optician may be able to help with this.");
				Question1.spedit.commit();

			}
		});
		no.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Question1.spedit.putString("textvalue1", "null");
				Question1.spedit.commit();
				Intent mIntent = new Intent(Question2.this, Question3.class);
				startActivity(mIntent);

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
		super.onBackPressed();
		// Intent intent = new Intent(Question2.this,AllTest.class);
		// startActivity(intent);
		finish();
	}
}
