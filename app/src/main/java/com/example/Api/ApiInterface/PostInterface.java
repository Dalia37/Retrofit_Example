package com.example.Api.ApiInterface;

import com.example.Api.ApiModel.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public  Call<List<PostModel>> getPost();
}
