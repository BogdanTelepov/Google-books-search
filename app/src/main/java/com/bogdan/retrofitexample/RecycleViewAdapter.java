package com.bogdan.retrofitexample;

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

    private List<Book> bookList;
    private static OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public RecycleViewAdapter(OnItemClickListener listener) {
        mListener = listener;
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
        holder.bookTitleTextView.setText(book.getTitle());
        holder.bookAuthorTextView.setText((CharSequence) book.getAuthors());
        holder.bookPublisherTextView.setText(book.getPublishedDate());
        holder.bookAverageRating.setText(book.getAverageRating());
        holder.bookPageCount.setText(book.getPageCount());
        Glide.with(holder.bookThumbnailImageView.getContext()).load(book.getSmallThumbnail()).into(holder.bookThumbnailImageView);

        holder.bind(bookList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bookThumbnailImageView;
        TextView bookTitleTextView;
        TextView bookAuthorTextView;
        TextView bookPublisherTextView;
        TextView bookPageCount;
        TextView bookAverageRating;

        public ViewHolder(View itemView) {
            super(itemView);
            bookThumbnailImageView = itemView.findViewById(R.id.cover_book_image_view);
            bookTitleTextView = itemView.findViewById(R.id.book_title_text_view);
            bookAuthorTextView = itemView.findViewById(R.id.book_author_text_view);
            bookPublisherTextView = itemView.findViewById(R.id.book_date_text_view);
            bookPageCount = itemView.findViewById(R.id.book_number_pages_text_view);
            bookAverageRating = itemView.findViewById(R.id.book_rating_text_view);

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
