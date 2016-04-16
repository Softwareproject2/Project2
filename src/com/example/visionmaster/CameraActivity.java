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

import com.example.visionmaster.R.id;

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
		
		switch (ImageClick.counter) {
		case 1:
			inflater = LayoutInflater.from(getBaseContext());
			View view = inflater.inflate(R.layout.inflatetextbuttonclick, null);
			LayoutParams layoutParamsControl = new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
			textviewboth = (TextView) view.findViewById(R.id.textTitlefirst);
			grid = (ImageView) view.findViewById(id.imageeyegrid);
			grid.setScaleType(ScaleType.FIT_XY);
			textviewboth.setBackgroundColor(Color.BLUE);
			textviewboth.getBackground().setAlpha(70);
			this.addContentView(view, layoutParamsControl);
			break;
		case 2:
			inflater = LayoutInflater.from(getBaseContext());
			View view1 = inflater.inflate(
					R.layout.inflatesecondtextbuttonclick, null);
			layoutParamsControl = new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT);
			textviewright = (TextView) view1.findViewById(R.id.textTitlesecond);
			grid = (ImageView) view1.findViewById(id.imagerighteyegrid);
			grid.setScaleType(ScaleType.FIT_XY);
			textviewright.setBackgroundColor(Color.BLUE);
			textviewright.getBackground().setAlpha(70);
			this.addContentView(view1, layoutParamsControl);
			break;
		case 3:
			inflater = LayoutInflater.from(getBaseContext());
			View view2 = inflater.inflate(R.layout.inflatethirdtextbuttonclick,
					null);
			layoutParamsControl = new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT);
			textviewleft = (TextView) view2.findViewById(R.id.textTitlethird);
			grid = (ImageView) view2.findViewById(id.imagelefteyegrid);
			grid.setScaleType(ScaleType.FIT_XY);
			textviewleft.setBackgroundColor(Color.BLUE);
			textviewleft.getBackground().setAlpha(70);
			this.addContentView(view2, layoutParamsControl);
			break;
		case 4:
			inflater = LayoutInflater.from(getBaseContext());
			View view3 = inflater.inflate(R.layout.inflatefingertextbutton,
					null);
			layoutParamsControl = new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT);
			textviewfinger = (TextView) view3
					.findViewById(R.id.textTitlefinger);
			textviewfinger.setBackgroundColor(Color.BLUE);
			textviewfinger.getBackground().setAlpha(70);
			this.addContentView(view3, layoutParamsControl);
			break;
		case 5:
			inflater = LayoutInflater.from(getBaseContext());
			View view4 = inflater.inflate(R.layout.inflatemedicinetextbutton,
					null);
			layoutParamsControl = new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT);
			textviewmedicine = (TextView) view4
					.findViewById(R.id.textTitlemedicine);
			textviewmedicine.setBackgroundColor(Color.BLUE);
			textviewmedicine.getBackground().setAlpha(70);
			this.addContentView(view4, layoutParamsControl);
			break;
		default:
			break;
		}

		iv = (ImageView) findViewById(id.imageV);

		TexttoSpeech = new TextToSpeech(CameraActivity.this,
				new TextToSpeech.OnInitListener() {

					@Override
					public void onInit(int status) {
						if (status != TextToSpeech.ERROR) {
							TexttoSpeech.setLanguage(Locale.US);
							TexttoSpeech.setSpeechRate(0.95f);
						}

					}
				});
		switch (ImageClick.counter) {
		case 1:
			textviewboth
					.setText("Please take a clear picture of your both eyes wide open.Make sure you place the eyes properly on  the grid below.");
			TexttoSpeech1 = new TextToSpeech(CameraActivity.this,
					new TextToSpeech.OnInitListener() {

						@Override
						public void onInit(int status) {
							if (status != TextToSpeech.ERROR) {
								TexttoSpeech1.setLanguage(Locale.ENGLISH);
								TexttoSpeech1.setSpeechRate(1f);
							}
							String randomspeech = titlespeech;
							TexttoSpeech1.speak(randomspeech,
									TextToSpeech.QUEUE_FLUSH, null);

						}
					});
			break;
		case 2:
			textviewright
					.setText("Please take a clear picture of your right eye wide open.Make sure you place the eye properly on the grid below.");
			TexttoSpeech2 = new TextToSpeech(CameraActivity.this,
					new TextToSpeech.OnInitListener() {

						@Override
						public void onInit(int status) {
							if (status != TextToSpeech.ERROR) {
								TexttoSpeech2.setLanguage(Locale.ENGLISH);
								TexttoSpeech2.setSpeechRate(1f);
							}
							String randomspeech = titlespeech2;
							TexttoSpeech2.speak(randomspeech,
									TextToSpeech.QUEUE_FLUSH, null);

						}
					});
			break;
		case 3:
			textviewleft
					.setText("Please take a clear picture of your left eye wide open.Make sure you place the eye properly on the grid below.");
			TexttoSpeech3 = new TextToSpeech(CameraActivity.this,
					new TextToSpeech.OnInitListener() {

						@Override
						public void onInit(int status) {
							if (status != TextToSpeech.ERROR) {
								TexttoSpeech3.setLanguage(Locale.ENGLISH);
								TexttoSpeech3.setSpeechRate(1f);
							}
							String randomspeech = titlespeech3;
							TexttoSpeech3.speak(randomspeech,
									TextToSpeech.QUEUE_FLUSH, null);

						}
					});
			break;
		case 4:
			textviewfinger
					.setText("Please take a clear picture of your index finger.");
			TexttoSpeech4 = new TextToSpeech(CameraActivity.this,
					new TextToSpeech.OnInitListener() {

						@Override
						public void onInit(int status) {
							if (status != TextToSpeech.ERROR) {
								TexttoSpeech4.setLanguage(Locale.ENGLISH);
								TexttoSpeech4.setSpeechRate(1f);
							}
							String randomspeech = titlespeech4;
							TexttoSpeech4.speak(randomspeech,
									TextToSpeech.QUEUE_FLUSH, null);

						}
					});
			break;
		case 5:
			textviewmedicine
					.setText("Please take the clear picture of the pills prescribed by your physcian.Make sure all the pills are clearly visible.");
			TexttoSpeech5 = new TextToSpeech(CameraActivity.this,
					new TextToSpeech.OnInitListener() {

						@Override
						public void onInit(int status) {
							if (status != TextToSpeech.ERROR) {
								TexttoSpeech5.setLanguage(Locale.ENGLISH);
								TexttoSpeech5.setSpeechRate(1f);
							}
							String randomspeech = titlespeech5;
							TexttoSpeech5.speak(randomspeech,
									TextToSpeech.QUEUE_FLUSH, null);

						}
					});
			break;
		default:
			break;
		}

		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CameraActivity.this,
						ShowImageOnClick.class);
				startActivity(intent);

			}
		});

		surfaceView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {

				case MotionEvent.ACTION_UP:
					Camera.Parameters parameters = camera.getParameters();
					parameters.setPictureFormat(PixelFormat.JPEG);
					parameters.setJpegQuality(100);
					camera.setParameters(parameters);
					surfaceView.setEnabled(false);
					camera.takePicture(null, null, new ImageClick(
							getApplicationContext()));

					// Toast.makeText(getApplicationContext(), "Yes It worked",
					// 0)
					// .show();

					String random = speech;

					TexttoSpeech.speak(random, TextToSpeech.QUEUE_FLUSH, null);
					switch (ImageClick.counter) {
					case 1:
						TexttoSpeech1.shutdown();
						TexttoSpeech1.stop();
						break;
					case 2:
						TexttoSpeech2.shutdown();
						TexttoSpeech2.stop();
						break;
					case 3:
						TexttoSpeech3.shutdown();
						TexttoSpeech3.stop();
						break;
					case 4:
						TexttoSpeech4.shutdown();
						TexttoSpeech4.stop();
						break;
					case 5:
						TexttoSpeech5.shutdown();
						TexttoSpeech5.stop();
						break;
					default:
						break;
					}

					progressDialog = new ProgressDialog(CameraActivity.this);
					progressDialog.setMessage("Saving...");
					progressDialog.setCancelable(false);
					progressDialog.show();

					break;

				default:
					break;
				}
				return true;
			}
		});

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
		if (ImageClick.counter == 1
				|| ImageClick.counter == 2
				|| ImageClick.counter == 3) {

			camera = openFrontFacingCameraGingerbread();

			camera.setDisplayOrientation(90);

		} else {
			camera = Camera.open();
			camera.setDisplayOrientation(90);
		}

	}

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

	@Override
	public void onBackPressed() {
		ImageClick.counter = 1;

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				CameraActivity.this);
		// set title
		alertDialogBuilder.setTitle("Warning! All pictures will be deleted.");

		// set dialog message
		alertDialogBuilder
				.setMessage("Do you want to continue ?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								for (File fi : allfile) {
									name = fi.getName();

									fi.delete();

								}

								Intent intent = new Intent(CameraActivity.this,
										AllTest.class);
								startActivity(intent);

							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();

	}
}
