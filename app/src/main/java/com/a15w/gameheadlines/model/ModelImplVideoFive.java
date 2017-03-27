package com.a15w.gameheadlines.model;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.http.HttpService;
import com.a15w.gameheadlines.http.HttpUtils;
import com.a15w.gameheadlines.utils.DoLog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ModelImplVideoFive implements IModelVideoFive{


    @Override
    public void getNewsTitleFromNet(final IModelImplGetData iModelImplGetData, String dataId, int type, int time) {
        HttpService init = HttpUtils.init();
        DoLog.doLog(type +"");
        Call<NesOneDataBean> newsGetVideoOneDataBean = init.newsGetVideoOneDataBean(15,19,dataId,type,time);
        newsGetVideoOneDataBean.enqueue(new Callback<NesOneDataBean>() {
            @Override
            public void onResponse(Call<NesOneDataBean> call, Response<NesOneDataBean> response) {
                NesOneDataBean body = response.body();
                iModelImplGetData.getDataFromModel(body);
            }

            @Override
            public void onFailure(Call<NesOneDataBean> call, Throwable t) {

            }
        });
    }


    public interface IModelImplGetData{
        void getDataFromModel(NesOneDataBean list);
    }
}
