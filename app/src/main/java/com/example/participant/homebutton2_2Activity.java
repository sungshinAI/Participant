package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homebutton2_2Activity extends AppCompatActivity {

    private Button btn25_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homebutton2_2);

        btn25_1 = findViewById(R.id.btn25_1);

        btn25_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homebutton2_2Activity.this, Home2Activity.class);
                startActivity(intent);
            }
        });
    }
}