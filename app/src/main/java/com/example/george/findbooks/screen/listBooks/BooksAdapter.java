package com.example.george.findbooks.screen.listBooks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.george.findbooks.R;
import com.example.george.findbooks.screen.infoBooks.BookInfoActivity;
import com.example.george.findbooks.models.Book;

import java.util.List;

/**
 * Created by George on 14.05.2018.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    private Context context;
    List<Book> books;

    public BooksAdapter(Context applicationContext, List<Book> bookList) {

        context = applicationContext;
        books = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {
        if (books.get(position).getVolumeInfo().getImageLinks() == null) {
            Glide.with(context)
                    .load(R.drawable.img)
                    .into(holder.imageView);
        } else {
            Glide.with(context)
                    .load(books.get(position).getVolumeInfo().getImageLinks().getThumbnail())
                    .into(holder.imageView);
        }
        holder.author.setText(books.get(position).getVolumeInfo().getAuthors().replaceAll("^\\[|\\]$", ""));
        holder.title.setText(books.get(position).getVolumeInfo().getTitle());
        }






    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,author, id;
        private ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titles);
            author = (TextView) itemView.findViewById(R.id.authors);
            imageView = (ImageView) itemView.findViewById(R.id.img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, BookInfoActivity.class);
                    intent.putExtra("id", books.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(intent);

                }
            });

        }


    }
}
