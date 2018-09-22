package com.example.lenovo.mvp_tao.bean;

import java.util.ArrayList;

public class ListComment {
    private ArrayList<UserCommentListBean> userCommentList;

    public ListComment(ArrayList<UserCommentListBean> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public ArrayList<UserCommentListBean> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(ArrayList<UserCommentListBean> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public ListComment() {
        super();
    }

    @Override
    public String toString() {
        return "ListComment{" +
                "userCommentList=" + userCommentList +
                '}';
    }

    public static class UserCommentListBean {


        private String commentId;
        private String commentTime;
        private String content;
        private String objectId;
        private String objectType;
        private String title;

        public UserCommentListBean() {
            super();
        }

        @Override
        public String toString() {
            return "UserCommentListBean{" +
                    "commentId='" + commentId + '\'' +
                    ", commentTime='" + commentTime + '\'' +
                    ", content='" + content + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", objectType='" + objectType + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getObjectType() {
            return objectType;
        }

        public void setObjectType(String objectType) {
            this.objectType = objectType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public UserCommentListBean(String commentId, String commentTime, String content, String objectId, String objectType, String title) {

            this.commentId = commentId;
            this.commentTime = commentTime;
            this.content = content;
            this.objectId = objectId;
            this.objectType = objectType;
            this.title = title;
        }
    }
}
