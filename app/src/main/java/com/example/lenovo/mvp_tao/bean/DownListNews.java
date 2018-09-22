package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class DownListNews {
    private String cursor;
    private ArrayList<newList> newList;

    @Override
    public String toString() {
        return "DownListNews{" +
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

    public ArrayList<newList> getNewList() {
        return newList;
    }

    public void setNewList(ArrayList<newList> newList) {
        this.newList = newList;
    }
    public static class newList {
        private int pageviews;
        private ArrayList<String> imageListThumb;
        private int isTop;
        private String layoutType;
        private String newsId;
        private String origin;
        private String publishTime;
        private String title;

        public newList(int pageviews, ArrayList<String> imageListThumb, int isTop, String layoutType, String newsId, String origin, String publishTime, String title) {
            this.pageviews = pageviews;
            this.imageListThumb = imageListThumb;
            this.isTop = isTop;
            this.layoutType = layoutType;
            this.newsId = newsId;
            this.origin = origin;
            this.publishTime = publishTime;
            this.title = title;
        }

        @Override
        public String toString() {
            return "newList{" +
                    "pageviews=" + pageviews +
                    ", imageListThumb=" + imageListThumb +
                    ", isTop=" + isTop +
                    ", layoutType='" + layoutType + '\'' +
                    ", newsId='" + newsId + '\'' +
                    ", origin='" + origin + '\'' +
                    ", publishTime='" + publishTime + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        public int getPageviews() {
            return pageviews;
        }

        public void setPageviews(int pageviews) {
            this.pageviews = pageviews;
        }

        public ArrayList<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(ArrayList<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }

        public int getIsTop() {
            return isTop;
        }

        public void setIsTop(int isTop) {
            this.isTop = isTop;
        }

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
        }

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}