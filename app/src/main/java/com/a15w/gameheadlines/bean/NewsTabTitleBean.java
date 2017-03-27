package com.a15w.gameheadlines.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class NewsTabTitleBean {

    /**
     * code : 10000
     * message : success
     * data : {"list":[{"categoryId":"1","categoryName":"最头条"},{"categoryId":"11","categoryName":"看比赛"},{"categoryId":"12","categoryName":"八卦志"},{"categoryId":"13","categoryName":"原创团"},{"categoryId":"14","categoryName":"独家访谈"},{"categoryId":"15","categoryName":" 超神学院"},{"categoryId":"16","categoryName":"产业杂谈"},{"categoryId":"17","categoryName":"COSPLAY "}]}
     */

    private int code;
    private String message;
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
        /**
         * categoryId : 1
         * categoryName : 最头条
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String categoryId;
            private String categoryName;

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }
        }
    }
}
