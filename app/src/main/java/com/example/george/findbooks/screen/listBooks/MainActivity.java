package com.example.george.findbooks.screen.listBooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.george.findbooks.api.ApiFactory;
import com.example.george.findbooks.models.Book;
import com.example.george.findbooks.models.BooksList;
import com.example.george.findbooks.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private EditText searchView;
    private ImageView btn;
    public String searchKey;
    private Toolbar mActionBarToolbar;
    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
//        setSupportActionBar(mActionBarToolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        searchView = (EditText) findViewById(R.id.search_view);
        btn = (ImageView) findViewById(R.id.btn_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        searchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    loadJSON();
                    hideKeys();
                    return true;
                }
                return false;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadJSON();

                hideKeys();
            }
        });

    }

    void hideKeys() {
        InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchView.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    private void loadJSON() {
        if (searchView.getText().equals(null)) {

            Toast.makeText(MainActivity.this, "Введите запрос", Toast.LENGTH_SHORT).show();

        } else {
            try {
                Call<BooksList> mCall = ApiFactory.getBookService().searchBook(searchView.getText().toString());
                mCall.enqueue(new Callback<BooksList>() {
                    @Override
                    public void onResponse(retrofit2.Call<BooksList> call, Response<BooksList> response) {

                        if (response.isSuccessful()) {
                            List<Book> bookList = response.body().getItems();
                            recyclerView.setAdapter(new BooksAdapter(getApplicationContext(), bookList));
                        }

                    }

                    @Override
                    public void onFailure(retrofit2.Call<BooksList> call, Throwable t) {

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
