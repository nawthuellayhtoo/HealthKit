package com.example.android.healthkit.data.dto;

/**
 * Created by nawthuellay on 3/12/2016.
 */
public class DoctorCategoryDto {
    long id;

    String doctorCategory;

    String categoryPhoto;

    public String getCategoryPhoto() {
        return categoryPhoto;
    }

    public void setCategoryPhoto(String categoryPhoto) {
        this.categoryPhoto = categoryPhoto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDoctorCategory() {
        return doctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }
}
