package com.a15w.gameheadlines.http;



import com.a15w.gameheadlines.bean.ADBean;
import com.a15w.gameheadlines.bean.ContestBean;
import com.a15w.gameheadlines.bean.ContestDetailBean;
import com.a15w.gameheadlines.bean.ContestTitleBean;
import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.bean.NewsDetailsBean;
import com.a15w.gameheadlines.bean.NewsTabTitleBean;
import com.a15w.gameheadlines.bean.VideoDetailsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Jpacino on 2016/9/6.
 */
public interface HttpService {
    @GET("/client/app/jn/v1_2/game/category")
    Call<ContestTitleBean> getTitleBean();

    //第一模块，第一板块 标题
    @GET("/client/app/jn/v1_2/home/category")
    Call<NewsTabTitleBean> newsGetTabTitleBean();

    //第二模块，第一板块 标题
    @GET("/client/app/jn/v1_2/video/category")
    Call<NewsTabTitleBean> videoGetTabTitleBean();


    //第一模块，第一板块 数据 pageSize=15&catId=1&itemId=0&type=0&itemDate=0
    @POST("/client/app/jn/v1_2/home/content")
    Call<NesOneDataBean> newsGetNewsOneDataBean(@Query("pageSize")int pageSize,
                                                @Query("catId")int catId,
                                                @Query("itemId")String itemId,
                                                @Query("type")int type,
                                                @Query("itemDate")int itemDate);

    //第一模块，第一板块 数据 pageSize=15&catId=1&itemId=0&type=0&itemDate=0
    @POST("/client/app/jn/v1_2/video/list")
    Call<NesOneDataBean> newsGetVideoOneDataBean(@Query("pageSize")int pageSize,
                                                 @Query("catId")int catId,
                                                 @Query("itemId")String itemId,
                                                 @Query("type")int type,
                                                 @Query("itemDate")int itemDate);

    //第一模块详情内容
    @POST("/client/app/jn/v1_2/detail/news")
    Call<NewsDetailsBean> getNewsDetailData(@Query("dataId") String dataId);

    @POST("/client/app/jn/v1_4/video/detail")
    Call<VideoDetailsBean> getVideoDetailData(@Query("dataId") String dataId);

    //第三模块标题
    @GET("/client/app/jn/v1_2/game/category")
    Call<ContestTitleBean> getContestTitleBean();

    //第三模块内容
    @POST("/client/app/jn/v1_2/game/list")
    Observable<ContestBean> getContestBean(@Query("catId") int catId,
                                           @Query("type") int type,
                                           @Query("itemId") int itemId,
                                           @Query("itemDate") int itemDate,
                                           @Query("deviceId") String deviceId);
    //第三模块详情内容
    @POST("/client/app/jn/v1_2/game/detail")
    Call<ContestDetailBean> getContestDetailBean(@Query("dataId") String dataId);
    //广告图片
    @GET("/client/app/jn/v1_2/splash")
    Call<ADBean> getADBean();
}

