package com.example.android.healthkit.fragments;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.healthkit.R;
import com.example.android.healthkit.activities.DoctorScheduleActivity;
import com.example.android.healthkit.data.DataManager;
import com.example.android.healthkit.data.vos.DoctorScheduleVO;
import com.example.android.healthkit.utils.HealthTipsConstants;
import com.example.android.healthkit.views.ViewItemDoctorSchedule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nawthuellay on 3/13/2016.
 */
public class DoctorScheduleFragment extends Fragment {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 100;

    private String numberToCall = null;
    public DoctorScheduleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DoctorScheduleActivity healthTipsDetailActivity = (DoctorScheduleActivity) getActivity();
        int position = healthTipsDetailActivity.getDetailPosition();

        //get view from fragment
        View rootView = inflater.inflate(R.layout.fragment_doctor_schedule, container, false);

        LinearLayout llDoctorScheduleRoot = (LinearLayout) rootView.findViewById(R.id.ll_doctor_schedule_root);

        List<DoctorScheduleVO> doctorScheduleVOList=new ArrayList<DoctorScheduleVO>();

        switch (position){
            case 0:
                doctorScheduleVOList = DataManager.getInstance().getCardiologistList();
                break;
            case 1:
                doctorScheduleVOList = DataManager.getInstance().getDentistList();
                break;
            case 2:
                doctorScheduleVOList = DataManager.getInstance().getGeneralPhysicianList();
                break;
            case 3:
                doctorScheduleVOList = DataManager.getInstance().getGeneralSurgeonList();
                break;
            case 4:
                doctorScheduleVOList = DataManager.getInstance().getNeurologistList();
                break;
            case 5:
                doctorScheduleVOList = DataManager.getInstance().getOphthalmologistList();
                break;
            case 6:
                doctorScheduleVOList = DataManager.getInstance().getPediatricianList();
                break;
            case 7:
                doctorScheduleVOList = DataManager.getInstance().getUrologistList();
                break;
            default:
                Toast.makeText(getActivity(),
                        "Click ListItem Number is invalid ", Toast.LENGTH_LONG)
                        .show();
                break;
        }
        Button emergencyCall;
        for (DoctorScheduleVO schedule : doctorScheduleVOList) {
            ViewItemDoctorSchedule viDoctorSchedule = (ViewItemDoctorSchedule) inflater.inflate(R.layout.view_item_doctor_schedule, container, false);
            viDoctorSchedule.setData(schedule);

            emergencyCall = (Button) viDoctorSchedule.findViewById(R.id.im_btn_call_for_book);
            emergencyCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onTapCall();
                }
            });

            llDoctorScheduleRoot.addView(viDoctorSchedule);

            }
        return rootView;
    }
    public void onTapCall() {
        makeCall(HealthTipsConstants.NUMBER_TO_CALL);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay!
                    makeCall(numberToCall);

                } else {

                }
                return;
            }
            }
    }

    protected void makeCall(String numberToCall) {
        numberToCall.replaceAll(" ", "");
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numberToCall));

        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            this.numberToCall = numberToCall;

            ActivityCompat.requestPermissions(this.getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);

            return;
        }
        startActivity(intent);
    }
}
