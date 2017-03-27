package com.a15w.gameheadlines.presenter;

import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.model.IModelNewsTwo;
import com.a15w.gameheadlines.model.ModelImplNewsSeven;
import com.a15w.gameheadlines.model.ModelImplNewsSix;
import com.a15w.gameheadlines.model.ModelImplNewsTwo;
import com.a15w.gameheadlines.view.IViewNewsOne;

/**
 * Created by Administrator on 2016/9/7.
 */
public class PressenterIpmlNewsSeven implements IPressenterNewsTwo , ModelImplNewsTwo.SuccessNewsTwo{

    IModelNewsTwo model ;
    IViewNewsOne view ;
    private String itemId;
    private int type;
    private int itemData;

    public PressenterIpmlNewsSeven(IViewNewsOne view, String itemId, int type, int itemData){
        this.view = view;
        model = new ModelImplNewsSeven();
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
