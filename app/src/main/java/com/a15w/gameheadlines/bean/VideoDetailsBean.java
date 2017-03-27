package com.a15w.gameheadlines.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public class VideoDetailsBean {

    /**
     * code : 10000
     * message : success
     * data : {"title":"青铜5最怕的英雄！没有任何套路？见面就干","author":"baTT","thumbnail":"http://files.15w.com/image/2016/0905/14730703011869.jpg","excerpt":"LOL青铜5最怕的英雄！没有任何套路？见面就是干！","shareUrl":"http://m.15w.com/lol/jc/5605658885.html","changyanSid":"3/33750","time":"09-05 18:11","content":"<iframe allowfullscreen=\"\" frameborder=\"0\" height=\"100%\" width=\"100%\" src=\"http://v.qq.com/iframe/player.html?vid=j0325tda7q2&tiny=0&auto=1\"><\/iframe>","views":"1510播放","videoType":2,"videoUrl":"http://vhot2.qqvideo.tc.qq.com/j0325tda7q2.m701.mp4?vkey=C590DA02A84D92A908993C83AFAF23ACA3B504A416BE6FACAD1BF123ADB928A5A76133F19E3370DEC6C2E438DEB38710E2106AA313C1CE98903B46D645747E5588B9E409EA87D989AC35589EBF9D048594C368F0EEBAA140","recomendVideos":[{"title":"LOL最骚套路：sofm火男打野教学","updateTime":1473832385,"thumbnail":"http://files.15w.com/image/2016/0914/14738323788114.jpg","excerpt":"LOL最骚套路：sofm火男打野教学","articleType":1,"extra":"5605664245","tagName":"","tagColor":""},{"title":"最强路人：黄鸡加亚索最脏套路抓翻全场","updateTime":1473660556,"thumbnail":"http://files.15w.com/image/2016/0912/14736605353112.jpg","excerpt":"最强路人：黄鸡加亚索最脏套路抓翻全场！","articleType":1,"extra":"5605663145","tagName":"","tagColor":""},{"title":"青铜5最怕的英雄！没有任何套路？见面就干","updateTime":1473070313,"thumbnail":"http://files.15w.com/image/2016/0905/14730703011869.jpg","excerpt":"LOL青铜5最怕的英雄！没有任何套路？见面就是干！","articleType":1,"extra":"5605658885","tagName":"","tagColor":""}]}
     */

    private int code;
    private String message;
    /**
     * title : 青铜5最怕的英雄！没有任何套路？见面就干
     * author : baTT
     * thumbnail : http://files.15w.com/image/2016/0905/14730703011869.jpg
     * excerpt : LOL青铜5最怕的英雄！没有任何套路？见面就是干！
     * shareUrl : http://m.15w.com/lol/jc/5605658885.html
     * changyanSid : 3/33750
     * time : 09-05 18:11
     * content : <iframe allowfullscreen="" frameborder="0" height="100%" width="100%" src="http://v.qq.com/iframe/player.html?vid=j0325tda7q2&tiny=0&auto=1"></iframe>
     * views : 1510播放
     * videoType : 2
     * videoUrl : http://vhot2.qqvideo.tc.qq.com/j0325tda7q2.m701.mp4?vkey=C590DA02A84D92A908993C83AFAF23ACA3B504A416BE6FACAD1BF123ADB928A5A76133F19E3370DEC6C2E438DEB38710E2106AA313C1CE98903B46D645747E5588B9E409EA87D989AC35589EBF9D048594C368F0EEBAA140
     * recomendVideos : [{"title":"LOL最骚套路：sofm火男打野教学","updateTime":1473832385,"thumbnail":"http://files.15w.com/image/2016/0914/14738323788114.jpg","excerpt":"LOL最骚套路：sofm火男打野教学","articleType":1,"extra":"5605664245","tagName":"","tagColor":""},{"title":"最强路人：黄鸡加亚索最脏套路抓翻全场","updateTime":1473660556,"thumbnail":"http://files.15w.com/image/2016/0912/14736605353112.jpg","excerpt":"最强路人：黄鸡加亚索最脏套路抓翻全场！","articleType":1,"extra":"5605663145","tagName":"","tagColor":""},{"title":"青铜5最怕的英雄！没有任何套路？见面就干","updateTime":1473070313,"thumbnail":"http://files.15w.com/image/2016/0905/14730703011869.jpg","excerpt":"LOL青铜5最怕的英雄！没有任何套路？见面就是干！","articleType":1,"extra":"5605658885","tagName":"","tagColor":""}]
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
        private String title;
        private String author;
        private String thumbnail;
        private String excerpt;
        private String shareUrl;
        private String changyanSid;
        private String time;
        private String content;
        private String views;
        private int videoType;
        private String videoUrl;
        /**
         * title : LOL最骚套路：sofm火男打野教学
         * updateTime : 1473832385
         * thumbnail : http://files.15w.com/image/2016/0914/14738323788114.jpg
         * excerpt : LOL最骚套路：sofm火男打野教学
         * articleType : 1
         * extra : 5605664245
         * tagName :
         * tagColor :
         */

        private List<RecomendVideosBean> recomendVideos;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getChangyanSid() {
            return changyanSid;
        }

        public void setChangyanSid(String changyanSid) {
            this.changyanSid = changyanSid;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public int getVideoType() {
            return videoType;
        }

        public void setVideoType(int videoType) {
            this.videoType = videoType;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public List<RecomendVideosBean> getRecomendVideos() {
            return recomendVideos;
        }

        public void setRecomendVideos(List<RecomendVideosBean> recomendVideos) {
            this.recomendVideos = recomendVideos;
        }

        public static class RecomendVideosBean {
            private String title;
            private int updateTime;
            private String thumbnail;
            private String excerpt;
            private int articleType;
            private String extra;
            private String tagName;
            private String tagColor;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(int updateTime) {
                this.updateTime = updateTime;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getExcerpt() {
                return excerpt;
            }

            public void setExcerpt(String excerpt) {
                this.excerpt = excerpt;
            }

            public int getArticleType() {
                return articleType;
            }

            public void setArticleType(int articleType) {
                this.articleType = articleType;
            }

            public String getExtra() {
                return extra;
            }

            public void setExtra(String extra) {
                this.extra = extra;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public String getTagColor() {
                return tagColor;
            }

            public void setTagColor(String tagColor) {
                this.tagColor = tagColor;
            }
        }
    }
}
