package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.model.IModelNewsOne;
import com.a15w.gameheadlines.model.IModelNewsTwo;
import com.a15w.gameheadlines.model.ModelImplNewsOne;
import com.a15w.gameheadlines.model.ModelImplNewsTwo;
import com.a15w.gameheadlines.view.IViewNewsOne;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PressenterIpmlNewsTwo implements IPressenterNewsTwo , ModelImplNewsTwo.SuccessNewsTwo{

    IModelNewsTwo model ;
    IViewNewsOne view ;
    private String itemId;
    private int type;
    private int itemData;

    public PressenterIpmlNewsTwo(IViewNewsOne view, String itemId, int type, int itemData){
        this.view = view;
        model = new ModelImplNewsTwo();
        this.itemData = itemData;
        this.type = type;
        this.itemId = itemId;
    }

    @Override
    public void newsGetTabTitleFromModel() {
        model.getDataNewsTwoFromNet(itemId,type,itemData,this);
    }

    @Override
    public void sucessNewsTwo(NesOneDataBean dataBean) {
        view.newsOneGetData(dataBean);
    }
}
