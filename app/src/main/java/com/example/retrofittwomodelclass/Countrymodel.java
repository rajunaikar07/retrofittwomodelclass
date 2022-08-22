package com.example.retrofittwomodelclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Countrymodel {
    private String countryName;
    private String url;
    private String capital;

    @SerializedName("Details")
    @Expose
    private DetailsModel detailsModel;

    public Countrymodel(String countryName, String url, String capital, DetailsModel detailsModel) {
        this.countryName = countryName;
        this.url = url;
        this.capital = capital;
        this.detailsModel = detailsModel;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public DetailsModel getDetailsModel() {
        return detailsModel;
    }

    public void setDetailsModel(DetailsModel detailsModel) {
        this.detailsModel = detailsModel;
    }
}

