package com.a15w.gameheadlines.model;

import com.a15w.gameheadlines.bean.NewsTabTitleBean;
import com.a15w.gameheadlines.http.HttpService;
import com.a15w.gameheadlines.http.HttpUtils;
import com.a15w.gameheadlines.utils.DoLog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ModelImpl implements IModel{
    private List<String> nameList = new ArrayList<>();
    @Override
    public void getNewsTitleFromNet(final IModelImplGetData iModelImplGetData) {
        HttpService init = HttpUtils.init();
        Call<NewsTabTitleBean> newsTabTitleBeanCall = init.newsGetTabTitleBean();
        newsTabTitleBeanCall.enqueue(new Callback<NewsTabTitleBean>() {
            @Override
            public void onResponse(Call<NewsTabTitleBean> call, Response<NewsTabTitleBean> response) {
                NewsTabTitleBean.DataBean data = response.body().getData();
                List<NewsTabTitleBean.DataBean.ListBean> list = data.getList();
                DoLog.doLog(list.get(0).getCategoryName());
                if(list != null){
                    for (int i = 0; i < list.size(); i++) {
                        NewsTabTitleBean.DataBean.ListBean listBean = list.get(i);
                        String categoryName = listBean.getCategoryName();
                        nameList.add(categoryName);
                        DoLog.doLog(list.get(i).getCategoryName());
                    }
                }
                iModelImplGetData.getDataFromModel(nameList);
            }
            @Override
            public void onFailure(Call<NewsTabTitleBean> call, Throwable t) {
            }
        });
//        DoLog.doLog(nameList.get(0));
    }

    public interface IModelImplGetData{
        void getDataFromModel(List<String> list);
    }
}
