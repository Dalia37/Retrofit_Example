package com.example.UI.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.retrofit.R;



public class LoadImageActivity extends AppCompatActivity {

    ImageView firstimage , secondimage ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        firstimage = findViewById(R.id.firstimage);
        secondimage=findViewById(R.id.secondimage);

        Glide.with(this).load("https://i.imgur.com/pSHXfu5.jpg")
                .placeholder(R.drawable.progressbar)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(firstimage);



        Glide.with(this).load("https://i.imgur.com/GJr9SwK.gif")
                .placeholder(R.drawable.progressbar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(secondimage);






    }

}
