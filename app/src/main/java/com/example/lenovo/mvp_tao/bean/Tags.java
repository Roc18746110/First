package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Tags {
    private ArrayList<com.example.lenovo.mvp_tao.bean.tagList> tagList;

    @Override
    public String toString() {
        return "Tags{" +
                "tagList=" + tagList +
                '}';
    }

    public ArrayList<com.example.lenovo.mvp_tao.bean.tagList> getTagList() {
        return tagList;
    }

    public void setTagList(ArrayList<com.example.lenovo.mvp_tao.bean.tagList> tagList) {
        this.tagList = tagList;
    }
}

class tagList{
    private String id;
    private String tag;

    @Override
    public String toString() {
        return "tagList{" +
                "id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
