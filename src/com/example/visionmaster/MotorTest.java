package com.example.visionmaster;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;


public class MotorTest extends Activity implements OnTouchListener {
	
	
	TextToSpeech TexttoSpeech, five, four, three, two, one, zero;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.motortest);
		TexttoSpeech = new TextToSpeech(MotorTest.this,
				new TextToSpeech.OnInitListener() {

					@Override
					public void onInit(int status) {
						if (status != TextToSpeech.ERROR) {
							TexttoSpeech.setLanguage(Locale.US);
							TexttoSpeech.setSpeechRate(0.95f);
						}
						String titlespeech = "Please move your finger along with the red ball....Your test will start in few seconds";
						String randomspeech = titlespeech;
						TexttoSpeech.speak(randomspeech,
								TextToSpeech.QUEUE_FLUSH, null);
					}
				});

}
