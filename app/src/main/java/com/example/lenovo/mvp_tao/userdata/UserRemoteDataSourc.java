package com.example.lenovo.mvp_tao.userdata;

import android.arch.lifecycle.LifecycleObserver;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
import com.example.lenovo.mvp_tao.data.soure.ServerException;
import com.example.lenovo.mvp_tao.retrofit.Apiservice;
import com.example.lenovo.mvp_tao.retrofit.DataRetrofit;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRemoteDataSourc implements UserDataSourc {
    private Apiservice apiservice;

    public UserRemoteDataSourc() {
        apiservice = DataRetrofit.getRetrofit();
    }


    @Override
    public void NewsChannel(RxFragment fragment, Map<String, String> map, Observer<NewsChannel> observable) {
        Observable<HttpResult<NewsChannel>> channel = apiservice.listNewsChannel();
        Log.e("UserRemoteDataSource", map.toString());
        channel.flatMap(new Function<HttpResult<NewsChannel>, ObservableSource<NewsChannel>>() {
            @Override
            public ObservableSource<NewsChannel> apply(HttpResult<NewsChannel> userHttpResult) throws Exception {

                if (userHttpResult.getCode() == 0) {
                    return Observable.just(userHttpResult.getData());
                }
                return Observable.error(new ServerException(userHttpResult.getCode(), userHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);
    }

    @Override
    public void ListNews(RxFragment fragment, Map<String, String> map, Observer<DownListNews> observer) {
        Observable<HttpResult<DownListNews>> observable = apiservice.upListNews(map);
        observable.flatMap(new Function<HttpResult<DownListNews>, ObservableSource<DownListNews>>() {
            @Override
            public ObservableSource<DownListNews> apply(HttpResult<DownListNews> upListNewsHttpResult) throws Exception {
                if (upListNewsHttpResult.getCode() == 0) {
                    return Observable.just(upListNewsHttpResult.getData());
                }
                return Observable.error(new ServerException(upListNewsHttpResult.getCode(), upListNewsHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.<DownListNews>bindUntilEvent(FragmentEvent.DETACH))
                .subscribe(observer);
    }

    @Override
    public void DetaList(Map<String, String> map, Observer<Newsinfo> observer) {

        Observable<HttpResult<Newsinfo>> observable = apiservice.fetchNewsDetail(map);
        observable.flatMap(new Function<HttpResult<Newsinfo>, ObservableSource<Newsinfo>>() {
            @Override
            public ObservableSource<Newsinfo> apply(HttpResult<Newsinfo> newsinfoHttpResult) throws Exception {
                if (newsinfoHttpResult != null) {
                    return Observable.just(newsinfoHttpResult.getData());
                }
                return Observable.error(new ServerException(newsinfoHttpResult.getCode(), newsinfoHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .compose(<Newsinfo>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(observer);
    }

    @Override
    public void RelevantList(Map<String, String> map, Observer<ArrayList<Relevant>> observer) {
        Observable<HttpResult<ArrayList<Relevant>>> observable = apiservice.relevant(map);
        observable.flatMap(new Function<HttpResult<ArrayList<Relevant>>, ObservableSource<ArrayList<Relevant>>>() {
            @Override
            public ObservableSource<ArrayList<Relevant>> apply(HttpResult<ArrayList<Relevant>> relevantHttpResult) throws Exception {
                if (relevantHttpResult.getCode() == 0) {

                    return Observable.just(relevantHttpResult.getData());
                }
                return Observable.error(new ServerException(relevantHttpResult.getCode(), relevantHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void ListComment(Map<String, String> map, Observer<ListComment> observer) {
        Observable<HttpResult<ListComment>> observable = apiservice.listComment(map);
        observable.flatMap(new Function<HttpResult<ListComment>, ObservableSource<ListComment>>() {
            @Override
            public ObservableSource<ListComment> apply(HttpResult<ListComment> listCommentHttpResult) throws Exception {
                if (listCommentHttpResult.getCode() == 0) {
                    return Observable.just(listCommentHttpResult.getData());
                }
                return Observable.error(new ServerException(listCommentHttpResult.getCode(), listCommentHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void Comment(Map<String, String> map, Observer<Object> observer) {
        Observable<HttpResult<Object>> comment = apiservice.comment(map);
        comment.flatMap(new Function<HttpResult<Object>, ObservableSource<Object>>() {
            @Override
            public ObservableSource<Object> apply(HttpResult<Object> objectHttpResult) throws Exception {
                if (objectHttpResult.getCode() == 0) {
                    return Observable.just(new Object());
                }
                return Observable.error(new ServerException(objectHttpResult.getCode(), objectHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


}


