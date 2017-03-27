package com.a15w.gameheadlines.bean;

import java.util.List;

/**
 * Created by Jpacino on 2016/9/7.
 */
public class ContestBean {

    /**
     * code : 10000
     * message : success
     * data : {"list":[{"time":1471017600,"content":[{"name":"2016年LPL夏季赛8月13日13：00 OMG VS YM","views":"302播放","gameId":"5605023284","teamA":{"name":"OMG","logo":"http://files.15w.com/image/2016/0620/14663855314312.png","score":"3"},"teamB":{"name":"YM","logo":"http://files.15w.com/image/2016/0412/14604512133527.png","score":"2"},"status":{"type":0,"message":"回顾"}},{"name":"2016年LPL夏季赛8月13日17：00 NB VS SHR","views":"0播放","gameId":"5605023304","teamA":{"name":"NB","logo":"http://files.15w.com/image/2016/0520/14637232331670.png","score":"3"},"teamB":{"name":"SHR","logo":"http://files.15w.com/image/2016/0524/14641005147106.png","score":"0"},"status":{"type":0,"message":"回顾"}}],"date":"08月13日","show":0},{"time":1471104000,"content":[{"name":"2016年LPL夏季赛8月14日13：00 EDG VS WE","views":"1812播放","gameId":"5605023324","teamA":{"name":"EDG","logo":"http://files.15w.com/image/2016/0412/14604510424738.png","score":"3"},"teamB":{"name":"WE","logo":"http://files.15w.com/image/2016/0412/14604502109158.png","score":"2"},"status":{"type":0,"message":"回顾"}},{"name":"2016年LPL夏季赛8月14日17：00 RNG VS IM","views":"1812播放","gameId":"5605023344","teamA":{"name":"RNG","logo":"http://files.15w.com/image/2016/0412/14604504479211.png","score":"3"},"teamB":{"name":"IM","logo":"http://files.15w.com/image/2016/0520/14637239426647.png","score":"2"},"status":{"type":0,"message":"回顾"}}],"date":"08月14日","show":0},{"time":1471190400,"content":[{"name":"2016年LPL夏季赛8月15日14：00 VG VS SS","views":"302播放","gameId":"5605023364","teamA":{"name":"VG","logo":"http://files.15w.com/image/2016/0412/1460450189360.png","score":"0"},"teamB":{"name":"Snake","logo":"http://files.15w.com/image/2016/0412/14604503992117.png","score":"2"},"status":{"type":0,"message":"回顾"}},{"name":"2016年LPL夏季赛8月15日16：00 WE VS IM","views":"2114播放","gameId":"5605023384","teamA":{"name":"WE","logo":"http://files.15w.com/image/2016/0412/14604502109158.png","score":"1"},"teamB":{"name":"IM","logo":"http://files.15w.com/image/2016/0520/14637239426647.png","score":"3"},"status":{"type":0,"message":"回顾"}}],"date":"08月15日","show":0},{"time":1472140800,"content":[{"name":"2016年LPL夏季赛8月26日16：00 EDG VS RNG","views":"3624播放","gameId":"5605023404","teamA":{"name":"EDG","logo":"http://files.15w.com/image/2016/0412/14604510424738.png","score":"3"},"teamB":{"name":"RNG","logo":"http://files.15w.com/image/2016/0412/14604504479211.png","score":"0"},"status":{"type":0,"message":"回顾"}}],"date":"08月26日","show":0},{"time":1472227200,"content":[{"name":"S6资格选拔赛8月27日12：00 VG VS SS","views":"604播放","gameId":"5605023884","teamA":{"name":"VG","logo":"http://files.15w.com/image/2016/0412/1460450189360.png","score":"2"},"teamB":{"name":"Snake","logo":"http://files.15w.com/image/2016/0412/14604503992117.png","score":"3"},"status":{"type":0,"message":"回顾"}},{"name":"S6资格选拔赛8月27日17：45 WE VS SS","views":"1208播放","gameId":"5605023904","teamA":{"name":"WE","logo":"http://files.15w.com/image/2016/0412/14604502109158.png","score":"3"},"teamB":{"name":"Snake","logo":"http://files.15w.com/image/2016/0412/14604503992117.png","score":"2"},"status":{"type":0,"message":"回顾"}}],"date":"08月27日","show":0},{"time":1472313600,"content":[{"name":"S6资格选拔赛8月28日12：00 IM VS WE","views":"6342播放","gameId":"5605023924","teamA":{"name":"IM","logo":"http://files.15w.com/image/2016/0520/14637239426647.png","score":"3"},"teamB":{"name":"WE","logo":"http://files.15w.com/image/2016/0412/14604502109158.png","score":"2"},"status":{"type":0,"message":"回顾"}}],"date":"08月28日","show":1}]}
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
         * time : 1471017600
         * content : [{"name":"2016年LPL夏季赛8月13日13：00 OMG VS YM","views":"302播放","gameId":"5605023284","teamA":{"name":"OMG","logo":"http://files.15w.com/image/2016/0620/14663855314312.png","score":"3"},"teamB":{"name":"YM","logo":"http://files.15w.com/image/2016/0412/14604512133527.png","score":"2"},"status":{"type":0,"message":"回顾"}},{"name":"2016年LPL夏季赛8月13日17：00 NB VS SHR","views":"0播放","gameId":"5605023304","teamA":{"name":"NB","logo":"http://files.15w.com/image/2016/0520/14637232331670.png","score":"3"},"teamB":{"name":"SHR","logo":"http://files.15w.com/image/2016/0524/14641005147106.png","score":"0"},"status":{"type":0,"message":"回顾"}}]
         * date : 08月13日
         * show : 0
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int time;
            private String date;
            private int show;
            /**
             * name : 2016年LPL夏季赛8月13日13：00 OMG VS YM
             * views : 302播放
             * gameId : 5605023284
             * teamA : {"name":"OMG","logo":"http://files.15w.com/image/2016/0620/14663855314312.png","score":"3"}
             * teamB : {"name":"YM","logo":"http://files.15w.com/image/2016/0412/14604512133527.png","score":"2"}
             * status : {"type":0,"message":"回顾"}
             */

