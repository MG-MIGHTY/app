package com.example.adrien.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //log tag
    public static final String TAG = MainActivity.class.getName();
    //the base url
    public static final String BASE_URL = "https://www.googleapis.com/customsearch/";
    //the search engine key
    public static final String key = "AIzaSyBohPSZWgCh38nyoUfVVUePDqSU5F6xP6I";
    //The search engine cx
    public static final String cx = "012545668914672962087:avtjfh2hrg0";

    private RecyclerView recyclerView;
    private final RecyclerViewAdapter adapter = new RecyclerViewAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //Take back the data sent by the first activity
        String str;
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("edittext")){
            //Take the value stored into the extra and replace all the spaces by '+' in the string
            str = intent.getStringExtra("edittext").replaceAll(" ", "+");
            }else{
                str = "error";
            }

        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        APIService service = retrofit.create(APIService.class);
        Call<items> call =  service.getItems(str, key, cx, "image", "json");

        //show the URL being called to verify that it is correct
        Log.d(TAG, call.request().url().toString());

        //making the call
        call.enqueue(new Callback<items>() {
            @Override
            public void onResponse(Call<items> call, Response<items> response) {
                ArrayList<Photo> photos = response.body().getPhotos();
                Log.d(TAG, "Loaded " + photos.size() + " photo(s)");
                adapter.setPhotos(photos);
            }

            @Override
            public void onFailure(Call<items> call, Throwable t) {
                Log.e(TAG, "Could not load images", t);
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        //Button Back
        final Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Search.class);
                startActivity(intent);
            }
        });
    }


}