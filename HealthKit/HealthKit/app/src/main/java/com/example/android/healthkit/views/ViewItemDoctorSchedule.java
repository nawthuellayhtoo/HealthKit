package com.example.android.healthkit.views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.android.healthkit.R;
import com.example.android.healthkit.data.vos.DoctorScheduleVO;

/**
 * Created by nawthuellay on 3/13/2016.
 */
public class ViewItemDoctorSchedule extends CardView {
    private TextView tvDoctorName;
    private TextView tvDoctorQualification;
    private TextView tvDateTime;

    public ViewItemDoctorSchedule(Context context) {
        super(context);
    }

    public ViewItemDoctorSchedule(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemDoctorSchedule(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvDoctorName = (TextView) findViewById(R.id.tv_doctor_name);
        tvDoctorQualification = (TextView) findViewById(R.id.tv_doctor_qualification);
        tvDateTime = (TextView) findViewById(R.id.tv_doctor_date_time);

    }

    public void setData(DoctorScheduleVO doctorScheduleVO) {
        tvDoctorName.setText(doctorScheduleVO.getDoctorName());
        tvDoctorQualification.setText(doctorScheduleVO.getDoctorQualification());
        tvDateTime.setText(doctorScheduleVO.getDateTime());
 }
}
