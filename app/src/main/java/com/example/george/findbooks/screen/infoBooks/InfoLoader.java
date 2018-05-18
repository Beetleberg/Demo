package com.example.george.findbooks.screen.infoBooks;

import android.content.Context;
import android.content.Loader;

import com.example.george.findbooks.api.ApiFactory;
import com.example.george.findbooks.models.Book;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 14.05.2018.
 */

public class InfoLoader extends Loader<Book> {


    private final Call<Book> mCall;
    private Book book;

    public InfoLoader(Context context,String book) {
        super(context);


        mCall = ApiFactory.getBookService().getBook(book);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (book != null) {
            deliverResult(book);
        } else {
            forceLoad();
        }
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        mCall.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                book = response.body();
                deliverResult(book);
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

                deliverResult(null);
            }
        });
    }

    @Override
    protected void onStopLoading() {
        mCall.cancel();
        super.onStopLoading();
    }
}
