package com.example.user.yata;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class UserSignIn2 extends AppCompatActivity {
    Button btnMain1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in2);

        final CheckBox cb5 = (CheckBox)findViewById(R.id.checkBox5);
        final CheckBox cb6 = (CheckBox)findViewById(R.id.checkBox6);
        final CheckBox cb7 = (CheckBox)findViewById(R.id.checkBox7);

        btnMain1 = (Button)findViewById(R.id.btnMain1);

        btnMain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cb6.isChecked() == true && cb5.isChecked() ==true &&cb7.isChecked() == true) {
                    Intent intent = new Intent(UserSignIn2.this, UserSignIn1.class);
                    startActivity(intent);
                }
            }
        });





    }

}
