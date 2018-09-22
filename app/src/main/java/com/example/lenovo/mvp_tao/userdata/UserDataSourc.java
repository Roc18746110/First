package com.example.lenovo.mvp_tao.userdata;

import android.arch.lifecycle.LifecycleObserver;

import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.HttpResult;
import com.example.lenovo.mvp_tao.bean.Info;
import com.example.lenovo.mvp_tao.bean.ListComment;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.Relevants;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.bean.data;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.Observer;

import java.util.ArrayList;
import java.util.Map;

public interface UserDataSourc {
    void NewsChannel(RxFragment fragment, Map<String, String> map, Observer<NewsChannel> observable);

    void ListNews(RxFragment fragment, Map<String, String> map, Observer<DownListNews> observer);

    void DetaList(Map<String, String> map, Observer<Newsinfo> observer);

    void RelevantList(Map<String, String> map, Observer<ArrayList<Relevant>> observer);

    void ListComment(Map<String, String> map, Observer<ListComment> observer);

    void Comment(Map<String, String> map, Observer<Object> observer);


}