            private List<ContentBean> content;

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getShow() {
                return show;
            }

            public void setShow(int show) {
                this.show = show;
            }

            public List<ContentBean> getContent() {
                return content;
            }

            public void setContent(List<ContentBean> content) {
                this.content = content;
            }

            public static class ContentBean {
                private String name;
                private String views;
                private String gameId;
                /**
                 * name : OMG
                 * logo : http://files.15w.com/image/2016/0620/14663855314312.png
                 * score : 3
                 */

                private TeamABean teamA;
                /**
                 * name : YM
                 * logo : http://files.15w.com/image/2016/0412/14604512133527.png
                 * score : 2
                 */

                private TeamBBean teamB;
                /**
                 * type : 0
                 * message : 回顾
                 */

                private StatusBean status;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getViews() {
                    return views;
                }

                public void setViews(String views) {
                    this.views = views;
                }

                public String getGameId() {
                    return gameId;
                }

                public void setGameId(String gameId) {
                    this.gameId = gameId;
                }

                public TeamABean getTeamA() {
                    return teamA;
                }

                public void setTeamA(TeamABean teamA) {
                    this.teamA = teamA;
                }

                public TeamBBean getTeamB() {
                    return teamB;
                }

                public void setTeamB(TeamBBean teamB) {
                    this.teamB = teamB;
                }

                public StatusBean getStatus() {
                    return status;
                }

                public void setStatus(StatusBean status) {
                    this.status = status;
                }

                public static class TeamABean {
                    private String name;
                    private String logo;
                    private String score;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getLogo() {
                        return logo;
                    }

                    public void setLogo(String logo) {
                        this.logo = logo;
                    }

                    public String getScore() {
                        return score;
                    }

                    public void setScore(String score) {
                        this.score = score;
                    }
                }

                public static class TeamBBean {
                    private String name;
                    private String logo;
                    private String score;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getLogo() {
                        return logo;
                    }

                    public void setLogo(String logo) {
                        this.logo = logo;
                    }

                    public String getScore() {
                        return score;
                    }

                    public void setScore(String score) {
                        this.score = score;
                    }
                }

                public static class StatusBean {
                    private int type;
                    private String message;

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public String getMessage() {
                        return message;
                    }

                    public void setMessage(String message) {
                        this.message = message;
                    }
                }
            }
        }
    }
}
