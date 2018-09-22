package com.example.lenovo.mvp_tao.ui.home.News;


import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.bean.newListt;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.userdata.UserDataSourc;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class NewsPresenter implements NewsContract.Presenter {
    private NewsContract.View mview;

    private UserDataSourc mUserDataRepository;

    public NewsPresenter(UserDataSourc mUserDataRepository) {
        this.mUserDataRepository = mUserDataRepository;
    }

       @Override
    public void attachView(NewsContract.View baseView) {

        mview = baseView;
    }

    @Override
    public void NewsChannel() {
        HashMap<String, String> map = new HashMap<>();
        mUserDataRepository.NewsChannel((RxFragment) mview, map, new Observer<NewsChannel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NewsChannel newsChannel) {
                ArrayList<newsChannelList> lists = newsChannel.getNewsChannelList();
                mview.getNewsChannelSuccess(lists);

            }

            @Override
            public void onError(Throwable e) {
                mview.getNewsChannelFail(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void NewsUpListNews(String channelId, String cursor, String userId) {
        HashMap<String, String> map = new HashMap<>();//"d56ea66e7ee741f498ca51242c8c6394"
        map.put("userId", userId);
        map.put("channelId", channelId);
        map.put("cursor", cursor);


        mUserDataRepository.ListNews((RxFragment) mview, map, new Observer<DownListNews>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DownListNews downListNews) {
//                ArrayList<DownListNews.newList> newList = downListNews.getNewList();
                mview.getUpListNewsSuccess(downListNews);
            }
            @Override
            public void onError(Throwable e) {
                mview.getNewsChannelFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void detachView() {
        mview = null;


    }
}
