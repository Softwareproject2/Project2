package com.example.visionmaster;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Question3 extends Activity {
	public static Button yes, no;
	public static SharedPreferences sp;
    
	final String ques3 = "Question3, has it been over two years since your last eye test?";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question3);
		yes = (Button) findViewById(R.id.buttonyes3);
		no = (Button) findViewById(R.id.button_no3);
		sp = getSharedPreferences("datasaved", 0);
		
        
		final SharedPreferences.Editor spedit = sp.edit();

		yes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                
				Intent mIntent = new Intent(Question3.this, Result.class);
				startActivity(mIntent);
				final SharedPreferences.Editor spedit = sp.edit();
				spedit.putString("textvalue2",
						"Failed Question 3: It's recommended you get an eye test at least once a year.");
				spedit.commit();

			}
		});
		no.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                
				spedit.putString("textvalue2", "null");
				spedit.commit();
				Intent mIntent = new Intent(Question3.this, Result.class);
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
		// Intent intent = new Intent(Question3.this,AllTest.class);
		// startActivity(intent);
		finish();
	}
}
