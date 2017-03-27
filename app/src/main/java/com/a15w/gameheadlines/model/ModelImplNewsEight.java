package com.a15w.gameheadlines.model;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.http.HttpService;
import com.a15w.gameheadlines.http.HttpUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ModelImplNewsEight implements IModelNewsTwo{

    private String itemId;
    private int type;
    private int itemDate;



    @Override
    public void getDataNewsTwoFromNet(String itemId, int type, int itemDate,final ModelImplNewsTwo.SuccessNewsTwo successNewsTwo) {
        HttpService init = HttpUtils.init();
        Call<NesOneDataBean> nesOneDataBeanCall = init.newsGetNewsOneDataBean(15, 17, itemId, type, itemDate);
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
