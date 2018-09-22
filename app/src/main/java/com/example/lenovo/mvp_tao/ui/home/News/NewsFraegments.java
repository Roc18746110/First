package com.example.lenovo.mvp_tao.ui.home.News;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseFragment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.data;
import com.example.lenovo.mvp_tao.bean.newListt;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.ui.home.News.MyAdapter.NewsMyAdapter;
import com.example.lenovo.mvp_tao.ui.home.News.details.DetailsActivity;
import com.example.lenovo.mvp_tao.userdata.UserDataRepositor;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;

public class NewsFraegments extends BaseFragment implements NewsContract.View, OnLoadmoreListener, OnRefreshLoadmoreListener {
    private String channelId;
    private NewsPresenter newsPresenter;
    private RecyclerView rv;
    private NewsMyAdapter adapter;
    private SmartRefreshLayout smartrefresh;
    ArrayList<DownListNews.newList> list = new ArrayList<>();
    private int position = 0;
    private int scorllY = 0;
    String corsor = 0 + "";
    private String load = 0 + "";

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        if (args != null) {
            channelId = args.getString("channelid");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
            scorllY = savedInstanceState.getInt("scrollY", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_fraegments, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        smartrefresh = view.findViewById(R.id.smartrefresh);

        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
            scorllY = savedInstanceState.getInt("scrollY", 0);
        }
        newsPresenter = new NewsPresenter(UserDataRepositor.getInstance());
        setPresenter(newsPresenter);
        newsPresenter.NewsUpListNews(channelId, corsor, "d56ea66e7ee741f498ca51242c8c6394\"");

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rv.getLayoutManager();
                if (linearLayoutManager != null) {
                    int fistVP = linearLayoutManager.findFirstVisibleItemPosition();
                    View v = linearLayoutManager.findViewByPosition(fistVP);
                    position = fistVP;
                    scorllY = v.getTop();
                }
            }
        });
        smartrefresh.setOnLoadmoreListener(this);
        smartrefresh.setOnRefreshLoadmoreListener(this);
        return view;
    }

    @Override
    public void getNewsChannelFail(String message) {

    }

    @Override
    public void getNewsChannelSuccess(ArrayList<newsChannelList> title) {

    }

    @Override
    public void getUpListNewsFail(String message) {

    }


    @Override
    public void getUpListNewsSuccess(DownListNews listt) {
        corsor = listt.getCursor();
        final ArrayList<DownListNews.newList> newList = listt.getNewList();
        list.addAll(newList);
        adapter = new NewsMyAdapter(list, getActivity());
        rv.setAdapter(adapter);
        scrollToTargetPosition();
        adapter.setSetOnkis(new NewsMyAdapter.setOnkis() {
            @Override
            public void Onkis(String newsId) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
//                intent.putExtra("type" , "newsFragmentDetails");
                intent.putExtra("newid",newsId);
                startActivity(intent);
            }
        });
    }


    private void scrollToTargetPosition() {
        if (position != 0 && scorllY != 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rv.getLayoutManager();
            linearLayoutManager.scrollToPositionWithOffset(position, scorllY);
        }
    }


    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        newsPresenter = (NewsPresenter) presenter;
        newsPresenter.attachView(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
        outState.putInt("scrollY", scorllY);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

        smartrefresh.finishLoadmore(3000);
        newsPresenter.NewsUpListNews(channelId, corsor, "d56ea66e7ee741f498ca51242c8c6394\"");

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        smartrefresh.finishRefresh(3000);
        newsPresenter.NewsUpListNews(channelId, corsor + "", "d56ea66e7ee741f498ca51242c8c6394\"");


    }
}