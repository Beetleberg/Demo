package com.example.george.findbooks.models;

import com.example.george.findbooks.R;
import com.google.gson.annotations.SerializedName;

/**
 * Created by George on 14.05.2018.
 */

public class ImageLinks {
    private transient int id;

    @SerializedName("smallThumbnail")
    private String smallThumbnail;

    @SerializedName("thumbnail")
    private String thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmallThumbnail() {
        if (smallThumbnail == null) {
            return "Нету картинки";
        }
        else
            return smallThumbnail;

    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        if (thumbnail == null) {
            return "Нету картинки";
        }
        else
            return thumbnail;

    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
