package com.example.participant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ElevenActivity extends AppCompatActivity {

    RadioGroup radio_group;
    LinearLayout resultsLayout;
    private ImageButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleven);

        resultsLayout = findViewById(R.id.resultsLayout);
        radio_group = findViewById(R.id.radio_group);

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 이전에 추가된 뷰 제거
                resultsLayout.removeAllViews();

                if (checkedId == R.id.rb_a) {
                    View AView = getLayoutInflater().inflate(R.layout.a, resultsLayout, false);
                    resultsLayout.addView(AView);
                } else if (checkedId == R.id.rb_b) {
                    View BView = getLayoutInflater().inflate(R.layout.b, resultsLayout, false);
                    resultsLayout.addView(BView);
                } else if (checkedId == R.id.rb_c) {
                    View CView = getLayoutInflater().inflate(R.layout.c, resultsLayout, false);
                    resultsLayout.addView(CView);
                }
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 실시간 확인 seven Activity로 전환
                Intent intent = new Intent(ElevenActivity.this, SevenActivity.class);
                startActivity(intent);
            }
        });
    }
}