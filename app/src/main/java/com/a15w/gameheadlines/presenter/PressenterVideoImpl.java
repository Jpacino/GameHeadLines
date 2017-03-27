package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NewsTabTitleBean;
import com.a15w.gameheadlines.model.IModelVideo;
import com.a15w.gameheadlines.model.IModelVideoImpl;
import com.a15w.gameheadlines.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public class PressenterVideoImpl implements IPressenterVideo,IModelVideoImpl.Success{
    IView iView ;
    IModelVideo iModelVideo;
    private List<String> nameList = new ArrayList<>();
    public PressenterVideoImpl(IView iView){
        this.iView = iView;
        iModelVideo = new IModelVideoImpl();
    }

    @Override
    public void dealVideoTabTitle() {
        iModelVideo.getVideoTabTitle(this);
    }

    @Override
    public void getDataSuccess(List<NewsTabTitleBean.DataBean.ListBean> list) {
        for (int i = 0; i < list.size(); i++) {
            NewsTabTitleBean.DataBean.ListBean listBean = list.get(i);
            String categoryName = listBean.getCategoryName();
            nameList.add(categoryName);
        }
        iView.newsSetTitleToTab(nameList);
    }
}
