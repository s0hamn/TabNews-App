package com.example.tabnews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<News> newsItems;
    private Context context;

    public MyAdapter(List<News> newsItems, Context context) {
        this.newsItems = newsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News newsItem = newsItems.get(position);
        holder.newsTitle.setText(newsItem.getTitle());
        holder.newsAuthor.setText(newsItem.getAuthor());

        //loading Image
        Glide.with(context).load(newsItem.getImageUrl()).into(holder.newsImage);

        //loading url
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = newsItem.getUrl();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent i = builder.build();
                i.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.launchUrl(context, Uri.parse(url));

            }
        });


    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView newsTitle;
        public TextView newsAuthor;
        public ImageView newsImage;
        public LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsAuthor = itemView.findViewById(R.id.newsAuthor);
            newsImage = itemView.findViewById(R.id.newsImage);
            linearLayout = itemView.findViewById(R.id.linearLayout);


        }
    }
}

