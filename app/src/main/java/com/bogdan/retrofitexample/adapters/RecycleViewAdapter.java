package com.bogdan.retrofitexample.adapters;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bogdan.retrofitexample.R;
import com.bogdan.retrofitexample.models.Book;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<Book> bookList;
    private OnItemClickListener onItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public RecycleViewAdapter(OnItemClickListener listener) {

        onItemClickListener = listener;
        bookList = new ArrayList<>();

    }

    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Book book = bookList.get(position);
        holder.bind(bookList.get(position), onItemClickListener);
        holder.textView_book_title.setText(book.volumeInfo.title);
        try {
            holder.textView_book_authors.setText(book.volumeInfo.authors.get(0));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        holder.textView_book_publishedDate.setText("Published date: " + book.volumeInfo.publishedDate);
        if (book.volumeInfo.pageCount != 0) {
            holder.textView_book_pageCount.setText(book.volumeInfo.pageCount + " pages");
        } else {
            holder.textView_book_pageCount.setText("N/A");
        }
        if (book.volumeInfo.averageRating != 0.0) {
            holder.textView_book_rating.setText(String.valueOf(book.volumeInfo.averageRating));
        } else {
            holder.textView_book_rating.setText("N/A");
        }


        Glide.with(holder.imageView_book_thumbnail.getContext())
            .load(book.volumeInfo.imageLinks.smallThumbnail)
            .into(holder.imageView_book_thumbnail);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView_book_thumbnail;
        private TextView textView_book_title;
        private TextView textView_book_publishedDate;
        private TextView textView_book_authors;
        private TextView textView_book_pageCount;
        private TextView textView_book_rating;


        public ViewHolder(View itemView) {
            super(itemView);

            imageView_book_thumbnail = itemView.findViewById(R.id.imageView_book_cover);
            textView_book_title = itemView.findViewById(R.id.textView_book_title);
            textView_book_publishedDate = itemView.findViewById(R.id.textView_book_publishedDate);
            textView_book_authors = itemView.findViewById(R.id.textView_book_authors);
            textView_book_pageCount = itemView.findViewById(R.id.textView_book_pageCount);
            textView_book_rating = itemView.findViewById(R.id.textView_book_rating);

        }

        public void bind(final Book book, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(book);
                }
            });
        }
    }

    public void clear() {
        bookList.clear();
        notifyDataSetChanged();
    }

    public void setData(List<Book> bookList) {
        this.bookList.clear();
        this.bookList.addAll(bookList);
        notifyDataSetChanged();
    }

}
