package com.a15w.gameheadlines.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.bean.ContestTitleBean;
import com.a15w.gameheadlines.fragmentContest.ContestFragmentFive;
import com.a15w.gameheadlines.fragmentContest.ContestFragmentFour;
import com.a15w.gameheadlines.fragmentContest.ContestFragmentOne;
import com.a15w.gameheadlines.fragmentContest.ContestFragmentSix;
import com.a15w.gameheadlines.fragmentContest.ContestFragmentThree;
import com.a15w.gameheadlines.fragmentContest.ContestFragmentTwo;
import com.a15w.gameheadlines.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jpacino on 2016/9/5.
 */
public class ContestFragment extends Fragment {
    private static final String TAG = "androidjjj";
    private MyVpAdapter myVpAdapter;

    public static ContestFragment newInstance() {
        return new ContestFragment();
    }

    private Context mContext;
    private View view;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<ContestTitleBean.DataBean.ListBean> ListBeans = new ArrayList<>();
    @BindView(R.id.fragment_contest_main_vp)
    ViewPager viewPager;
    @BindView(R.id.fragment_contest_main_tabLayout)
    TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contest_main_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        ButterKnife.bind(this, view);
        loadData();
        FragmentManager childFragmentManager = getChildFragmentManager();
        myVpAdapter = new MyVpAdapter(childFragmentManager);
        viewPager.setAdapter(myVpAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void loadData() {
        fragments.add(ContestFragmentOne.newInstance());
        fragments.add(ContestFragmentTwo.newInstance());
        fragments.add(ContestFragmentThree.newInstance());
        fragments.add(ContestFragmentFour.newInstance());
        fragments.add(ContestFragmentFive.newInstance());
        fragments.add(ContestFragmentSix.newInstance());
        titles.add("2016LPL夏季赛");
        titles.add("2016德玛西亚杯");
        titles.add("2016LSPL夏季赛");
        titles.add("2016季中赛");
        titles.add("2016LPL春季赛");
        titles.add("2016LSPL春季赛");
        HttpUtils.init().getContestTitleBean().enqueue(new Callback<ContestTitleBean>() {
            @Override
            public void onResponse(Call<ContestTitleBean> call, Response<ContestTitleBean> response) {
                Log.d(TAG, "onResponse: " + response.body().getData().getList().get(0).getCategoryName());
                ListBeans.addAll(response.body().getData().getList());
                titles.clear();
                for (int i = 0; i < ListBeans.size(); i++) {
                    titles.add(ListBeans.get(i).getCategoryName());
                }
                myVpAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ContestTitleBean> call, Throwable t) {
            }
        });
    }

    class MyVpAdapter extends FragmentStatePagerAdapter {

        public MyVpAdapter(FragmentManager fm) {
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
            return titles.isEmpty() ? null : titles.get(position);
        }
    }


}
