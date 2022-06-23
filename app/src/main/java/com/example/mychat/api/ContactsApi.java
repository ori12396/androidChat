package com.example.mychat.api;

import com.example.mychat.MyApplication;
import com.example.mychat.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsApi {

    Retrofit retrofit;
    webApi webApi;

    public ContactsApi(){
        retrofit=new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webApi=retrofit.create(webApi.class);
    }

    public com.example.mychat.api.webApi getWebApi() {
        return webApi;
    }
}
