package com.bogdan.retrofitexample.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bogdan.retrofitexample.R;
import com.bogdan.retrofitexample.adapters.RecycleViewAdapter;
import com.bogdan.retrofitexample.api.APIDeclaration;
import com.bogdan.retrofitexample.api.RetrofitInstance;
import com.bogdan.retrofitexample.models.Book;
import com.bogdan.retrofitexample.models.ResponseBody;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText inputTitleBookEditText;
    private Button searchButton;
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;


    private final String langRestrict = "en";
    private final int maxResults = 10;
    private final String printType = "books";
    private final String key = "AIzaSyBaDCRK59AGwh2uFuHLbfzE4kjeCbZjtT4";
    APIDeclaration service = RetrofitInstance.getRetrofitInstance().create(APIDeclaration.class);
    RecycleViewAdapter.OnItemClickListener clickListener = book -> {
        String url = book.volumeInfo.infoLink;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    };


    private void setupView() {
        inputTitleBookEditText = findViewById(R.id.editText_input_book_title);
        searchButton = findViewById(R.id.button_search);
        recyclerView = findViewById(R.id.recycleView_book_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recycleViewAdapter = new RecycleViewAdapter(clickListener);
        recyclerView.setAdapter(recycleViewAdapter);
        searchButton.setOnClickListener(v -> service.getBooks(langRestrict, maxResults, printType, key, inputTitleBookEditText.getText().toString())
            .enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                    if (response.body() != null) {
                        Log.e("TEST", response.body().bookList.toString());
                        recycleViewAdapter.setData(response.body().bookList);

                    }

                    if (inputTitleBookEditText.getText().toString().equals("")) {
                        recycleViewAdapter.clear();
                    }


                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {


                    Log.e(MainActivity.class.getSimpleName(), "onFailure");
                    t.getMessage();
                }
            }));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupView();


    }
}