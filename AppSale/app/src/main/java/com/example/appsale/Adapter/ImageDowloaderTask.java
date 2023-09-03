package com.example.appsale.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import com.example.appsale.R;

import org.apache.http.HttpStatus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDowloaderTask extends AsyncTask<String, Void, Bitmap> {
    private final WeakReference<ImageView> imageViewWeakReference;

    public ImageDowloaderTask(ImageView imageView) {
        imageViewWeakReference = new WeakReference<ImageView>(imageView);
    }


    @Override
    protected Bitmap doInBackground(String... strings) {
        return dowloadBitmap(strings[0]);
    }

    private Bitmap dowloadBitmap(String url) {
        HttpURLConnection httpURLConnection = null;
        Bitmap bitmap = null;

        try {
            URL url1 = new URL(url);
            httpURLConnection = (HttpURLConnection) url1.openConnection();
            int statusCode = httpURLConnection.getResponseCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                bitmap = BitmapFactory.decodeStream(inputStream);

                // Lưu tệp Bitmap xuống bộ nhớ
                if (bitmap != null) {
                    File file = new File(Environment.getExternalStorageDirectory(), "downloaded_image.jpg");
                    FileOutputStream outStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                    outStream.flush();
                    outStream.close();
                }
            }
        } catch (Exception e) {
            httpURLConnection.disconnect();
            Log.w("Image download failed:", "Error: " + e.getMessage());
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return bitmap;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {

        if (isCancelled()) bitmap = null;
        if (imageViewWeakReference != null) {
            ImageView imageView = imageViewWeakReference.get();
            if (imageView != null) {
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    Drawable drawable = imageView.getContext().getResources().getDrawable(R.drawable.noimage);
                    imageView.setImageDrawable(drawable);
                }
            }
        }
    }
}
