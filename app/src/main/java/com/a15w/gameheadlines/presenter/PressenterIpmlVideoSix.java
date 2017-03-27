package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.model.IModelVideoFive;
import com.a15w.gameheadlines.model.IModelVideoSix;
import com.a15w.gameheadlines.model.ModelImplVideoFive;
import com.a15w.gameheadlines.model.ModelImplVideoSix;
import com.a15w.gameheadlines.view.IViewNewsOne;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PressenterIpmlVideoSix implements IPressenterNewsOne ,ModelImplVideoSix.IModelImplGetData{
    IModelVideoSix iModel= new ModelImplVideoSix();
    IViewNewsOne iView;
    private int type;
    private String dataId;
    private int time;
    NesOneDataBean newsTitleFromNet = new NesOneDataBean();
    public PressenterIpmlVideoSix(IViewNewsOne iView, String dataId, int type, int time){
        this.iView = iView;
        this.type = type;
        this.dataId = dataId;
        this.time = time;
    }

    @Override
    public void newsGetTabTitleFromModel() {
        iModel.getNewsTitleFromNet(this,dataId,type,time);
    }

    @Override
    public void getDataFromModel(NesOneDataBean dataBean) {
        iView.newsOneGetData(dataBean);
    }
}
