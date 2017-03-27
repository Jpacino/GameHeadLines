package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.VideoDetailsBean;
import com.a15w.gameheadlines.model.IModelDetailsVideo;
import com.a15w.gameheadlines.model.ModelDetailsVideoImpl;
import com.a15w.gameheadlines.view.IViewVideoDetails;

/**
 * Created by Administrator on 2016/9/17.
 */
public class PressenterVideoDetails implements IPressenterVideoDetails ,ModelDetailsVideoImpl.SuccessGetVideoDetailsData{
    private IViewVideoDetails iViewVideoDetails;
    private IModelDetailsVideo iModelDetailsVideo;
    private String dataId;

    public PressenterVideoDetails(String dataId,IViewVideoDetails iViewVideoDetails){
        this.iViewVideoDetails = iViewVideoDetails;
        iModelDetailsVideo = new ModelDetailsVideoImpl();
        this.dataId = dataId;
    }

    @Override
    public void dealVideoDetailsData() {
        iModelDetailsVideo.getDetailsVideoData(dataId,this);
    }

    @Override
    public void successGetVideoDetailsData(VideoDetailsBean videoDetailsBean) {
        iViewVideoDetails.setVideoDetails(videoDetailsBean);
    }
}
