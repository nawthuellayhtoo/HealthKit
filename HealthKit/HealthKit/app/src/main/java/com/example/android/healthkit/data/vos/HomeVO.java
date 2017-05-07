package com.example.android.healthkit.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nawthuellay on 3/9/2016.
 */
public class HomeVO {
    @SerializedName("url")
    String url;

    @SerializedName("name")
    String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
