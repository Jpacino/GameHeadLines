package com.a15w.gameheadlines.model;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.http.HttpService;
import com.a15w.gameheadlines.http.HttpUtils;
import com.a15w.gameheadlines.utils.DoLog;
import com.a15w.gameheadlines.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ModelImplNewsTwo implements IModelNewsTwo{

    private String itemId;
    private int type;
    private int itemDate;


    @Override
    public void getDataNewsTwoFromNet(String itemId, int type, int itemDate, final SuccessNewsTwo successNewsTwo) {
        HttpService init = HttpUtils.init();
        Call<NesOneDataBean> nesOneDataBeanCall = init.newsGetNewsOneDataBean(15, 11, itemId, type, itemDate);
        nesOneDataBeanCall.enqueue(new Callback<NesOneDataBean>() {
            @Override
            public void onResponse(Call<NesOneDataBean> call, Response<NesOneDataBean> response) {
                NesOneDataBean data = response.body();
                successNewsTwo.sucessNewsTwo(data);
            }

            @Override
            public void onFailure(Call<NesOneDataBean> call, Throwable t) {

            }
        });
    }

    public interface SuccessNewsTwo{
        void sucessNewsTwo(NesOneDataBean dataBean);
    }
}
