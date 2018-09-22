package com.example.lenovo.mvp_tao.ui.home.News.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;

import java.util.ArrayList;

public class DetaAdapter extends RecyclerView.Adapter<DetaAdapter.ViewHolder> {
    private ArrayList<Relevant> list;
    private Context context;

    public DetaAdapter(ArrayList<Relevant> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DetaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_xinwen_xiangguan, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Relevant newsinfo = list.get(position);
        holder.titel.setText(newsinfo.getTitle());
        holder.publishTime.setText(newsinfo.getPublishTime());
        Glide.with(context).load(newsinfo.getImageListThumb().get(0)).into(holder.img_one);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView titel;
        private final TextView publishTime;
        private final ImageView img_one;

        public ViewHolder(View itemView) {
            super(itemView);
            titel = itemView.findViewById(R.id.titile_one);
            publishTime = itemView.findViewById(R.id.textView14);
            img_one = itemView.findViewById(R.id.img_one);
        }
    }
}
