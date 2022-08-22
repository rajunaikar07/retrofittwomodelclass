package com.example.retrofittwomodelclass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("bdf59288-5046-463d-8fb8-1eb94173ad02")
    Call<JsonResponce> getResponseList();


    }

//    https://run.mocky.io/v3/bdf59288-5046-463d-8fb8-1eb94173ad02
