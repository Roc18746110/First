package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class NewsChannel {
    private ArrayList<com.example.lenovo.mvp_tao.bean.newsChannelList> newsChannelList;

    @Override
    public String toString() {
        return "NewsChannel{" +
                "newsChannelList=" + newsChannelList +
                '}';
    }

    public ArrayList<com.example.lenovo.mvp_tao.bean.newsChannelList> getNewsChannelList() {
        return newsChannelList;
    }

    public void setNewsChannelList(ArrayList<com.example.lenovo.mvp_tao.bean.newsChannelList> newsChannelList) {
        this.newsChannelList = newsChannelList;
    }
}

