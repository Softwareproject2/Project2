package com.example.visionmaster;

import java.io.File;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShowImageOnClick extends Activity {
	ImageView image;
	LayoutInflater inflater;
	LinearLayout linearImage;
	public static Button retake, ok;
	boolean flag = false;
	TextView textviewboth;
	ImageView grid;
	boolean check;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.showimageonclick);

		inflater = LayoutInflater.from(getBaseContext());
		View view = inflater.inflate(R.layout.inflatebuttoons, null);
		LayoutParams layoutParamsControl = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		retake = (Button) view.findViewById(R.id.retake);
		retake.setShadowLayer(9, 0, 0, (Color.WHITE));
		ok = (Button) view.findViewById(R.id.ok);
		ok.setShadowLayer(9, 0, 0, (Color.WHITE));
		this.addContentView(view, layoutParamsControl);

		File dir = new File(Environment.getExternalStorageDirectory().getPath()
				+ "/Pictures/CameraAPIDemo/");
		final File allfile[] = dir.listFiles();
		image = (ImageView) findViewById(R.id.image);

		image.setScaleType(ScaleType.FIT_XY);
		image.setImageBitmap(ImageClick.rImg);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (check == false) {
					retake.setVisibility(View.INVISIBLE);
					ok.setVisibility(View.INVISIBLE);
					check = true;

				} else if (check == true) {
					retake.setVisibility(View.VISIBLE);
					ok.setVisibility(View.VISIBLE);

					check = false;
				} else {
					// nothing
				}
			}
		});
		ImageClick.rImg = null;
		retake.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:

					retake.setTypeface(null, Typeface.BOLD);
					retake.setTextSize((float) 17.3);
					flag = true;
					ImageClick.counter--;

					break;
				case MotionEvent.ACTION_UP:
					retake.setTypeface(null, Typeface.NORMAL);
					retake.setTextSize(17);
					CameraActivity.surfaceView.setEnabled(true);
					CameraActivity.iv.setImageBitmap(null);
					for (File fi : allfile) {
						String name = fi.getName();
						if (name.equals("Picture"
								+ ImageClick.counter + ".png")) {
							fi.delete();
						}
					}
					Intent intent = new Intent(ShowImageOnClick.this,
							CameraActivity.class);
					startActivity(intent);
					// f.delete();

					flag = false;

					break;
				default:
					break;
				}

				return true;
			}
		});

		ok.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:

					ok.setTypeface(null, Typeface.BOLD);
					ok.setTextSize((float) 17.3);
					break;
				case MotionEvent.ACTION_UP:

					ok.setTypeface(null, Typeface.NORMAL);
					ok.setTextSize(17);
					if (ImageClick.counter < 6) {
						Intent intent = new Intent(ShowImageOnClick.this,
								CameraActivity.class);
						startActivity(intent);
					} else {
						Intent intent = new Intent(ShowImageOnClick.this,
								AllTest.class);
						startActivity(intent);
					}
					break;
				default:
					break;
				}

				return true;
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

	}

}
