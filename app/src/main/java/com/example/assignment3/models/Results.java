
package com.example.assignment3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("results")
    @Expose
    private List<com.example.assignment3.models.Result> results = null;
    @SerializedName("info")
    @Expose
    private com.example.assignment3.models.Info info;

    public List<com.example.assignment3.models.Result> getResults() {
        return results;
    }

    public void setResults(List<com.example.assignment3.models.Result> results) {
        this.results = results;
    }

    public com.example.assignment3.models.Info getInfo() {
        return info;
    }

    public void setInfo(com.example.assignment3.models.Info info) {
        this.info = info;
    }

}
