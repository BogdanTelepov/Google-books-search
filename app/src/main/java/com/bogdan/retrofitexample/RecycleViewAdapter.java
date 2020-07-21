package com.bogdan.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private Context context;
    private List<Book> bookList;
    private static OnItemClickListener onItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public RecycleViewAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        onItemClickListener = listener;
        bookList = new ArrayList<>();

    }

    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = bookList.get(position);
        // holder.bind(bookList.get(position), onItemClickListener);
        holder.textView_book_title.setText(book.getTitle());
        holder.textView_book_authors.setText((CharSequence) book.getAuthors());
        holder.textView_book_publishedDate.setText(book.getPublishedDate());
        holder.textView_book_pageCount.setText(book.getPageCount());
        holder.textView_book_rating.setText(book.getAverageRating());
        Glide.with(context)
                .load(book.getSmallThumbnail())
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
