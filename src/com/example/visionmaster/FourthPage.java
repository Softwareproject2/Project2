package com.example.visionmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FourthPage extends Activity{
	public static ImageView image4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourthpage);
		image4=(ImageView)findViewById(R.id.image4);
		image4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent mIntent=new Intent(FourthPage.this,SelectionActivity3.class);
				startActivity(mIntent);
			
				
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
		Intent intent = new Intent(FourthPage.this,AllTest.class);
		startActivity(intent);
		finish();
	}
}
