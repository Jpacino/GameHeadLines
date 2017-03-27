package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.model.IModelNewsOne;
import com.a15w.gameheadlines.model.IModelVideo;
import com.a15w.gameheadlines.model.IModelVideoImpl;
import com.a15w.gameheadlines.model.IModelVideoOne;
import com.a15w.gameheadlines.model.ModelImplNewsOne;
import com.a15w.gameheadlines.model.ModelImplVideoOne;
import com.a15w.gameheadlines.view.IViewNewsOne;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PressenterIpmlVideoOne implements IPressenterNewsOne ,ModelImplVideoOne.IModelImplGetData{
    IModelVideoOne iModel= new ModelImplVideoOne();
    IViewNewsOne iView;
    private int type;
    private String dataId;
    private int time;
    NesOneDataBean newsTitleFromNet = new NesOneDataBean();
    public PressenterIpmlVideoOne(IViewNewsOne iView, String dataId, int type, int time){
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
