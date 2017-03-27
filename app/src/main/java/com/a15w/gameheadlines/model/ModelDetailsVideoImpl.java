package com.a15w.gameheadlines.model;

import com.a15w.gameheadlines.bean.VideoDetailsBean;
import com.a15w.gameheadlines.http.HttpService;
import com.a15w.gameheadlines.http.HttpUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/17.
 */
public class ModelDetailsVideoImpl implements IModelDetailsVideo{
    @Override
    public void getDetailsVideoData(String dataId,final SuccessGetVideoDetailsData successGetVideoDetailsData) {
        HttpService init = HttpUtils.init();
        Call<VideoDetailsBean> videoDetailData = init.getVideoDetailData(dataId);
        videoDetailData.enqueue(new Callback<VideoDetailsBean>() {
            @Override
            public void onResponse(Call<VideoDetailsBean> call, Response<VideoDetailsBean> response) {
                VideoDetailsBean body = response.body();
                successGetVideoDetailsData.successGetVideoDetailsData(body);
            }

            @Override
            public void onFailure(Call<VideoDetailsBean> call, Throwable t) {

            }
        });
    }

    public interface SuccessGetVideoDetailsData{
        void successGetVideoDetailsData(VideoDetailsBean videoDetailsBean);
    }
}
