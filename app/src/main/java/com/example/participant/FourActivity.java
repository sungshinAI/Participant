package com.example.participant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FourActivity extends AppCompatActivity {

    private ListView listViewAppointments;
    private ArrayAdapter<String> adapter;
    private List<String> appointmentList;
    private FirebaseAuth mAuth;

    private Button btn10_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);

        // Firebase Authentication 인스턴스 초기화
        mAuth = FirebaseAuth.getInstance();

        // ListView와 어댑터 초기화
        listViewAppointments = findViewById(R.id.listViewAppointments);
        appointmentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appointmentList);
        listViewAppointments.setAdapter(adapter);
        btn10_3 = findViewById(R.id.btn10_3);

        btn10_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 장소 투표 Activity로 전환
                Intent intent = new Intent(FourActivity.this, FiveActivity.class);
                startActivity(intent);
            }
        });

        // Firestore에서 약속 정보 조회
        fetchAppointments();
    }

    private void fetchAppointments() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("appointments")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Firestore에서 약속 정보 읽기
                            String creator = document.getString("creator");
                            Date dateTime = document.getDate("dateTime");

                            // 날짜와 시간 형식 변환
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                            String formattedDateTime = dateFormat.format(dateTime);

                            // 약속 정보 리스트에 추가
                            appointmentList.add("Created by: " + creator + "\nDate and Time: " + formattedDateTime);
                        }
                        // 어댑터 갱신하여 약속 정보 표시
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    // 현재 로그인한 사용자의 표시 이름 가져오기
    private String getCurrentUserDisplayName() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            return currentUser.getDisplayName();
        }
        return "Unknown";
    }
}

