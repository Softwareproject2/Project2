package com.example.visionmaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visionmaster.R.id;

public class MainPage extends Activity {
	
	TextView welcomeText;
	Button startTest, demoTour;
	Button sendemail;
	String zipFile;
	String zipfilename = "ClickedPictures.zip";

	File f;
	String email = LoginScreen.EMAIL;
	Paint paint;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainpage);
		zipFile = Environment.getExternalStorageDirectory().getPath()
				+ "/Pictures/CameraAPIDemo/" + zipfilename; // setting the path
															// of the zipfile
															// that is to be
															// created
		File f = new File(Environment.getExternalStorageDirectory().getPath()
				+ "/Pictures/CameraAPIDemo/");
		final File allfile[] = f.listFiles();

		sendemail = (Button) findViewById(R.id.sendemail);

		sendemail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				if(allfile.length<5)
				{
					Toast.makeText(getApplicationContext(), "Kindly Please take the pictures of your eyes.", 0).show();
				}
			else
			{
				try {

					// create byte buffer

					byte[] buffer = new byte[1024];

					FileOutputStream fos = new FileOutputStream(zipFile);

					ZipOutputStream zos = new ZipOutputStream(fos);
					for (int i = 0; i < allfile.length; i++) {

						File srcFile = new File(allfile[i].toString());

						FileInputStream fis = new FileInputStream(srcFile);
						// begin writing a new ZIP entry, positions the stream
						// to the start of the entry data

						zos.putNextEntry(new ZipEntry(srcFile.getName()));

						int length;

						while ((length = fis.read(buffer)) > 0) {

							zos.write(buffer, 0, length);

						}

						zos.closeEntry();

						// close the InputStream

						fis.close();

					}

					// close the ZipOutputStream

					zos.close();

				}

				catch (IOException ioe) {

					Toast.makeText(getApplicationContext(),
							"Error creating zip file", 0).show();

				}

				File filezip = new File(Environment
						.getExternalStorageDirectory().getPath()
						+ "/Pictures/CameraAPIDemo/" + zipfilename);
				String emailaddress[] = { email };
				// send picture through mail
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.setType("text/html");
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "File attached");
				emailIntent.putExtra(Intent.EXTRA_EMAIL, emailaddress);
				Uri uri = Uri.fromFile(filezip); // zipped file is attached to
													// the email
				emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
				startActivity(Intent.createChooser(emailIntent, "Send mail..."));
				// upto this
			}
		}
		});

		startTest = (Button) findViewById(id.startTest);
		startTest.setShadowLayer(9, 0, 0, (Color.WHITE));
		demoTour = (Button) findViewById(id.demoTour);
		demoTour.setShadowLayer(9, 0, 0, (Color.WHITE));
		welcomeText = (TextView) findViewById(id.welcomeText);
		welcomeText.setText("Welcome "
				+ LoginScreen.shared.getString("PATIENT_ID", null));
		
		// this event handler is applied on start test button to start the test 
		startTest.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:

					startTest.setTypeface(null, Typeface.BOLD);
					startTest.setTextSize((float) 17.3);
					break;
				case MotionEvent.ACTION_UP:
					startTest.setTypeface(null, Typeface.NORMAL);
					startTest.setTextSize(17);

					Intent intent = new Intent(MainPage.this, AllTest.class);
					startActivity(intent);

					break;
				default:
					break;
				}

				return true;
			}
		});
		
		demoTour.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					demoTour.setTypeface(null, Typeface.BOLD);
					demoTour.setTextSize((float) 17.3);
					break;
				case MotionEvent.ACTION_UP:
					demoTour.setTypeface(null, Typeface.NORMAL);
					demoTour.setTextSize(17);
					Intent intent = new Intent(MainPage.this,
							Demoalltestscreen.class);
					startActivity(intent);
					break;
				default:
					break;
				}

				return true;
			}
		});

	}
	@Override // this method is to provide the functionality on the back button of device
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(MainPage.this, LoginScreen.class);
		startActivity(intent);
	}
		
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

	
}
