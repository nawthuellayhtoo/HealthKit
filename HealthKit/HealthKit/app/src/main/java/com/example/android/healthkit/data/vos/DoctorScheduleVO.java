package com.example.android.healthkit.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nawthuellay on 3/13/2016.
 */
public class DoctorScheduleVO {
    @SerializedName("doctor_category")
    String doctorCategory;

    @SerializedName("doctor_name")
    String doctorName;

    @SerializedName("doctor_qualification")
    String doctorQualification;

    @SerializedName("doctor_date_time")
    String dateTime;

    public String getDoctorCategory() {
        return doctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorQualification() {
        return doctorQualification;
    }

    public void setDoctorQualification(String doctorQualification) {
        this.doctorQualification = doctorQualification;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
