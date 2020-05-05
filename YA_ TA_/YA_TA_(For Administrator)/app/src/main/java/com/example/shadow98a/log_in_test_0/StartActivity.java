package com.example.shadow98a.log_in_test_0;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;


public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this, ClickMenu.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

        ImageView run = (ImageView)findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifimage = new GlideDrawableImageViewTarget(run);
        Glide.with(this).load(R.drawable.run).into(gifimage);
    }
}