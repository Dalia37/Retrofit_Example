package com.example.UI.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Api.ApiModel.PostModel;
import com.example.retrofit.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    ArrayList<PostModel> posts = new ArrayList<>();


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.postrow, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.userId_tv.setText(posts.get(position).getUserId()+"");
        holder.bode_tv.setText(posts.get(position).getBody());
        holder.title_tv.setText(posts.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setList(ArrayList<PostModel> postModels) {
        this.posts =postModels;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView title_tv ,bode_tv , userId_tv ;

        public PostViewHolder(@NonNull View itemView) {

            super(itemView);
            title_tv=itemView.findViewById(R.id.title_tv);
            bode_tv=itemView.findViewById(R.id.body_tv);
            userId_tv=itemView.findViewById(R.id.userid_tv);
        }
    }
}
