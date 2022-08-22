package com.example.retrofittwomodelclass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponce {
    @SerializedName("countries")
    @Expose
    private List<Countrymodel> countrymodelList;

    public List<Countrymodel> getArticlesModelList() {
        return countrymodelList;
    }

    public void setArticlesModelList(List<Countrymodel> articlesModelList) {
        this.countrymodelList = countrymodelList;
    }
}