package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.model.IModel;
import com.a15w.gameheadlines.model.IModelNewsOne;
import com.a15w.gameheadlines.model.ModelImpl;
import com.a15w.gameheadlines.model.ModelImplNewsOne;
import com.a15w.gameheadlines.view.IView;
import com.a15w.gameheadlines.view.IViewNewsOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PressenterIpmlNewsOne implements IPressenterNewsOne ,ModelImplNewsOne.IModelImplGetData{
    IModelNewsOne iModel= new ModelImplNewsOne();
    IViewNewsOne iView;
    private int type;
    private String dataId;
    private int time;
    NesOneDataBean newsTitleFromNet = new NesOneDataBean();
    public PressenterIpmlNewsOne(IViewNewsOne iView,String dataId,int type,int time){
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
        newsTitleFromNet = dataBean;
        iView.newsOneGetData(newsTitleFromNet);
    }
}
