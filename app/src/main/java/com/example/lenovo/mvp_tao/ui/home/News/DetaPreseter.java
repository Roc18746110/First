package com.example.lenovo.mvp_tao.ui.home.News;

import com.example.lenovo.mvp_tao.bean.ListComment;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.userdata.UserDataSourc;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DetaPreseter implements NewsContract.DatePresenter {
    private NewsContract.DetaView mview;

    private UserDataSourc mUserDataRepository;

    public DetaPreseter(UserDataSourc mUserDataRepository) {
        this.mUserDataRepository = mUserDataRepository;
    }

    @Override
    public void detailsList(String userId, String newsId) {
        final HashMap<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("newsId", newsId);

        mUserDataRepository.DetaList(map, new Observer<Newsinfo>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Newsinfo newsinfo) {
                mview.detailsList(newsinfo);
            }

            @Override
            public void onError(Throwable e) {
                mview.details(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void RelevantList(String newsId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("newsId", newsId);
        mUserDataRepository.RelevantList(map, new Observer<ArrayList<Relevant>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Relevant> relevants) {
                mview.RelevantList(relevants);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void ListComment(String userId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId", userId);
        mUserDataRepository.ListComment(map, new Observer<ListComment>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ListComment listComment) {
                mview.ListComment(listComment);

            }

            @Override
            public void onError(Throwable e) {
                mview.details(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void Commrnt(String userId, String objectId, String objectType, String content) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId", "d56ea66e7ee741f498ca51242c8c6394");
        map.put("objectId", "d56ea66e7ee741f498ca51242c8c6394");
        map.put("objectType", "0");
        map.put("content", content);
        mUserDataRepository.Comment(map, new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                mview.Commentnext();

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


    @Override
    public void attachView(NewsContract.DetaView baseView) {
        mview = baseView;

    }

    @Override
    public void detachView() {
        mview = null;
    }
}
