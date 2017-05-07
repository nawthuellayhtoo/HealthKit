package com.example.android.healthkit.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nawthuellay on 3/11/2016.
 */
public class HealthTipsVO {
    @SerializedName("main_title")
    String mainTitle;

    @SerializedName("tips_photo")
    String tipsPhoto;

    @SerializedName("tips_author")
    String tipsAuthor;

    @SerializedName("tips_desc")
    String tipsDesc;

    public String getTipsDesc() {
        return tipsDesc;
    }

    public void setTipsDesc(String tipsDesc) {
        this.tipsDesc = tipsDesc;
    }

    public String getTipsAuthor() {
        return tipsAuthor;
    }

    public void setTipsAuthor(String tipsAuthor) {
        this.tipsAuthor = tipsAuthor;
    }

    public String getTipsPhoto() {
        return tipsPhoto;
    }

    public void setTipsPhoto(String tipsPhoto) {
        this.tipsPhoto = tipsPhoto;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }
}
