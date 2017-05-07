package com.example.android.healthkit.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.healthkit.HealthKitApp;
import com.example.android.healthkit.R;
import com.example.android.healthkit.fragments.DoctorCategoryFragment;

public class DoctorCategoryActivity extends AppCompatActivity {

    public Fragment fragment=new Fragment();
    public FragmentManager fragmentManager= getFragmentManager();

    public static Intent newIntent() {
        Intent intentToDoctorCategory = new Intent(HealthKitApp.getContext(), DoctorCategoryActivity.class);
        return intentToDoctorCategory;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_category);

        fragment= new DoctorCategoryFragment();
        fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();
    }


}
