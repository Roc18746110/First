package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Newssearch {
    private String cursor;
    private ArrayList<DownListNews.newList> newList;

    @Override
    public String toString() {
        return "Newssearch{" +
                "cursor='" + cursor + '\'' +
                ", newList=" + newList +
                '}';
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public ArrayList<DownListNews.newList> getNewList() {
        return newList;
    }

    public void setNewList(ArrayList<DownListNews.newList> newList) {
        this.newList = newList;
    }
}
