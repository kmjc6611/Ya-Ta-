package com.example.user.yata;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DriverSignIn3 extends AppCompatActivity {
    Button btnMain1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_in3);


        final CheckBox cb = (CheckBox)findViewById(R.id.checkBox);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        final CheckBox cb3 = (CheckBox)findViewById(R.id.checkBox3);

        btnMain1 = (Button)findViewById(R.id.btnMain1);





                btnMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if(cb.isChecked() == true && cb2.isChecked() ==true &&cb3.isChecked() == true) {
                            Intent intent = new Intent(DriverSignIn3.this, DriverSignIn1.class);
                            startActivity(intent);
                        }

            }
        });
    }
}
