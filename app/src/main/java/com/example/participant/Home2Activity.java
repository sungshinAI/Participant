package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home2Activity extends AppCompatActivity {

    private ImageButton home2;
    private ImageButton home4;
    private ImageButton home3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);

        home2 = findViewById(R.id.home2);
        home3 = findViewById(R.id.home3);
        home4 = findViewById(R.id.home4);
        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // seven Activity로 전환
                Intent intent = new Intent(Home2Activity.this, SevenActivity.class);
                startActivity(intent);
            }
        });

        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // seven Activity로 전환
                Intent intent = new Intent(Home2Activity.this, homebutton3_1Activity.class);
                startActivity(intent);
            }
        });

        home4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // seven Activity로 전환
                Intent intent = new Intent(Home2Activity.this, homebutton2_1Activity.class);
                startActivity(intent);
            }
        });
    }
}