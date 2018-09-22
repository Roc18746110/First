package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class Relevants {
    private int code;
    private String message;
    private ArrayList<Data> data;


    public Relevants(int code, String message, ArrayList<Data> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Relevants() {
        super();
    }

    @Override
    public String toString() {
        return "Relevants{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    class Data {
        private int pageviews;
        private ArrayList<String> imageListThumb;
        private String layoutType;
        private String newsId;
        private String origin;
        private String publishTime;
        private String title;

        @Override
        public String toString() {
            return "Relevant{" +
                    "pageviews=" + pageviews +
                    ", imageListThumb=" + imageListThumb +
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


