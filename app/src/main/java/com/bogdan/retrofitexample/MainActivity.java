package com.bogdan.retrofitexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText inputTitleBookEditText;
    private Button searchButton;
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;


    private final String langRestrict = "en";
    private final int maxResults = 40;
    private final String printType = "books";
    private final String key = "AIzaSyBaDCRK59AGwh2uFuHLbfzE4kjeCbZjtT4";
    APIDeclaration service = RetrofitInstance.getRetrofitInstance().create(APIDeclaration.class);
    RecycleViewAdapter.OnItemClickListener clickListener = new RecycleViewAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Book book) {
            String url = book.getInfoLink();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        inputTitleBookEditText = findViewById(R.id.book_input_search_editText);
        searchButton = findViewById(R.id.button_search);
        recyclerView = findViewById(R.id.rv_book_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recycleViewAdapter = new RecycleViewAdapter(clickListener);
        recyclerView.setAdapter(recycleViewAdapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getBooks(langRestrict, maxResults, printType, key, inputTitleBookEditText.getText().toString())
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                                if (response.body() != null) {
                                    Log.e("TEST", String.valueOf(response.body().bookList.size()));
                                    recycleViewAdapter.setData(response.body().bookList);
                                }


                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.e(MainActivity.class.getSimpleName(), "onFailure");
                                t.getMessage();
                            }
                        });
            }
        });


    }
}