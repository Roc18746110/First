package com.example.lenovo.mvp_tao.ui.home.News;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseFragment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.ui.home.News.MyAdapter.VpMyAdapter;
import com.example.lenovo.mvp_tao.userdata.UserDataRepositor;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment implements NewsContract.View {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private Button btn_add;
    private LinearLayout linearLayout2;
    private ViewPager viewpager;
    private NewsPresenter newsPresenter;
    private VpMyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        newsPresenter = new NewsPresenter(UserDataRepositor.getInstance());

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        btn_add = (Button) view.findViewById(R.id.btn_add);
        linearLayout2 = (LinearLayout) view.findViewById(R.id.linearLayout2);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        tablayout.setupWithViewPager(viewpager);

        return view;
    }

    @Override
    public void getNewsChannelFail(String message) {

    }

    @Override
    public void getNewsChannelSuccess(ArrayList<newsChannelList> title) {

        adapter = new VpMyAdapter(getChildFragmentManager(),title);
       viewpager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getUpListNewsFail(String message) {

    }

    @Override
    public void getUpListNewsSuccess(DownListNews listt) {

    }


    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        newsPresenter = (NewsPresenter) presenter;
        newsPresenter.attachView(this);
        newsPresenter.NewsChannel();
    }
}
