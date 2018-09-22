package com.example.lenovo.mvp_tao.ui.home.News;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseActivity;
import com.example.lenovo.mvp_tao.base.BasePresenter;
import com.example.lenovo.mvp_tao.base.BaseView;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.HttpResult;
import com.example.lenovo.mvp_tao.bean.Info;
import com.example.lenovo.mvp_tao.bean.ListComment;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.newsChannelList;


import java.util.ArrayList;

public interface NewsContract {


    public interface View extends BaseView<NewsContract.Presenter> {
        //titel标题
        void getNewsChannelFail(String message);

        void getNewsChannelSuccess(ArrayList<newsChannelList> title);

        //新闻数据值
        void getUpListNewsFail(String message);

        void getUpListNewsSuccess(DownListNews listt);

    }

    public interface Presenter extends BasePresenter<NewsContract.View> {
        void NewsChannel();

        void NewsUpListNews(String channelId, String cursor, String userId);

    }

    public interface DetaView extends BaseView<DatePresenter> {

        void details(String message);

        void detailsList(Newsinfo info);

        void RelevantList(ArrayList<Relevant> list);

        void ListComment(ListComment listComment);

        void  Comment(String message);

        void  Commentnext();

    }

    public interface DatePresenter extends BasePresenter<DetaView> {
        void detailsList(String userId, String newsId);

        void RelevantList(String newsId);

        void ListComment(String userId);

        void Commrnt(String userId,String objectId,String objectType,String content);

    }
}
