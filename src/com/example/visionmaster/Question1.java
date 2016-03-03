package com.example.visionmaster;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Question1 extends Activity {
	public static Button yes, no;
	public static SharedPreferences sp;
	TextView selectanswer;
	public static SharedPreferences.Editor spedit;
    
	final String ques1="Question1, Do you smoke, or, are you in regular close proximity of someone who doess?";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question1);
		yes = (Button) findViewById(R.id.buttonyes);
		no = (Button) findViewById(R.id.button_no);

		sp = getSharedPreferences("datasaved", MODE_WORLD_WRITEABLE);
		spedit = sp.edit();
		
		yes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                
				spedit.putString(
						"textvalue",
						"Failed Question 1: Ultraviolet light can damage your eyes. You should wear sunglasses with UVA protection.");
				Intent miIntent = new Intent(Question1.this, Question2.class);
				startActivity(miIntent);
				spedit.commit();
			}
		});

		no.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                
				spedit.putString("textvalue", "null");
				spedit.commit();
				Intent mIntent = new Intent(Question1.this, Question2.class);
				startActivity(mIntent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
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
    
	// Intent intent = new Intent(Question1.this,AllTest.class);
	// startActivity(intent);
	finish();
}
}
