package com.a15w.gameheadlines.model;

import com.a15w.gameheadlines.bean.ContestDetailBean;
import com.a15w.gameheadlines.bean.NewsDetailsBean;
import com.a15w.gameheadlines.http.HttpService;
import com.a15w.gameheadlines.http.HttpUtils;
import com.a15w.gameheadlines.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/16.
 */
public class ModelDetailsImpl implements IModelDetails {
    @Override
    public void getDetailsFromNet(final SuccessGetDetails successGetDetails ,String dataId) {
        HttpService init = HttpUtils.init();
        Call<NewsDetailsBean> newsDetailData = init.getNewsDetailData(dataId);
        newsDetailData.enqueue(new Callback<NewsDetailsBean>() {
            @Override
            public void onResponse(Call<NewsDetailsBean> call, Response<NewsDetailsBean> response) {
                NewsDetailsBean body = response.body();
                successGetDetails.successGetDetaislData(body);
            }

            @Override
            public void onFailure(Call<NewsDetailsBean> call, Throwable t) {

            }
        });
    }

    public interface SuccessGetDetails{
        void successGetDetaislData(NewsDetailsBean newsDetailsBean);
    }
}
