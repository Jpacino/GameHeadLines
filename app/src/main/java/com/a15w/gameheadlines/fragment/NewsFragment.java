package com.a15w.gameheadlines.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.newsfragment.NewsFragmentEight;
import com.a15w.gameheadlines.newsfragment.NewsFragmentFive;
import com.a15w.gameheadlines.newsfragment.NewsFragmentFour;
import com.a15w.gameheadlines.newsfragment.NewsFragmentOne;
import com.a15w.gameheadlines.newsfragment.NewsFragmentSeven;
import com.a15w.gameheadlines.newsfragment.NewsFragmentSix;
import com.a15w.gameheadlines.newsfragment.NewsFragmentThree;
import com.a15w.gameheadlines.newsfragment.NewsFragmentTwo;
import com.a15w.gameheadlines.presenter.PressenterIpml;
import com.a15w.gameheadlines.utils.DoLog;
import com.a15w.gameheadlines.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jpacino on 2016/9/5.
 */
public class NewsFragment extends Fragment implements IView{
    private Context mContext;
    private List<Fragment> list = new ArrayList<>();
    private NewsFragmentPagerAdapter adapter;
    private List<String> tabNameList = new ArrayList<>();
    private android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter  = new NewsFragmentPagerAdapter(getFragmentManager());
            viewPager.setAdapter(adapter);
        }
    };
    @BindView(R.id.fragment_news_main_viewpager)
    ViewPager viewPager;
    @BindView(R.id.fragment_news_main_tablayout)
    TabLayout tabLayout;

    public static NewsFragment newInstance(){
        return new NewsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        PressenterIpml pressenterIpml = new PressenterIpml(this);
        pressenterIpml.newsGetTabTitleFromModel();
    }

    private void initView() {
        NewsFragmentOne newsFragmentOne = NewsFragmentOne.newInstance();
        NewsFragmentTwo newsFragmentTwo = NewsFragmentTwo.newInstance();
        NewsFragmentThree newsFragmentThree = NewsFragmentThree.newInstance();
        NewsFragmentFour newsFragmentFour = NewsFragmentFour.newInstance();
        NewsFragmentFive newsFragmentFive = NewsFragmentFive.newInstance();
        NewsFragmentSix newsFragmentSix = NewsFragmentSix.newInstance();
        NewsFragmentSeven newsFragmentSeven = NewsFragmentSeven.newInstance();
        NewsFragmentEight newsFragmentEight = NewsFragmentEight.newInstance();
        list.add(newsFragmentOne);
        list.add(newsFragmentTwo);
        list.add(newsFragmentThree);
        list.add(newsFragmentFour);
        list.add(newsFragmentFive);
        list.add(newsFragmentSix);
        list.add(newsFragmentSeven);
        list.add(newsFragmentEight);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_main_layout,container,false);
        ButterKnife.bind(this,view);
        initView();
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void newsSetTitleToTab(List<String> list) {
        tabNameList.addAll(list);
        DoLog.doLog(tabNameList.get(0));
        handler.sendEmptyMessage(1);
    }



    public class NewsFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public NewsFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNameList.get(position);
        }
    }
}
