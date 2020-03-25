package com.example.tpfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String API_BASE_URL = "https://restcountries.eu";
    private ArrayList<Product> products = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callWithAsyncTask(); callWithRetrofit();
    }

    private void callWithAsyncTask(){
//Some url endpoint that you may have
        String myUrl = API_BASE_URL + "/rest/v2/all";
//String to place our result in
        String result;
//Instantiate new instance of our class
        Request getRequest = new Request();
//Perform the doInBackground method, passing in our url
        try{
            result = getRequest.execute(myUrl).get();
        }catch (Exception e){
            Log.e("joyPAD","error in request " + e.getLocalizedMessage());
        } }
    private void callWithRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL) .addConverterFactory(GsonConverterFactory.create()) .build();
        Services service = retrofit.create(Services.class); Call<List<Product>> listProducts = service.getProducts(); listProducts.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products.addAll(response.body());
                Log.d("joyPAD","on a retrouvé " + products.size() + " produits"); }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) { }
        });
        Call<List<Product>> listProductsFromCat = service.getProducts(); listProductsFromCat.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d("joyPAD","Réponse requête produits de catégorie : " + response.toString());
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) { }
        }); }

}
