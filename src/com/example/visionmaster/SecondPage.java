package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SecondPage extends Activity {
	public static ImageView image2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondpage);
		image2 = (ImageView) findViewById(R.id.image2);
		image2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondPage.this,
						SelectionActivity1.class);
				startActivity(intent);
			}
		});
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
		Intent intent = new Intent(SecondPage.this, AllTest.class);
		startActivity(intent);
		finish();
	}
}
