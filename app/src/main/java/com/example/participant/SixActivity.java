package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SixActivity extends AppCompatActivity {

    private Button btn6_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.six);

        btn6_1 = findViewById(R.id.btn6_1);
        btn6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Home2 화면으로 전환
                Intent intent = new Intent(SixActivity.this, Home2Activity.class);
                startActivity(intent);
            }
        });
    }
}