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


        btn2_1.setOnClickListener(new View.OnClickListener() { // 지금 공유할게요
            @Override
            public void onClick(View view) { // btn9_1 버튼은 클릭했을 때 이 안쪽을 실행해라.
                // 버튼 누르면 색깔 변하는 기능
                btn2_1.setBackgroundTintList(getResources().getColorStateList(R.color.blue)); // 이 부분은 실제로 사용하고 있는 버튼 모양 리소스로 변경해야 합니다.
            }
        });

        btn2_2.setOnClickListener(new View.OnClickListener() { // 지금 공유할게요
            @Override
            public void onClick(View view) { // btn9_1 버튼은 클릭했을 때 이 안쪽을 실행해라.
                // 버튼 누르면 색깔 변하는 기능
                btn2_2.setBackgroundTintList(getResources().getColorStateList(R.color.blue)); // 이 부분은 실제로 사용하고 있는 버튼 모양 리소스로 변경해야 합니다.
            }
        });


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