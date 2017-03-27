package com.a15w.gameheadlines.model;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface IModelNewsTwo {
    void getDataNewsTwoFromNet(String itemId, int type, int itemDate, final ModelImplNewsTwo.SuccessNewsTwo successNewsTwo);
}
