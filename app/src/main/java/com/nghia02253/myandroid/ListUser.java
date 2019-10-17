package com.nghia02253.myandroid;

import java.io.Serializable;

public class ListUser implements Serializable {

    private String tvTime, tvStatus,tvTitle, tvDesc;
    private int ivImage;

    public ListUser(String tvTime, String tvStatus, String tvTitle, String tvDesc, int ivImage) {
        this.tvTime = tvTime;
        this.tvStatus = tvStatus;
        this.tvTitle = tvTitle;
        this.tvDesc = tvDesc;
        this.ivImage = ivImage;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }

    public String getTvStatus() {
        return tvStatus;
    }

    public void setTvStatus(String tvStatus) {
        this.tvStatus = tvStatus;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public String getTvDesc() {
        return tvDesc;
    }

    public void setTvDesc(String tvDesc) {
        this.tvDesc = tvDesc;
    }

    public int getIvImage() {
        return ivImage;
    }

    public void setIvImage(int ivImage) {
        this.ivImage = ivImage;
    }
}
