package com.example.participant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EightActivity extends AppCompatActivity {

    private DatabaseReference placesRef = FirebaseDatabase.getInstance().getReference("places");

    private RadioGroup placeRadioGroup;
    private Button voteButton;
    private TextView btn8_2;

    private List<String> placeNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eight);

        placeRadioGroup = findViewById(R.id.placeRadioGroup);
        voteButton = findViewById(R.id.voteButton);
        btn8_2 = findViewById(R.id.btn8_2);

        loadPlaceNames();

        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = placeRadioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedPlaceName = selectedRadioButton.getText().toString();

                    voteForPlace(selectedPlaceName);
                }

                // Home2 Activity로 전환
                Intent intent = new Intent(EightActivity.this, SixActivity.class);
                startActivity(intent);
            }
        });

        btn8_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 5. 장소 등록 Activity로 전환
                Intent intent = new Intent(EightActivity.this, FiveActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadPlaceNames() {
        placesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                placeNames.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String placeName = snapshot.getKey();   // 장소 이름 가져옴
                    placeNames.add(placeName);
                }

                setupRadioButtons();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 처리 중 오류 발생 시 처리
            }
        });
    }

    private void setupRadioButtons() {
        placeRadioGroup.removeAllViews();

        for (String placeName : placeNames) {
            RadioButton radioButton = new RadioButton(EightActivity.this);
            radioButton.setText(placeName);
            placeRadioGroup.addView(radioButton);
        }
    }

    private void voteForPlace(String placeName) {
        placesRef.child(placeName).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                Long votes = mutableData.child("votes").getValue(Long.class);
                if (votes == null) {
                    votes = 1L;
                } else {
                    votes++;
                }
                mutableData.child("votes").setValue(votes);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    // 업데이트 중 오류 처리
                } else {
                    Toast.makeText(EightActivity.this, "투표가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
