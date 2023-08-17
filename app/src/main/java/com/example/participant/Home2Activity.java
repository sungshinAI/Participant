package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home2Activity extends AppCompatActivity {

    private Button home2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);

        home2 = findViewById(R.id.home2);
        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // seven Activity로 전환
                Intent intent = new Intent(Home2Activity.this, SevenActivity.class);
                startActivity(intent);
            }
        });
    }
}