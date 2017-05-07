package com.example.android.healthkit.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nawthuellay on 3/10/2016.
 */
public class ServiceVO {
    @SerializedName("event_title")
    String serviceTitle;

    @SerializedName("service_photo")
    String servicePhoto;

    @SerializedName("service_desc")
    String serviceDesc;

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String eventTitle) {
        this.serviceTitle = eventTitle;
    }

    public String getServicePhoto() {
        return servicePhoto;
    }

    public void setServicePhoto(String servicePhoto) {
        this.servicePhoto = servicePhoto;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }
}
