package com.example.android.healthkit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.healthkit.HealthKitApp;
import com.example.android.healthkit.R;

public class HealthTipsDetailActivity extends AppCompatActivity {
    private static final String IE_POSITION = "IE_POSITION";
    public int position;
    public static Intent newIntent(int position) {

        Intent intentToHealthTipsDetailActivity = new Intent(HealthKitApp.getContext(), HealthTipsDetailActivity.class);
        intentToHealthTipsDetailActivity.putExtra(IE_POSITION, position);
        return intentToHealthTipsDetailActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips_detail);
    }

    public int getDetailPosition() {
        Intent intent = getIntent();
        position = intent.getIntExtra(IE_POSITION, 0);
        return position;
    }
}
