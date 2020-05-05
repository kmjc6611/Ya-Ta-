package com.example.shadow98a.log_in_test_0;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClickMenu extends AppCompatActivity {

    Button member_info;
    Button member_approval;
    Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_menu);

        member_info = (Button)findViewById(R.id.member_info);

        member_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClickMenu.this, Member_info.class);
                startActivity(intent);
            }
        });



                accept = (Button)findViewById(R.id.accept);
                accept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ClickMenu.this, uncomfortable.class);
                        startActivity(intent);
            }
        });


    }
}