package com.example.Api;

import com.example.Api.ApiInterface.PostInterface;
import com.example.Api.ApiModel.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface ;
    private static ApiClient Instance ;

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface =retrofit.create(PostInterface.class);



    }

    public static ApiClient getInstance() {
        if (Instance == null){
            Instance=new ApiClient();
        }
        return Instance;
    }

    public Call<List<PostModel>> getPosts (){
        return postInterface.getPost();
    }
}
