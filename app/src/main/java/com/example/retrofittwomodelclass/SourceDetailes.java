package com.example.retrofittwomodelclass;

public class SourceDetailes {
    private String primeMinister;
    private  String population ;

    public SourceDetailes(String primeMinister, String population) {
        this.primeMinister = primeMinister;
        this.population = population;
    }

    public String getPrimeMinister() {
        return primeMinister;
    }

    public void setPrimeMinister(String primeMinister) {
        this.primeMinister = primeMinister;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
