package com.example.mediaplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder> {

    private Context mContext;
    private List<Movie> mData;

    public MovieRecyclerViewAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.one_item , parent , false);

        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.title.setText(mData.get(position).getTitle());
        holder.director.setText(mData.get(position).getDirector());
        holder.runtime.setText(mData.get(position).getRuntime());
        holder.actors.setText(mData.get(position).getActors());

        Glide.with(mContext)
                .load(mData.get(position).getPoster())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title;
        TextView director;
        TextView runtime;
        TextView actors;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.im_movie_poster);
            title = itemView.findViewById(R.id.tv_movie_name);
            director = itemView.findViewById(R.id.tv_movie_name);
            runtime = itemView.findViewById(R.id.tv_movie_name);
            actors = itemView.findViewById(R.id.tv_movie_name);

        }
    }
}
