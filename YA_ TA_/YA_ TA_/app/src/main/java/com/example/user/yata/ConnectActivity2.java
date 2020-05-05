package com.example.user.yata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class ConnectActivity2 extends AppCompatActivity {
    Button btnEnd;
    Button button;

    String StudentID;
    String StudentID_of_driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect2);
        Intent getterIntent=getIntent();
        this.StudentID=getterIntent.getStringExtra("StudentID").toString();
        this.StudentID_of_driver=getterIntent.getStringExtra("StudentID_of_driver").toString();
        btnEnd = (Button)findViewById(R.id.btnEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ConnectActivity2.this, uncomfortable.class);
                intent.putExtra("StudentID",StudentID_of_driver);
                startActivity(intent);
            }
        });
        ImageView stop = (ImageView)findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifimage = new GlideDrawableImageViewTarget(stop);
        Glide.with(this).load(R.drawable.stop).into(gifimage);
    }
}
