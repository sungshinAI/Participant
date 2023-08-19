package com.example.participant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FiveActivity extends AppCompatActivity {
    private DatabaseReference placesRef = FirebaseDatabase.getInstance().getReference("places");

    private EditText placeNameEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five);

        placeNameEditText = findViewById(R.id.placeNameEditText);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placeName = placeNameEditText.getText().toString();
                if (!placeName.isEmpty()) {
                    registerPlace(placeName);
                }

                // 일정 등록이 완료되었습니다 Activity로 전환
                Intent intent = new Intent(FiveActivity.this, EightActivity.class);
                startActivity(intent);
            }
        });
    }
    private void registerPlace(String placeName) {
        placesRef.child(placeName).child("votes").setValue(0L);
        finish(); // 액티비티 종료
    }
}
