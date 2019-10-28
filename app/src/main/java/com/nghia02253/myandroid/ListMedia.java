package com.nghia02253.myandroid;

public class ListMedia {
    private String nameMedia;
    private int urlFile;

    public ListMedia(String nameMedia, int urlFile) {
        this.nameMedia = nameMedia;
        this.urlFile = urlFile;
    }

    public String getNameMedia() {
        return nameMedia;
    }

    public void setNameMedia(String nameMedia) {
        this.nameMedia = nameMedia;
    }

    public int getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(int urlFile) {
        this.urlFile = urlFile;
    }
}
