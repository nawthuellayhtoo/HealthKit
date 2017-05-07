package com.example.android.healthkit.data.dto;

/**
 * Created by nawthuellay on 3/11/2016.
 */
public class HealthTipsDto {

    long id;

    String mainTitle;

    String tipsPhoto;

    String tipsAuthor;

    String tipsDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getTipsPhoto() {
        return tipsPhoto;
    }

    public void setTipsPhoto(String tipsPhoto) {
        this.tipsPhoto = tipsPhoto;
    }

    public String getTipsAuthor() {
        return tipsAuthor;
    }

    public void setTipsAuthor(String tipsAuthor) {
        this.tipsAuthor = tipsAuthor;
    }

    public String getTipsDesc() {
        return tipsDesc;
    }

    public void setTipsDesc(String tipsDesc) {
        this.tipsDesc = tipsDesc;
    }
}
