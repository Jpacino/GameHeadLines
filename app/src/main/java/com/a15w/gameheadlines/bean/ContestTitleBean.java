package com.a15w.gameheadlines.bean;

import java.util.List;

/**
 * Created by Jpacino on 2016/9/6.
 */
public class ContestTitleBean {

    /**
     * code : 10000
     * message : success
     * data : {"list":[{"categoryId":"25","categoryName":"2016LPL夏季赛"},{"categoryId":"27","categoryName":"2016德玛西亚杯"},{"categoryId":"26","categoryName":"2016LSPL夏季赛"},{"categoryId":"8","categoryName":"2016季中赛"},{"categoryId":"9","categoryName":"2016LPL春季赛"},{"categoryId":"20","categoryName":" 2016LSPL春季赛 "}]}
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
         * categoryId : 25
         * categoryName : 2016LPL夏季赛
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
