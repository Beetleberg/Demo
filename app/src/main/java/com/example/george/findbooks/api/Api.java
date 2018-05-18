package com.example.george.findbooks.api;

import com.example.george.findbooks.models.Book;
import com.example.george.findbooks.models.BooksList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {


    @GET("volumes")
    Call<BooksList> searchBook(@Query("q") String name);



    @GET("volumes/{book}")
    Call<Book> getBook(@Path("book") String book);

}