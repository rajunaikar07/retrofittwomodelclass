package com.example.retrofittwomodelclass;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Countrymodel countrymodel;
    JsonAdapter jsonAdapter;
    List<Countrymodel> countrymodelList = new ArrayList<>();
    Retrofit retrofit;
    MyApi myApi;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit = new Retrofit.Builder().baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi =retrofit.create(MyApi.class);

        jsonAdapter = new JsonAdapter(this,countrymodelList);
        recyclerView.setAdapter(jsonAdapter);

        loadData();

    }

    private void loadData() {

        Call<JsonResponce> call = myApi.getResponseList();
        call.enqueue(new Callback<JsonResponce>() {
            @Override
            public void onResponse(Call<JsonResponce> call, Response<JsonResponce> response) {
                progressDialog.dismiss();

                if(response.code()!=200)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<Countrymodel> countrymodelList1=response.body().getArticlesModelList();

                    for(Countrymodel countrymodel1:countrymodelList1)
                    {
                        String countryname1=countrymodel1.getCountryName();
                        String image1=countrymodel1.getUrl();
                        String capital=countrymodel1.getCapital();




                       DetailsModel detailsModel = new DetailsModel(countrymodel1.getDetailsModel().getPrimeMinister(),countrymodel1.getDetailsModel().getPopulation());

//                        articlesModel = new ArticlesModel(title1,desc,image1,publishAt1,sourceDetails);

//                        String image1=articlesModel1.getUrlToImage();
//                        SourceDetails sourceDetails = new SourceDetails(articlesModel1.getSourceDetails().getName());

                        countrymodel = new Countrymodel(countryname1,image1,capital,detailsModel);
                        countrymodelList.add(countrymodel);
                        jsonAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponce> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}