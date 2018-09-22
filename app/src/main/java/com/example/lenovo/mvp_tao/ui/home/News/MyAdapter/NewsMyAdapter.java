package com.example.lenovo.mvp_tao.ui.home.News.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.bean.DownListNews;

import java.util.ArrayList;

public class NewsMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<DownListNews.newList> list;
    private Context context;

    public NewsMyAdapter(ArrayList<DownListNews.newList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<DownListNews.newList> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.news_item_zero, null);
            return new ViewHolder0(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.news_item_one, null);
            return new ViewHolder1(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.news_item_two, null);
            return new ViewHolder2(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.news_item_three, null);
            return new ViewHolder3(view);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DownListNews.newList newList = list.get(position);
        if (holder instanceof ViewHolder0) {
            ((ViewHolder0) holder).title.setText(newList.getTitle());
            ((ViewHolder0) holder).tv1.setText(newList.getOrigin());
            ((ViewHolder0) holder).tv2.setText(newList.getPageviews() + "");
            ((ViewHolder0) holder).tv3.setText(newList.getPublishTime());
        } else if (holder instanceof ViewHolder1) {

            ((ViewHolder1) holder).titile_one.setText(newList.getTitle());
            ((ViewHolder1) holder).origin_one.setText(newList.getOrigin());
            ((ViewHolder1) holder).pageviews_one.setText(newList.getPageviews() + "");
            ((ViewHolder1) holder).time_one.setText(newList.getPublishTime());
            Glide.with(context).load(newList.getImageListThumb().get(0)).into(((ViewHolder1) holder).img_one);

        } else if (holder instanceof ViewHolder2) {
            ((ViewHolder2) holder).title_two.setText(newList.getTitle());
            ((ViewHolder2) holder).origin_two.setText(newList.getOrigin());
            ((ViewHolder2) holder).pageviews_two.setText(newList.getPageviews() + "");
            ((ViewHolder2) holder).time_two.setText(newList.getPublishTime());
            Glide.with(context).load(newList.getImageListThumb().get(0)).into(((ViewHolder2) holder).img_two);
        } else {
            ((ViewHolder3) holder).title_three.setText(newList.getTitle());
            ((ViewHolder3) holder).origin_three.setText(newList.getOrigin());
            ((ViewHolder3) holder).pageviews_three.setText(newList.getPageviews() + "");
            ((ViewHolder3) holder).time_three.setText(newList.getPublishTime());
            Glide.with(context).load(newList.getImageListThumb().get(0)).into(((ViewHolder3) holder).three_img_left);
            Glide.with(context).load(newList.getImageListThumb().get(1)).into(((ViewHolder3) holder).three_img_center);
            Glide.with(context).load(newList.getImageListThumb().get(2)).into(((ViewHolder3) holder).three_img_right);
        }
        final String newsId = newList.getNewsId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              setOnkis.Onkis(newsId);
          }
      });
    }

    @Override
    public int getItemViewType(int position) {
        DownListNews.newList newList = list.get(position);
//        String type = newList.getLayoutType();
        if (newList.getLayoutType().equals("0")) {
            return 0;
        } else if (newList.getLayoutType().equals("1")) {
            return 1;
        } else if (newList.getLayoutType().equals("2")) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder0 extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final ImageView stick;

        public ViewHolder0(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            stick = itemView.findViewById(R.id.stick);
        }
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView titile_one;
        private final ImageView img_one;
        private final ImageView istop_one;
        private final TextView origin_one;
        private final TextView pageviews_one;
        private final TextView time_one;
        private final ImageView pinbi_one;

        public ViewHolder1(View itemView) {
            super(itemView);
            titile_one = itemView.findViewById(R.id.titile_one);
            img_one = itemView.findViewById(R.id.img_one);
            istop_one = itemView.findViewById(R.id.istop_one);
            origin_one = itemView.findViewById(R.id.origin_one);
            pageviews_one = itemView.findViewById(R.id.pageviews_one);
            time_one = itemView.findViewById(R.id.time_one);
            pinbi_one = itemView.findViewById(R.id.pinbi_one);

        }
    }

    static class ViewHolder3 extends RecyclerView.ViewHolder {

        private final TextView title_three;
        private final ImageView three_img_left;
        private final ImageView three_img_center;
        private final ImageView three_img_right;
        private final ImageView istop_three;
        private final ImageView pinbi_three;
        private final TextView origin_three;
        private final TextView pageviews_three;
        private final TextView time_three;

        public ViewHolder3(View itemView) {
            super(itemView);
            title_three = itemView.findViewById(R.id.title_three);
            three_img_left = itemView.findViewById(R.id.three_img_left);
            three_img_center = itemView.findViewById(R.id.three_img_center);
            three_img_right = itemView.findViewById(R.id.three_img_right);
            istop_three = itemView.findViewById(R.id.istop_three);
            pinbi_three = itemView.findViewById(R.id.pinbi_three);
            origin_three = itemView.findViewById(R.id.origin_three);
            pageviews_three = itemView.findViewById(R.id.pageviews_three);
            time_three = itemView.findViewById(R.id.time_three);


        }
    }

    static class ViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView title_two;
        private final ImageView img_two;
        private final ImageView istop_two;
        private final TextView origin_two;
        private final TextView pageviews_two;
        private final TextView time_two;
        private final ImageView pinbi_two;

        public ViewHolder2(View itemView) {
            super(itemView);
            title_two = itemView.findViewById(R.id.title_two);
            img_two = itemView.findViewById(R.id.img_two);
            istop_two = itemView.findViewById(R.id.istop_two);
            origin_two = itemView.findViewById(R.id.origin_two);
            pageviews_two = itemView.findViewById(R.id.pageviews_two);
            time_two = itemView.findViewById(R.id.time_two);
            pinbi_two = itemView.findViewById(R.id.pinbi_two);

        }

    }
    setOnkis setOnkis;

    public void setSetOnkis(NewsMyAdapter.setOnkis setOnkis) {
        this.setOnkis = setOnkis;
    }

    public interface setOnkis {
        void Onkis(String newsId);
    }




}