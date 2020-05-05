package com.example.user.yata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button btnDriverLogin;
    Button btnUserLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnDriverLogin = (Button)findViewById(R.id.btnDriverLogin);
        btnDriverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DriverLoginActivity.class);
                startActivity(intent);
            }
        });

        btnUserLogin = (Button)findViewById(R.id.btnUserLogin);
        btnUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UserLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
