package com.example.visionmaster;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;




@SuppressLint("NewApi")
public class CameraActivity extends Activity implements SurfaceHolder.Callback,
		Camera.PictureCallback {


	Camera camera;

	public static SurfaceView surfaceView;
	String speech = "Picture Taken.....Please view the clicked picture to ensure that it waas taken correctly.";
	String titlespeech = "....Please take a clear picture of your both eyes wide open.Make sure you place the eyes properly on  the grid below.";
	String titlespeech2 = ".....Please take a clear picture of your right eye wide open.Make sure you place the eye properly on the grid below.";
	String titlespeech3 = ".....Please take a clear picture of your left eye wide open.Make sure you place the eye properly on the grid below.";
	String titlespeech4 = ".....Please take a clear picture of your index finger.";
	String titlespeech5 = ".....Please take the clear picture of the pills prescribed by your physcian.Make sure all the pills are clearly visible.";
	public String filename = "MyFile";
	File dir = new File(Environment.getExternalStorageDirectory().getPath()
			+ "/Pictures/CameraAPIDemo/");
	final File allfile[] = dir.listFiles();
	SurfaceHolder surfaceHolder;
	boolean previewing = false;
	String name;
	public static ProgressDialog progressDialog;

	TextView textviewboth, textviewright, textviewleft, textviewfinger,
			textviewmedicine;
	ImageView grid;
	public static ImageView iv;
	LayoutInflater inflater = null;
	TextToSpeech TexttoSpeech, TexttoSpeech1, TexttoSpeech2, TexttoSpeech3,
			TexttoSpeech4, TexttoSpeech5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maincamerafile);
		getWindow().setFormat(PixelFormat.UNKNOWN);

		surfaceView = (SurfaceView) findViewById(R.id.sv);
		
	
		
		
		
		
		
	
		
	
	
	


					

		

		surfaceHolder = surfaceView.getHolder();
		surfaceHolder.addCallback(this);
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
	

		super.onStart();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		if (TexttoSpeech != null) {
			TexttoSpeech.stop();
			TexttoSpeech.shutdown();
		}
		if (TexttoSpeech1 != null) {
			TexttoSpeech1.stop();
			TexttoSpeech.shutdown();
		}
		if (TexttoSpeech2 != null) {
			TexttoSpeech2.stop();
			TexttoSpeech2.shutdown();
		}
		if (TexttoSpeech3 != null) {
			TexttoSpeech3.stop();
			TexttoSpeech3.shutdown();
		}
		if (TexttoSpeech4 != null) {
			TexttoSpeech4.stop();
			TexttoSpeech4.shutdown();
		}
		if (TexttoSpeech5 != null) {
			TexttoSpeech5.stop();
			TexttoSpeech5.shutdown();
		}

		super.onPause();
		finish();
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		if (previewing) {
			camera.stopPreview();
			previewing = false;
		}

		if (camera != null) {
			try {
				camera.setPreviewDisplay(surfaceHolder);
				camera.startPreview();
				previewing = true;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		// camera = Camera.open();
		//if (ImageCaptureCallback.counter == 1
			//	|| ImageCaptureCallback.counter == 2
				//|| ImageCaptureCallback.counter == 3) {

			camera = openFrontFacingCameraGingerbread();

			camera.setDisplayOrientation(90);

		//} //else {
			camera = Camera.open();
			camera.setDisplayOrientation(90);
		}

	//}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		camera.stopPreview();
		camera.release();
		camera = null;
		previewing = false;

	}

	private Camera openFrontFacingCameraGingerbread() {
		int cameraCount = 0;
		Camera cam = null;
		Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
		cameraCount = Camera.getNumberOfCameras();
		Log.e("No of cameras ", "-------------- " + cameraCount);
		for (int camIdx = 0; camIdx < cameraCount; camIdx++) {
			Camera.getCameraInfo(camIdx, cameraInfo);
			if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
				try {
					cam = Camera.open(camIdx);
				} catch (RuntimeException e) {
					Toast.makeText(getApplicationContext(), "No front camera",
							0).show();
					Log.e("CAMERA",
							"Camera failed to open: " + e.getLocalizedMessage());
				}
			}
		}
		return cam;
	}

	
		
	
	
}



