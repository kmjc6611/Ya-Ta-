package com.example.user.yata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity {
    Button btnUser1;
    Button btnDriver1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnUser1 = (Button)findViewById(R.id.btnUser1);
        btnUser1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, UserSignIn2.class);
                startActivity(intent);
            }
        });

        btnDriver1 = (Button)findViewById(R.id.btnDriver1);
        btnDriver1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, DriverSignIn3.class);
                startActivity(intent);
            }
        });
    }
}
