package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.model.IModelVideoThree;
import com.a15w.gameheadlines.model.IModelVideoTwo;
import com.a15w.gameheadlines.model.ModelImplVideoThree;
import com.a15w.gameheadlines.model.ModelImplVideoTwo;
import com.a15w.gameheadlines.view.IViewNewsOne;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PressenterIpmlVideoThree implements IPressenterNewsOne ,ModelImplVideoThree.IModelImplGetData{
    IModelVideoThree iModel= new ModelImplVideoThree();
    IViewNewsOne iView;
    private int type;
    private String dataId;
    private int time;
    NesOneDataBean newsTitleFromNet = new NesOneDataBean();
    public PressenterIpmlVideoThree(IViewNewsOne iView, String dataId, int type, int time){
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
