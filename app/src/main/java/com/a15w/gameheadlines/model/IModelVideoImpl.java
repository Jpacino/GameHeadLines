package com.a15w.gameheadlines.model;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.bean.NewsTabTitleBean;
import com.a15w.gameheadlines.http.HttpService;
import com.a15w.gameheadlines.http.HttpUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/12.
 */
public class IModelVideoImpl implements IModelVideo {
    @Override
    public void getVideoTabTitle(final Success success) {
        HttpService init = HttpUtils.init();
        Call<NewsTabTitleBean> newsTabTitleBeanCall = init.videoGetTabTitleBean();
        newsTabTitleBeanCall.enqueue(new Callback<NewsTabTitleBean>() {
            @Override
            public void onResponse(Call<NewsTabTitleBean> call, Response<NewsTabTitleBean> response) {
                NewsTabTitleBean body = response.body();
                List<NewsTabTitleBean.DataBean.ListBean> list = body.getData().getList();
                success.getDataSuccess(list);
            }

            @Override
            public void onFailure(Call<NewsTabTitleBean> call, Throwable t) {

            }
        });
    }

    public interface Success{
        void getDataSuccess(List<NewsTabTitleBean.DataBean.ListBean> list);
    }
}
