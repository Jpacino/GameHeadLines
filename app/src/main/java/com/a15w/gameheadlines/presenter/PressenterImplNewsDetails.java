package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NewsDetailsBean;
import com.a15w.gameheadlines.model.IModelDetails;
import com.a15w.gameheadlines.model.ModelDetailsImpl;
import com.a15w.gameheadlines.view.IViewNewsDetails;

/**
 * Created by Administrator on 2016/9/16.
 */
public class PressenterImplNewsDetails implements IPressenterNewsDetails ,ModelDetailsImpl.SuccessGetDetails{
    private IModelDetails iModelDetails = new ModelDetailsImpl();
    private IViewNewsDetails iViewNewsDetails;
    private String dataId;
    public PressenterImplNewsDetails(IViewNewsDetails iViewNewsDetails, String dataId){
        this.iViewNewsDetails = iViewNewsDetails;
        this.dataId = dataId;
    }


    @Override
    public void dealNewsDetalsData() {
        iModelDetails.getDetailsFromNet(this,dataId);
    }

    @Override
    public void successGetDetaislData(NewsDetailsBean newsDetailsBean) {
        iViewNewsDetails.newsOneGetData(newsDetailsBean);
    }
}
