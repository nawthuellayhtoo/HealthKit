package com.example.android.healthkit;

import android.app.Application;
import android.content.Context;

import com.example.android.healthkit.data.DataManager;

/**
 * Created by nawthuellay on 3/7/2016.
 */
public class HealthKitApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        DataManager.getInstance().loadHomeList();
        DataManager.getInstance().loadServiceList();
        DataManager.getInstance().loadHealthTipsList();

        DataManager.getInstance().loadDoctorCategoryList();

        DataManager.getInstance().loadCardiologistList();
        DataManager.getInstance().loadDentistList();
        DataManager.getInstance().loadGeneralPhysicianList();
        DataManager.getInstance().loadGeneralSurgeonList();

        DataManager.getInstance().loadNeurolgistList();
        DataManager.getInstance().loadOphthalmologistList();
        DataManager.getInstance().loadPediatricianList();
        DataManager.getInstance().loadUrologistList();

    }

    public static Context getContext() {
        return context;
    }
}
