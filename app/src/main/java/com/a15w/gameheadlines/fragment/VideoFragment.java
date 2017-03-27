package com.a15w.gameheadlines.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.FrameLayout;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.presenter.PressenterVideoImpl;
import com.a15w.gameheadlines.utils.DoLog;
import com.a15w.gameheadlines.videofragment.VideoFragmentFive;
import com.a15w.gameheadlines.videofragment.VideoFragmentFour;
import com.a15w.gameheadlines.videofragment.VideoFragmentOne;
import com.a15w.gameheadlines.videofragment.VideoFragmentSix;
import com.a15w.gameheadlines.videofragment.VideoFragmentThree;
import com.a15w.gameheadlines.videofragment.VideoFragmentTwo;
import com.a15w.gameheadlines.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jpacino on 2016/9/5.
 */
public class VideoFragment extends Fragment implements IView{

    private List<String> nameList = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private VideoViewPagerAdapter pagerAdapter;
    @BindView(R.id.fragment_video_main_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.fragment_video_main_framelayout)
    ViewPager viewPager;

    public static VideoFragment newInstance(){
        return new VideoFragment();
    }
    private Context mContext;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setAdapter(pagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DoLog.doLog("oncreate");
        mContext = getContext();
        pagerAdapter = new VideoViewPagerAdapter(getFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_main_layout,container,false);
        ButterKnife.bind(this,view);
        initView();
        PressenterVideoImpl pressenterVideo = new PressenterVideoImpl(this);
        pressenterVideo.dealVideoTabTitle();
        return view;
    }

    private void initView() {
        fragments.add(VideoFragmentOne.newInstance());
        fragments.add(VideoFragmentTwo.newInstance());
        fragments.add(VideoFragmentThree.newInstance());
        fragments.add(VideoFragmentFour.newInstance());
        fragments.add(VideoFragmentFive.newInstance());
        fragments.add(VideoFragmentSix.newInstance());
    }


    @Override
    public void newsSetTitleToTab(List<String> list) {
        nameList.addAll(list);
        String s = list.get(0);
        DoLog.doLog(s+"qqqq");
        handler.sendEmptyMessage(1);
    }

    class VideoViewPagerAdapter extends FragmentStatePagerAdapter{

        public VideoViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments == null ? 0 : fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String s = nameList.get(position);
            DoLog.doLog(s+"aaaaaaaaaaaaaa");
            return nameList.get(position);
        }
    }
}
