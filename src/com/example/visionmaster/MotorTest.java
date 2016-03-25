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
	
	private SharedPreferences preferences;

	private LinearLayout layout, linearButton;
	private TextView countDownView;
	private ImageView imageView;
	private Button cameracapture;
	String zipFile;
	String zipfilename = "ClickedPictures.zip";
	File f;
	Canvas canvas;
	String email = "kvv230892@gmail.com";
	Paint paint;
	private TextView txtStep1Efficiency;
	private TextView txtStep2Efficiency;
	private TextView txtStep3Efficiency;
	private TextView txtStep4Efficiency;
	private TextView txtAverageEfficiency;
	boolean back = false;
	private Timer timer, countDownTimer;

	private int width;
	private final long timeInterval = 40;
	private final long animationDuration = 7500;
	private double mariginalIncrement = 0;
	private int leftMargin = 0;
	private int checkTime = 40;

	private int firstStageEfficiency;
	private int secondStageEfficiency;
	private int thirdStageEfficiency;
	private int fourthStageEfficiency;
	private int averageEfficiency;
	TextToSpeech TexttoSpeech, five, four, three, two, one, zero;
	private long totalTime, touchTime;

	private Rect outRect;
	private SimpleDateFormat format = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");

	
	
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
		
		preferences = getSharedPreferences("ProjectDatabase", MODE_PRIVATE);

		layout = (LinearLayout) findViewById(R.id.linear);
		imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(R.drawable.ball);
		zipFile = Environment.getExternalStorageDirectory().getPath()
				+ "/Pictures/CameraAPIDemo/" + zipfilename; // setting the path
															// of the zipfile
															// that is to be
															// created
		
		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		layoutParams.leftMargin = leftMargin;
		layoutParams.topMargin = 10;
		// layout.addView(imageView, layoutParams);

		linearButton = (LinearLayout) findViewById(R.id.linearButton);

		countDownView = (TextView) findViewById(R.id.txt_count_down);
		getTextViews();

		cameracapture = (Button) findViewById(R.id.cameracapture);

		cameracapture.setVisibility(View.GONE);

		cameracapture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MotorTest.this, CameraActivity.class);
				startActivity(intent);
			}

		});
		linearButton.setVisibility(View.GONE);
		DisplayMetrics ourMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(ourMetrics);
		width = ourMetrics.widthPixels;

		Drawable drawable = getResources().getDrawable(R.drawable.ball);

		width = width - drawable.getIntrinsicWidth();

		float i = width * timeInterval;

		Log.e("width * timeInterval", "" + i);

		mariginalIncrement = i / animationDuration;

		Log.e("animationDuration", "" + mariginalIncrement);

		mariginalIncrement = Math.ceil(mariginalIncrement);

		Log.e("mariginalIncrement 111", "" + mariginalIncrement);

		countDownTimer = new Timer();
		countDownTimer.scheduleAtFixedRate(countDownTask, 0, 1000);

	}
	
	private void getTextViews() {
		txtStep1Efficiency = (TextView) findViewById(R.id.txt_step_1_efficiency);
		txtStep1Efficiency.setText(getEfficiencyText(1, "-"));

		txtStep2Efficiency = (TextView) findViewById(R.id.txt_step_2_efficiency);
		txtStep2Efficiency.setText(getEfficiencyText(2, "-"));

		txtStep3Efficiency = (TextView) findViewById(R.id.txt_step_3_efficiency);
		txtStep3Efficiency.setText(getEfficiencyText(3, "-"));

		txtStep4Efficiency = (TextView) findViewById(R.id.txt_step_4_efficiency);
		txtStep4Efficiency.setText(getEfficiencyText(4, "-"));

		txtAverageEfficiency = (TextView) findViewById(R.id.txt_average_efficiency);
		txtAverageEfficiency.setText(getEfficiencyText(0, "-"));
	}

	////
	TimerTask countDownTask = new TimerTask() {
		int i = 0;

		@Override
		public void run() {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					int j = 16 - i;
					if (j == 5) {
						five = new TextToSpeech(MotorTest.this,
								new TextToSpeech.OnInitListener() {

									@Override
									public void onInit(int status) {
										if (status != TextToSpeech.ERROR) {
											five.setLanguage(Locale.US);
											five.setSpeechRate(0.95f);
										}
										String speakfive = "five";
										String randomspeech = speakfive;
										five.speak(randomspeech,
												TextToSpeech.QUEUE_FLUSH, null);
									}
								});

					}
					if (j == 4) {
						five.shutdown();
						five.stop();
						four = new TextToSpeech(MotorTest.this,
								new TextToSpeech.OnInitListener() {

									@Override
									public void onInit(int status) {
										if (status != TextToSpeech.ERROR) {
											four.setLanguage(Locale.US);
											four.setSpeechRate(0.95f);
										}
										String speakfour = "four";
										String randomspeech = speakfour;
										four.speak(randomspeech,
												TextToSpeech.QUEUE_FLUSH, null);
									}
								});
					}
					if (j == 3) {
						four.shutdown();
						four.stop();
						three = new TextToSpeech(MotorTest.this,
								new TextToSpeech.OnInitListener() {

									@Override
									public void onInit(int status) {
										if (status != TextToSpeech.ERROR) {
											three.setLanguage(Locale.US);
											three.setSpeechRate(0.95f);
										}
										String speakfour = "three";
										String randomspeech = speakfour;
										three.speak(randomspeech,
												TextToSpeech.QUEUE_FLUSH, null);
									}
								});
					}
					if (j == 2) {
						three.shutdown();
						three.stop();
						two = new TextToSpeech(MotorTest.this,
								new TextToSpeech.OnInitListener() {

									@Override
									public void onInit(int status) {
										if (status != TextToSpeech.ERROR) {
											two.setLanguage(Locale.US);
											two.setSpeechRate(0.95f);
										}
										String speakfour = "two";
										String randomspeech = speakfour;
										two.speak(randomspeech,
												TextToSpeech.QUEUE_FLUSH, null);
									}
								});
					}
					if (j == 1) {
						two.shutdown();
						two.stop();
						one = new TextToSpeech(MotorTest.this,
								new TextToSpeech.OnInitListener() {

									@Override
									public void onInit(int status) {
										if (status != TextToSpeech.ERROR) {
											one.setLanguage(Locale.US);
											one.setSpeechRate(0.95f);
										}
										String speakfour = "one";
										String randomspeech = speakfour;
										one.speak(randomspeech,
												TextToSpeech.QUEUE_FLUSH, null);
									}
								});
					}
					if (j == 0) {
						one.shutdown();
						one.stop();
						zero = new TextToSpeech(MotorTest.this,
								new TextToSpeech.OnInitListener() {

									@Override
									public void onInit(int status) {
										if (status != TextToSpeech.ERROR) {
											zero.setLanguage(Locale.US);
											zero.setSpeechRate(0.95f);
										}
										String speakfour = "zero";
										String randomspeech = speakfour;
										zero.speak(randomspeech,
												TextToSpeech.QUEUE_FLUSH, null);
									}
								});
					}

					countDownView.setText("Your test will start in : " + (j)
							+ " seconds");
				}
			});
			i++;
			if (i > 15) {
				countDownTimer.cancel();
				totalTime = System.currentTimeMillis();

				Log.e("Time", "Time :: " + totalTime + " Touch time :: "
						+ touchTime);

				layout.setOnTouchListener(MotorTest.this);

				timer = new Timer();
				timer.schedule(task, 0, timeInterval);

			}
		}

	};
	
	/**
	 * This method is used to move the image from left to right.
	 */

	private void addImageView() {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {

				layout.removeAllViews();

				leftMargin = (int) (leftMargin + mariginalIncrement);

				if (leftMargin >= width) {
					timer.cancel();

					long stepTime = System.currentTimeMillis() - totalTime;

					Log.e("Time", "Time 1 :: " + stepTime + " Touch time 1 :: "
							+ touchTime);

					firstStageEfficiency = calculatePercentage(stepTime,
							touchTime);

					txtStep1Efficiency.setText(getEfficiencyText(1,
							String.valueOf(firstStageEfficiency) + "%"));
					Log.e("KUJHFHURWKFHCWEFUDJ", "" + firstStageEfficiency);

					txtAverageEfficiency.setText(getEfficiencyText(0,
							getAverageEfficiency(firstStageEfficiency, 1)));

					totalTime = System.currentTimeMillis();
					// x = System.currentTimeMillis();
					touchTime = 0;

					Log.e("TOUCH CHANGE", "TOUCH CHNAGE :: " + touchTime);

					timer = new Timer();
					timer.schedule(lastTask, 0, timeInterval);
				}
				imageView = new ImageView(MotorTest.this);
				imageView.setImageResource(R.drawable.ball);
				LayoutParams layoutParams = new LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				layoutParams.leftMargin = leftMargin;
				layoutParams.topMargin = 70;

				layout.addView(imageView, layoutParams);

			}
		});
	}
	
	long x = 0;
	long ix = 0;

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			x = System.currentTimeMillis();
			Log.e("Elapsed Time", "Elapsed Time 111 :: " + x);
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {

			for (int i = 0; i < layout.getChildCount(); i++) {
				if (layout.getChildAt(i) instanceof ImageView) {

					outRect = new Rect(leftMargin, 50, imageView.getRight(),
							imageView.getBottom());

					if (outRect
							.contains((int) event.getX(), (int) event.getY())) {

						ix = System.currentTimeMillis() - x;
						Log.e("Elapsed Time", "Elapsed Time :: " + ix);

						touchTime += ix;
						ix = 0;
						x = System.currentTimeMillis();

						layout.setBackgroundColor(Color.GREEN);
					} else {

						layout.setBackgroundColor(Color.GRAY);
					}
				}
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			layout.setBackgroundColor(Color.GRAY);
		}
		return true;
	}
	/**
	 * This timer task is used to move the ball from left to right.
	 */

	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			addImageView();
		}
	};

	
	/**
	 * This timer task is used to move the ball from right to left.
	 */

	TimerTask reverseTask = new TimerTask() {
		@Override
		public void run() {
			addReverseImageView();
		}
	};

	/**
	 * This method is used to move the image from right to left.
	 */

	private void addReverseImageView() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				layout.removeAllViews();

				leftMargin = (int) (leftMargin - mariginalIncrement);

				if (leftMargin <= 0) {
					timer.cancel();

					long stepTime = System.currentTimeMillis() - totalTime;

					Log.e("Time", "Time 3 :: " + stepTime + " Touch time 3 :: "
							+ touchTime);

					thirdStageEfficiency = calculatePercentage(stepTime,
							touchTime);

					txtStep3Efficiency.setText(getEfficiencyText(3,
							String.valueOf(thirdStageEfficiency) + "%"));

					txtAverageEfficiency.setText(getEfficiencyText(
							0,
							getAverageEfficiency(firstStageEfficiency
									+ secondStageEfficiency
									+ thirdStageEfficiency, 3)));

					totalTime = System.currentTimeMillis();

					// x = System.currentTimeMillis();
					touchTime = 0;
					checkTime = 40;

					timer = new Timer();
					timer.schedule(lastTask2, 0, timeInterval);
				}
				
				imageView = new ImageView(MotorTest.this);
				imageView.setImageResource(R.drawable.ball);
				LayoutParams layoutParams = new LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				layoutParams.leftMargin = leftMargin;
				layoutParams.topMargin = 70;

				layout.addView(imageView, layoutParams);

			}
		});
	}

	TimerTask finishTask = new TimerTask() {
		@Override
		public void run() {
			Log.e("DONE", "DONE");
			timer.cancel();
		}
	};

	TimerTask lastTask = new TimerTask() {
		@Override
		public void run() {
			addLastImageView(true);
			checkTime += timeInterval;
		}
	};

	TimerTask lastTask2 = new TimerTask() {
		@Override
		public void run() {
			addLastImageView(false); // //////////////////////////////////////
			checkTime += timeInterval;
		}
	};
	private void addLastImageView(final boolean isContinue){
		
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				layout.removeAllViews();

				imageView = new ImageView(MotorTest.this);
				imageView.setImageResource(R.drawable.ball);
				LayoutParams layoutParams = new LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				layoutParams.leftMargin = leftMargin;
				layoutParams.topMargin = 70;
				layout.addView(imageView, layoutParams);

				if (checkTime == 3000) {
					timer.cancel();

					long stepTime = System.currentTimeMillis() - totalTime;

					Log.e("Time", "Time 24 :: " + stepTime
							+ " Touch time 24 :: " + touchTime);

					if (isContinue) {
						secondStageEfficiency = calculatePercentage(stepTime,
								touchTime);

						txtStep2Efficiency.setText(getEfficiencyText(2,
								String.valueOf(secondStageEfficiency) + "%"));

						txtAverageEfficiency.setText(getEfficiencyText(
								0,
								getAverageEfficiency(firstStageEfficiency
										+ secondStageEfficiency, 2)));

						timer = new Timer();
						timer.schedule(reverseTask, 0, timeInterval);

					} else {
						fourthStageEfficiency = calculatePercentage(stepTime,
								touchTime);

						txtStep4Efficiency.setText(getEfficiencyText(4,
								String.valueOf(fourthStageEfficiency) + "%"));

						averageEfficiency = (firstStageEfficiency
								+ secondStageEfficiency + thirdStageEfficiency + fourthStageEfficiency) / 4;

						txtAverageEfficiency.setText(getEfficiencyText(
								0,
								getAverageEfficiency(firstStageEfficiency
										+ secondStageEfficiency
										+ thirdStageEfficiency
										+ fourthStageEfficiency, 4)));

						layout.removeAllViews();

						layout.setOnTouchListener(null);
						layout.setBackgroundResource(R.drawable.bac);

						// layout.addView(lineartext);
						linearButton.setVisibility(View.VISIBLE);
						layout.addView(linearButton);

						// lineartext.addView(txtStep1Efficiency);

						cameracapture.setVisibility(View.VISIBLE);
					}

					totalTime = System.currentTimeMillis();
					// x = System.currentTimeMillis();
					touchTime = 0;
				}
			}
		});
		
	}
	
		
	private int calculatePercentage(long totaltime, long touchedTime) {

		Log.e("Views", "Total Views :: " + totaltime + " Touched Views :: "
				+ touchedTime);

		int percentage = (int) ((touchedTime * 100) / totaltime);

		if (percentage > 100) {
			return 100;
		} else {
			return percentage;
		}
	}
	
	/**
	 * This method send the email Intent for the application.
	 */

	@Override
	public void onBackPressed() {

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				MotorTest.this);
		// set title
		alertDialogBuilder
				.setTitle("Warning! All the saved data will be deleted.");

		// set dialog message
		alertDialogBuilder
				.setMessage("Do you want to continue ?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								five.shutdown();
								five.stop();
								four.shutdown();
								four.stop();
								three.shutdown();
								three.stop();
								two.shutdown();
								two.stop();
								one.shutdown();
								one.stop();
								zero.shutdown();
								zero.stop();
								TexttoSpeech.shutdown();
								TexttoSpeech.stop();
								Intent intent = new Intent(MotorTest.this,
										AllTest.class);
								startActivity(intent);
								finish();
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
	

	private String getEfficiencyText(int step, String efficiency) {
		if (step == 0) {
			return "Average Efficiency : " + efficiency;
		} else {
			return "Step " + step + " Efficiency : " + efficiency;
		}
	}
	
	
	private String getAverageEfficiency(int totalEfficiency, int noOfSteps) {
		int average = totalEfficiency / noOfSteps;
		return average + "%";
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}


}
