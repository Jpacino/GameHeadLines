package com.a15w.gameheadlines.model;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface IModelDetails {
    void getDetailsFromNet(ModelDetailsImpl.SuccessGetDetails successGetDetails, String dataId);
}
