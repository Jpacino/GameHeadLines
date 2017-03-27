package com.a15w.gameheadlines.bean;

/**
 * Created by Jpacino on 2016/9/18.
 */
public class ADBean {

    /**
     * code : 10000
     * message : success
     * data : {"dataId":"5604983921","cover":"http://files.15w.com/image/2016/0918/14741875912086.jpg","url":"http://m.15w.com/lol/yl/5605666105.html","beginTime":"1474171200","endTime":"1474344000"}
     */

    private int code;
    private String message;
    /**
     * dataId : 5604983921
     * cover : http://files.15w.com/image/2016/0918/14741875912086.jpg
     * url : http://m.15w.com/lol/yl/5605666105.html
     * beginTime : 1474171200
     * endTime : 1474344000
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String dataId;
        private String cover;
        private String url;
        private String beginTime;
        private String endTime;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }
}
