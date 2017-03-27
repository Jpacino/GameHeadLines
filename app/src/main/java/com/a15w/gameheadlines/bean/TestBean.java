package com.a15w.gameheadlines.bean;

import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.http.HTTP;

/**
 * Created by Jpacino on 2016/10/18.
 */
public class TestBean {


    /**
     * code : 0
     * data : [{"activityContent":"一起健步走","activityNo":"2","activityPlace":"南京市秦淮区投资大厦","activityTheme":"健步走","clubName":"俱乐部（一）","clubNo":"1","createTime":1487155705000,"endTime":"2017-02-25 18:48:17","enrollment":"300","flag":0,"integral":"1","joinState":"0","lng_lat":"32.028987,118.787204","signEndTime":"2017-02-25 18:48:22","signStartTime":"2017-02-15 18:48:20","startTime":"2017-02-15 18:48:16","stopTime":"2017-02-25 18:48:18"}]
     * reason : 查询成功
     */

    private String code;
    private String reason;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * activityContent : 一起健步走
         * activityNo : 2
         * activityPlace : 南京市秦淮区投资大厦
         * activityTheme : 健步走
         * clubName : 俱乐部（一）
         * clubNo : 1
         * createTime : 1487155705000
         * endTime : 2017-02-25 18:48:17
         * enrollment : 300
         * flag : 0
         * integral : 1
         * joinState : 0
         * lng_lat : 32.028987,118.787204
         * signEndTime : 2017-02-25 18:48:22
         * signStartTime : 2017-02-15 18:48:20
         * startTime : 2017-02-15 18:48:16
         * stopTime : 2017-02-25 18:48:18
         */

        private String activityContent;
        private String activityNo;
        private String activityPlace;
        private String activityTheme;
        private String clubName;
        private String clubNo;
        private long createTime;
        private String endTime;
        private String enrollment;
        private int flag;
        private String integral;
        private String joinState;
        private String lng_lat;
        private String signEndTime;
        private String signStartTime;
        private String startTime;
        private String stopTime;
        public String getActivityContent() {
            return activityContent;
        }

        public void setActivityContent(String activityContent) {
            this.activityContent = activityContent;
        }

        public String getActivityNo() {
            return activityNo;
        }

        public void setActivityNo(String activityNo) {
            this.activityNo = activityNo;
        }

        public String getActivityPlace() {
            return activityPlace;
        }

        public void setActivityPlace(String activityPlace) {
            this.activityPlace = activityPlace;
        }

        public String getActivityTheme() {
            return activityTheme;
        }

        public void setActivityTheme(String activityTheme) {
            this.activityTheme = activityTheme;
        }

        public String getClubName() {
            return clubName;
        }

        public void setClubName(String clubName) {
            this.clubName = clubName;
        }

        public String getClubNo() {
            return clubNo;
        }

        public void setClubNo(String clubNo) {
            this.clubNo = clubNo;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getEnrollment() {
            return enrollment;
        }

        public void setEnrollment(String enrollment) {
            this.enrollment = enrollment;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getJoinState() {
            return joinState;
        }

        public void setJoinState(String joinState) {
            this.joinState = joinState;
        }

        public String getLng_lat() {
            return lng_lat;
        }

        public void setLng_lat(String lng_lat) {
            this.lng_lat = lng_lat;
        }

        public String getSignEndTime() {
            return signEndTime;
        }

        public void setSignEndTime(String signEndTime) {
            this.signEndTime = signEndTime;
        }

        public String getSignStartTime() {
            return signStartTime;
        }

        public void setSignStartTime(String signStartTime) {
            this.signStartTime = signStartTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStopTime() {
            return stopTime;
        }

        public void setStopTime(String stopTime) {
            this.stopTime = stopTime;
        }
    }
}
