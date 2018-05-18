package com.example.george.findbooks.models;

import com.example.george.findbooks.models.Book;
import com.example.george.findbooks.models.VolumeInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by George on 14.05.2018.
 */

 public class BooksList {
    @SerializedName("items")
    @Expose
    private List<Book> items;

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }
}
