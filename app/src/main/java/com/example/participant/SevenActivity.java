package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SevenActivity extends AppCompatActivity {

    private Button btn7_1;
    private Button btn7_2;
    private Button btn7_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seven);

        btn7_1 = findViewById(R.id.btn7_1);
        btn7_2 = findViewById(R.id.btn7_2);
        btn7_3 = findViewById(R.id.btn7_3);


        btn7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 눌렀을 때 색깔 변하는 기능

                // 9. 투표 결과 확인 Activity로 전환
                Intent intent = new Intent(SevenActivity.this, NineActivity.class);
                startActivity(intent);
            }
        });


        btn7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 눌렀을 때 색깔 변하는 기능

                // 10. 실시간 참여 현황 Activity로 전환
                Intent intent = new Intent(SevenActivity.this, TenActivity.class);
                startActivity(intent);
            }
        });

        btn7_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 눌렀을 때 색깔 변하는 기능

                // 11. 우선순위 결과 Activity로 전환
                Intent intent = new Intent(SevenActivity.this, ElevenActivity.class);
                startActivity(intent);
            }
        });
    }
}