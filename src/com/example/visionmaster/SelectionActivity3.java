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
