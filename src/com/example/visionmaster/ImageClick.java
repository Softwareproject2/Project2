package com.example.visionmaster;
import java.io.File;
import java.io.FileOutputStream;

import com.example.visionmaster.CameraActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;


public class ImageClick extends Activity implements PictureCallback {

	private final Context context;
	public static int counter = 1; // counter is used to save the images numbers
	public static Bitmap rImg;
	public static Bitmap bmp, bmp1;

	public ImageClick(Context context) {
		this.context = context;
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {

		File pictureFileDir = getDir();

		if (!pictureFileDir.exists() && !pictureFileDir.mkdirs()) {

			Log.d("", "Can't create directory to save image.");
			Toast.makeText(context, "Can't create directory to save image.",
					Toast.LENGTH_LONG).show();
			return;

		}

		String photoFile = "Picture" + counter + ".jpg";

		String filename = pictureFileDir.getPath() + File.separator + photoFile;

		File pictureFile = new File(filename);

		try {
			FileOutputStream fos = new FileOutputStream(pictureFile);
			fos.write(data); // (byte[] data is written to the file)

			fos.close();
			CameraActivity.progressDialog.dismiss();

			Toast.makeText(context, "New Image saved:" + photoFile,
					Toast.LENGTH_LONG).show();

			// getting the image from the file where the image is saved

			File f = new File(Environment.getExternalStorageDirectory()
					.getPath()
					+ "/Pictures/CameraAPIDemo/Picture"
					+ counter
					+ ".jpg");

			counter++;

			// up-to here

			// set the orientation of the saved image
			if (counter > 0 && counter <= 4) { // counter is incremented before
												// the if statement so we use 4
				BitmapFactory.Options options = new BitmapFactory.Options();

				options.inDensity = 80;// VM size exceeded

				bmp = BitmapFactory.decodeFile(f.getAbsolutePath(), options); // here
																				// also
				Matrix rotateRight = new Matrix();
				rotateRight.preRotate(90);

				if (android.os.Build.VERSION.SDK_INT > 10) {
					float[] mirrorY = { -1, 0, 0, 0, 1, 0, 0, 0, 1 };
					rotateRight = new Matrix();
					Matrix matrixMirrorY = new Matrix();
					matrixMirrorY.setValues(mirrorY);

					rotateRight.postConcat(matrixMirrorY);

					rotateRight.preRotate(270);

				}

				rImg = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(),
						bmp.getHeight(), rotateRight, true);

				bmp = null;
				// up-to here
				CameraActivity.iv.setImageBitmap(rImg);
				try {
					FileOutputStream out = new FileOutputStream(f);
					rImg.compress(Bitmap.CompressFormat.JPEG, 90, out);
					out.flush();
					out.close();

				} catch (Exception e) {
					e.printStackTrace();
					// up-to here
					// recycles the bitmap

				}

			}
			if (counter == 5 || counter == 6) { // counter is incremented before
												// the if statement so we use 6
				BitmapFactory.Options options = new BitmapFactory.Options();

				options.inDensity = 80;// VM size exceeded
				options.inSampleSize = 4;
				bmp1 = BitmapFactory.decodeFile(f.getAbsolutePath(), options); // here
																				// also
				Matrix rotateRight = new Matrix();
				rotateRight.preRotate(90);

				if (android.os.Build.VERSION.SDK_INT > 10) {
					// float[] mirrorY = { -1, 0, 0, 0, 1, 0, 0, 0, 1 };
					rotateRight = new Matrix();
					Matrix matrixMirrorY = new Matrix();
					// matrixMirrorY.setValues(mirrorY);

					rotateRight.postConcat(matrixMirrorY);

					rotateRight.preRotate(90);

				}

				rImg = Bitmap.createBitmap(bmp1, 0, 0, bmp1.getWidth(),
						bmp1.getHeight(), rotateRight, true);
				bmp1 = null;
				// up-to here
				CameraActivity.iv.setImageBitmap(rImg);
				try {
					FileOutputStream out = new FileOutputStream(f);
					rImg.compress(Bitmap.CompressFormat.JPEG, 90, out);
					out.flush();
					out.close();

				} catch (Exception e) {
					e.printStackTrace();
					// up-to here
					// recycles the bitmap

				}

			}
			// save the bitmap into a file in the sd card

		} catch (Exception error) {
			Log.d("", "File" + filename + "not saved: " + error.getMessage());
			Toast.makeText(context, "Image could not be saved.",
					Toast.LENGTH_LONG).show();

		}
		// bmp.recycle(); // recycles the bitmap and replaces the previous image
		// by the current image
		camera.startPreview();

	}

	private File getDir() {
		File sdDir = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		return new File(sdDir, "CameraAPIDemo");
	}
}
