package com.example.restaurant;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class API {


    public static String baseUrl = "https://extendsclass.com/";

    //only once the instance of api is made
    public static DataService dataService = null;

    public static DataService getDataService()
    {
        if(dataService == null)
        {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            dataService = retrofit.create(DataService.class);

        }

        return dataService;
    }





    public interface DataService
    {

        @GET("api/json-storage/bin/deddffc")
        Call<Resource> getResource();


    }
}
