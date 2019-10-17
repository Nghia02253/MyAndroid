package com.nghia02253.myandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImageInternet extends AppCompatActivity {
    Button btnLoadImg;
    ImageView imgLoad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image_internet);

        btnLoadImg = (Button) findViewById(R.id.btnLoadImage);
        imgLoad = (ImageView) findViewById(R.id.imgLoad);

        btnLoadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadImageInternetTask().execute("https://i.pinimg.com/originals/d5/c8/7c/d5c87c9160550d386791069339bbd762.jpg");
                //Cần xin cấp quyền truy cập Internet
            }
        });
    }

    private class LoadImageInternetTask extends AsyncTask<String, Void, Bitmap> {
        //AsyncTask<String, Void, Bitmap> --- String: đường dẫn truyền vào, Void: Trả về, Bitmap: Kết quả

        Bitmap bitmapHinh = null;
        @Override
        protected Bitmap doInBackground(String... parrams) {
            try {

                URL url = new URL(parrams[0]);
                //lấy dữ liệu từ đường dẫn
                InputStream inputStream = url.openConnection().getInputStream();
                //lấy giá trị hình chuyển về dạng bitmap
                bitmapHinh = BitmapFactory.decodeStream(inputStream);

            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmapHinh;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgLoad.setImageBitmap(bitmap);
        }
    }
}
