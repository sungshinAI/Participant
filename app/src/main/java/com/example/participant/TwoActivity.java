package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwoActivity extends AppCompatActivity {
    private Button btn2_1; // 가능
    private Button btn2_2; // 불가능
    private Button btn2_3; // 다음

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);

        btn2_1=findViewById(R.id.btn2_1);
        btn2_2=findViewById(R.id.btn2_2);
        btn2_3=findViewById(R.id.btn2_3);

        btn2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 화면 전환
                Intent intent = new Intent(TwoActivity.this, ThreeActivity.class);
                startActivity(intent);
            }
        });
    }
}