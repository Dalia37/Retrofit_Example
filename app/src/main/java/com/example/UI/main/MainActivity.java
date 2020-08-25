package com.example.UI.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.Api.ApiModel.PostModel;
import com.example.UI.Adapter.PostAdapter;
import com.example.retrofit.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv ;
    PostViewModel postViewModel ;
    PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPost();

         adapter= new PostAdapter();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList((ArrayList<PostModel>) postModels);
            }
        });

    }

    public void loading(View view) {
        Intent intent = new Intent(this,LoadImageActivity.class);
        startActivity(intent);
    }
}
