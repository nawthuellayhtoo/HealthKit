package com.example.android.healthkit.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nawthuellay on 3/12/2016.
 */
public class DoctorCategoryVO {
    @SerializedName("doctor_category")
    String doctorCategory;

    @SerializedName("category_photo")
    String categoryPhoto;

    public String getDoctorCategory() {
        return doctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }

    public String getCategoryPhoto() {
        return categoryPhoto;
    }

    public void setCategoryPhoto(String categoryPhoto) {
        this.categoryPhoto = categoryPhoto;
    }
}
