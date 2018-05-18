package com.example.george.findbooks.screen.infoBooks;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.george.findbooks.R;
import com.example.george.findbooks.models.Book;

public class BookInfoActivity extends AppCompatActivity {

    private TextView descrip,author,title,subTitle,publisher,pubDate,pageCount;
    private ImageView largeImage;
    public static final int LOADER_ID = 1;
    private String book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        book = getIntent().getExtras().getString("id");

        descrip = (TextView) findViewById(R.id.description);
        author = (TextView) findViewById(R.id.author);
        title = (TextView) findViewById(R.id.book_title);
        subTitle = (TextView) findViewById(R.id.subtitle);
        publisher = (TextView) findViewById(R.id.publisher);
        pubDate = (TextView) findViewById(R.id.publishedDate);

        largeImage = (ImageView) findViewById(R.id.cover);

       loadBook();


    }

    private void loadBook() {
        LoaderManager.LoaderCallbacks<Book> callbacks = new BooksCallback();

            getLoaderManager().initLoader(LOADER_ID, Bundle.EMPTY, callbacks);

    }


    private void initView(Book book) {
        descrip.setText(book.getVolumeInfo().getDescription());
        author.setText(book.getVolumeInfo().getAuthors().replaceAll("^\\[|\\]$", ""));
        publisher.setText(book.getVolumeInfo().getPublisher());
        pubDate.setText(book.getVolumeInfo().getPublishedDate());
        title.setText(book.getVolumeInfo().getTitle());
        subTitle.setText(book.getVolumeInfo().getSubtitle());
//        pageCount.setText(book.getVolumeInfo().getPageCount());

        if (book.getVolumeInfo().getImageLinks() == null) {
            Glide.with(this)
                    .load(R.drawable.img)
                    .into(largeImage);
        } else {
            Glide.with(this)
                    .load(book.getVolumeInfo().getImageLinks().getThumbnail())
                    .into(largeImage);
        }

    }

    public class BooksCallback implements LoaderManager.LoaderCallbacks<Book> {

        @Override
        public Loader<Book> onCreateLoader(int id, Bundle args) {
            return new InfoLoader(BookInfoActivity.this, book);
        }

        @Override
        public void onLoadFinished(Loader<Book> loader, Book data) {
            initView(data);
        }

        @Override
        public void onLoaderReset(Loader<Book> loader) {

        }
    }
}
