package com.example.george.findbooks.models;

import com.example.george.findbooks.R;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by George on 14.05.2018.
 */

public class VolumeInfo {

    private transient int id;

    @SerializedName("title")
    private String title;

    @SerializedName("subtitle")
    private String subtitle;

    @SerializedName("authors")
    private String[] authors;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("description")
    private String description;

    @SerializedName("publishedDate")
    private String publishedDate;

    @SerializedName("pageCount")
    private int pageCount;

    @SerializedName("imageLinks")
    private ImageLinks imageLinks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthors() {
        String str = Arrays.toString(authors);
        return str;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
        


    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

}
