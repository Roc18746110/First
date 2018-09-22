package com.example.lenovo.mvp_tao.ui.home.News.MyAdapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.ui.home.News.NewsFraegments;

import java.util.ArrayList;

public class VpMyAdapter extends FragmentStatePagerAdapter {
    ArrayList<newsChannelList> title;

    public VpMyAdapter(FragmentManager fm,ArrayList<newsChannelList> title) {
        super(fm);
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        NewsFraegments newsFraegments = new NewsFraegments();
        Bundle bundle = new Bundle();
        bundle.putString("channelid",title.get(position).getChannelId());
        newsFraegments.setArguments(bundle);
        return newsFraegments;
    }

    @Override
    public int getCount() {
        return title.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position).getChannelName();
    }
}



