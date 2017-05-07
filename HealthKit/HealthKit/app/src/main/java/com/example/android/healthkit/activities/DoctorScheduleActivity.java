package com.example.android.healthkit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.healthkit.HealthKitApp;
import com.example.android.healthkit.R;

public class DoctorScheduleActivity extends AppCompatActivity {
    private static final String IE_POSITION = "IE_POSITION";
    public int position;

    public static Intent newIntent(int position) {

        Intent intentToDoctorScheduleActivity = new Intent(HealthKitApp.getContext(), DoctorScheduleActivity.class);
        intentToDoctorScheduleActivity.putExtra(IE_POSITION, position);
        return intentToDoctorScheduleActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_schedule);
    }

    public int getDetailPosition() {
        Intent intent = getIntent();
        position = intent.getIntExtra(IE_POSITION, 0);
        return position;
    }
}
