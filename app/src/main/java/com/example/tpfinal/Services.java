package com.example.tpfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Services {

    @GET("/rest/v2/all")
    Call<List<Product>> getProducts();

}
