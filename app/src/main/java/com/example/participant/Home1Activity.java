package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home1Activity extends AppCompatActivity {

    private Button btnhome1_2;
    private ImageButton home1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1);

        btnhome1_2 = findViewById(R.id.btnhome1_2);
        home1 = findViewById(R.id.home1);

        btnhome1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 초대링크 넣는 Activity로 전환
                Intent intent = new Intent(Home1Activity.this, OneActivity.class);
                startActivity(intent);
            }
        });

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home1Activity.this, Home2Activity.class);
                startActivity(intent);
            }
        });
    }
}