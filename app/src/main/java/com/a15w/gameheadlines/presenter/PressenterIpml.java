package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.bean.NewsTabTitleBean;
import com.a15w.gameheadlines.model.IModel;
import com.a15w.gameheadlines.model.IModelNewsOne;
import com.a15w.gameheadlines.model.ModelImpl;
import com.a15w.gameheadlines.model.ModelImplNewsOne;
import com.a15w.gameheadlines.utils.DoLog;
import com.a15w.gameheadlines.view.IView;
import com.a15w.gameheadlines.view.IViewNewsOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PressenterIpml implements IPressenter,IModel,ModelImpl.IModelImplGetData{
    IModel iModel= new ModelImpl() ;
    IView iView ;
    List<String> newsTitleFromNet = new ArrayList<>();
    public PressenterIpml(IView iView){
        this.iView = iView;
    }

    @Override
    public void getDataFromModel(List<String> list) {
        newsTitleFromNet.addAll(list);
        iView.newsSetTitleToTab(newsTitleFromNet);
    }


    @Override
    public void getNewsTitleFromNet(ModelImpl.IModelImplGetData iModelImplGetData) {
        iModelImplGetData.getDataFromModel(newsTitleFromNet);
    }

    @Override
    public void newsGetTabTitleFromModel() {
        iModel.getNewsTitleFromNet(this);
    }
}
