package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class UpListNews {
    private String maxCursor;
    private String minCursor;
    private int tops;
        private ArrayList<DownListNews.newList> newList;

    @Override
    public String toString() {
        return "UpListNews{" +
                "maxCursor='" + maxCursor + '\'' +
                ", minCursor='" + minCursor + '\'' +
                ", tops=" + tops +
                ", newList=" + newList +
                '}';
    }

    public String getMaxCursor() {
        return maxCursor;
    }

    public void setMaxCursor(String maxCursor) {
        this.maxCursor = maxCursor;
    }

    public String getMinCursor() {
        return minCursor;
    }

    public void setMinCursor(String minCursor) {
        this.minCursor = minCursor;
    }

    public int getTops() {
        return tops;
    }

    public void setTops(int tops) {
        this.tops = tops;
    }

    public ArrayList<DownListNews.newList> getNewList() {
        return newList;
    }

    public void setNewList(ArrayList<DownListNews.newList> newList) {
        this.newList = newList;
    }
}

