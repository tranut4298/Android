package com.example.test_20200424_version_100.Retrofit2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//---Khoi tao va cau hinh lai Ritrofit URL.
public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String baseurl){
        OkHttpClient builder = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS) //--Ngừng đọc
                .writeTimeout(5000,TimeUnit.MILLISECONDS)  //--Viet
                .connectTimeout(10000,TimeUnit.MILLISECONDS)  //--Ket noi lai
                .retryOnConnectionFailure(true) //--Khoi phuc ket noi
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(builder)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
