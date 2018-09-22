package com.example.lenovo.mvp_tao.bean;

import java.util.List;

public class as {

    /**
     * code : 0
     * data : {"userCommentList":[{"commentId":"c00adfcc832d419e91d83dc6164a57a3","commentTime":"2018-09-18","content":"哈哈哈哈哈","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"79209c760e44476fbcdf56b5c57f50a8","commentTime":"2018-09-18","content":"按时发生大发","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"30d79d36964748c49a0c0a29885533dd","commentTime":"2018-09-18","content":"阿打算发送到发送到","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"5e690fad32be48aba736dd89cc183b94","commentTime":"2018-09-18","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"43388cbc684348928338ddd5e9e50439","commentTime":"2018-09-18","content":"测试","objectId":"0011adc699094f67b8b6ed8837173a7e","objectType":"0","title":"红钻航空以91部运行 业务升级助推多元化"},{"commentId":"4f5b09c6fbc944599436cb8ca63e473e","commentTime":"2018-09-18","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"6b6a41ac4aae4ddeab1383422023f450","commentTime":"2018-09-18","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"e17d30d2ca664e529abdcc02cd9a5e00","commentTime":"2018-09-17","content":"测试","objectId":"0011adc699094f67b8b6ed8837173a7e","objectType":"0","title":"红钻航空以91部运行 业务升级助推多元化"},{"commentId":"795da5f5bbff4e82ad8c3a0da6c9daa5","commentTime":"2018-09-17","content":"测试","objectId":"0011adc699094f67b8b6ed8837173a7e","objectType":"0","title":"红钻航空以91部运行 业务升级助推多元化"},{"commentId":"835f2e29ac2e49c4b722678dd335a129","commentTime":"2018-09-17","content":"测试","objectId":"0011adc699094f67b8b6ed8837173a7e","objectType":"0","title":"红钻航空以91部运行 业务升级助推多元化"},{"commentId":"5102eefab7ec4081b53bbc14ee9177e5","commentTime":"2018-09-17","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"fd342fdd236a4b06a26d5edf8c06b1cc","commentTime":"2018-09-13","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"3dcbea21ec4e406380ea645d21484991","commentTime":"2018-09-13","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"dde38746e17a4aeb942d7462ecaf2854","commentTime":"2018-09-11","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"f83e00841dda4541bc29e448f5a64442","commentTime":"2018-07-22","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"b427e83abf5e462ba29064f7b828cf8b","commentTime":"2018-07-22","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"ec6979853a604d84824fcb967799cb93","commentTime":"2018-07-22","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"9e28b030ab694b04a692fb229ea15c74","commentTime":"2018-07-22","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"a056c4e85bc04d9daa4bb3fc68ff2552","commentTime":"2018-07-20","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null},{"commentId":"3562e0a0928e40369bdbefcc9112d11c","commentTime":"2018-07-20","content":"测试","objectId":"d56ea66e7ee741f498ca51242c8c6394","objectType":"0","title":null}]}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<UserCommentListBean> userCommentList;

        public List<UserCommentListBean> getUserCommentList() {
            return userCommentList;
        }

        public void setUserCommentList(List<UserCommentListBean> userCommentList) {
            this.userCommentList = userCommentList;
        }

        public static class UserCommentListBean {
            /**
             * commentId : c00adfcc832d419e91d83dc6164a57a3
             * commentTime : 2018-09-18
             * content : 哈哈哈哈哈
             * objectId : d56ea66e7ee741f498ca51242c8c6394
             * objectType : 0
             * title : null
             */

            private String commentId;
            private String commentTime;
            private String content;
            private String objectId;
            private String objectType;
            private Object title;

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

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }
        }
    }
}
