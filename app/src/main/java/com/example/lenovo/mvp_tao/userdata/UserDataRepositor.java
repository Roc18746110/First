package com.example.lenovo.mvp_tao.userdata;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
import com.example.lenovo.mvp_tao.data.UserDataRepository;
import com.example.lenovo.mvp_tao.data.UserDataSource;
import com.example.lenovo.mvp_tao.data.UserRemoteDataSource;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.trello.rxlifecycle2.internal.Preconditions;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observer;

public class UserDataRepositor implements UserDataSourc {
    @NonNull
    private UserDataSourc mRemoteDataSour;

    @Nullable
    private static UserDataRepositor INSTANCE = null;

    private UserDataRepositor(@NonNull UserDataSourc remoteDataSource) {

        mRemoteDataSour = Preconditions.checkNotNull(remoteDataSource,"Login remote data source is not allowed null");

    }

    public static UserDataRepositor getInstance() {

        if (INSTANCE == null) {
            synchronized (UserDataRepositor.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDataRepositor(new UserRemoteDataSourc());
                }
            }
        }
        return INSTANCE;

    }

    @Override
    public void NewsChannel(RxFragment fragment, Map<String, String> map, Observer<NewsChannel> observable) {
        mRemoteDataSour.NewsChannel(fragment, map, observable);
    }

    @Override
    public void ListNews(RxFragment fragment, Map<String, String> map, Observer<DownListNews> observer) {
        mRemoteDataSour.ListNews(fragment, map, observer);
    }

    @Override
    public void DetaList( Map<String, String> map, Observer<Newsinfo> observer) {
        mRemoteDataSour.DetaList(map,observer);
    }

    @Override
    public void RelevantList(Map<String, String> map, Observer<ArrayList<Relevant>> observer) {
        mRemoteDataSour.RelevantList(map,observer);
    }

    @Override
    public void ListComment(Map<String, String> map, Observer<ListComment> observer) {
        mRemoteDataSour.ListComment(map,observer);
    }

    @Override
    public void Comment(Map<String, String> map, Observer<Object> observer) {
        mRemoteDataSour.Comment(map,observer);
    }


}
