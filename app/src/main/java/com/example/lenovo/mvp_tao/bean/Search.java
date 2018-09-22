package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Search {
    private ArrayList<com.example.lenovo.mvp_tao.bean.searchList> searchList;

    @Override
    public String toString() {
        return "Search{" +
                "searchList=" + searchList +
                '}';
    }

    public ArrayList<com.example.lenovo.mvp_tao.bean.searchList> getSearchList() {
        return searchList;
    }

    public void setSearchList(ArrayList<com.example.lenovo.mvp_tao.bean.searchList> searchList) {
        this.searchList = searchList;
    }
}

class searchList{
    private String content;
    private String searchId;

    @Override
    public String toString() {
        return "searchList{" +
                "content='" + content + '\'' +
                ", searchId='" + searchId + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }
}
