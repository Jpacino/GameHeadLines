package com.a15w.gameheadlines.fragmentContest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.bean.ContestBean;
import com.a15w.gameheadlines.http.HttpUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Jpacino on 2016/9/5.
 */
public class ContestFragmentSix extends Fragment {
    private static final String TAG = "androidjjj";
    private MyLvAdapter myLvAdapter;
    private List<ContestBean.DataBean.ListBean> listBeans = new ArrayList<>();
    private View footerView;

    public static ContestFragmentSix newInstance(){
        return new ContestFragmentSix();
    }
    private Context mContext;
    private View view;
    @BindView(R.id.fragment_contest_main_lv)
    ExpandableListView expandableListView;
    @BindView(R.id.fragment_contest_main_swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contest_main_one_layout,container,false);
        footerView = inflater.inflate(R.layout.fragment_contest_main_footview_layout,null);
        ButterKnife.bind(this,view);
        swipeRefresh.setColorSchemeResources(R.color.toolbar_red);
        swipeRefresh.setProgressViewOffset(false,0,50);
        swipeRefresh.setRefreshing(true);
        initView();

        return view;
    }

    private void initView() {
        rxjava(0);
        expandableListView.addFooterView(footerView);
        myLvAdapter = new MyLvAdapter();
        expandableListView.setAdapter(myLvAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rxjava(listBeans.get(0).getTime());
            }
        });


    }

    private void rxjava(int num) {

        HttpUtils.init().getContestBean(20,0,0,num,"18071adc030d2410d78")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<ContestBean>() {
                    private Toast toast;

                    @Override
                    public void call(ContestBean contestBean) {
                        List<ContestBean.DataBean.ListBean> listbean = contestBean.getData().getList();
                        Collections.reverse(listbean);
                        Collections.reverse(listBeans);
                        listBeans.addAll(listbean);
                        Collections.reverse(listBeans);
                        myLvAdapter.notifyDataSetChanged();
                        for (int i = 0; i < listBeans.size(); i++) {
                            expandableListView.expandGroup(i);
                        }
                        if (listbean.isEmpty()){
                        toast = Toast.makeText(mContext, "没有更多新内容了", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();}
                        swipeRefresh.setRefreshing(false);
                    }
                });

    }




    class MyLvAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            if(listBeans.isEmpty()){
                footerView.setVisibility(View.GONE);
            }else {
                footerView.setVisibility(View.VISIBLE);
            }
            return listBeans==null ? 0 : listBeans.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return listBeans.get(groupPosition).getContent() == null ?0:listBeans.get(groupPosition).getContent().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null){
                view = LayoutInflater.from(mContext).inflate(R.layout.fragment_contest_main_group_item,parent,false);
            }
            TextView timeTv = (TextView) view.findViewById(R.id.group_view_item_time_tv);
            timeTv.setText(listBeans.get(groupPosition).getDate());
            return view;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder viewHolder;
            if (view == null){
                view = LayoutInflater.from(mContext).inflate(R.layout.fragment_contest_main_child_item,parent,false);
                viewHolder = new ViewHolder(view);
            }else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Picasso.with(mContext).load(listBeans.get(groupPosition).getContent().get(childPosition).getTeamA().getLogo()).into(viewHolder.team1IV);
            Picasso.with(mContext).load(listBeans.get(groupPosition).getContent().get(childPosition).getTeamB().getLogo()).into(viewHolder.team2IV);
            viewHolder.team1NameTv.setText(listBeans.get(groupPosition).getContent().get(childPosition).getTeamA().getName());
            viewHolder.team2NameTv.setText(listBeans.get(groupPosition).getContent().get(childPosition).getTeamB().getName());
            viewHolder.team1ScoreTv.setText(listBeans.get(groupPosition).getContent().get(childPosition).getTeamA().getScore());
            viewHolder.team2ScoreTv.setText(listBeans.get(groupPosition).getContent().get(childPosition).getTeamB().getScore());
            viewHolder.viewsTv.setText(listBeans.get(groupPosition).getContent().get(childPosition).getViews());
            viewHolder.nameTv.setText(listBeans.get(groupPosition).getContent().get(childPosition).getName());
            return view;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
    class ViewHolder {
        @BindView(R.id.child_view_team1_iv)
        ImageView team1IV;
        @BindView(R.id.child_view_team2_iv)
        ImageView team2IV;
        @BindView(R.id.child_view_team1_tv)
        TextView team1NameTv;
        @BindView(R.id.child_view_team2_tv)
        TextView team2NameTv;
        @BindView(R.id.child_view_team1_score_tv)
        TextView team1ScoreTv;
        @BindView(R.id.child_view_team2_score_tv)
        TextView team2ScoreTv;
        @BindView(R.id.child_view_name_tv)
        TextView nameTv;
        @BindView(R.id.child_view_views_tv)
        TextView viewsTv;


        public ViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);

        }
    }
}
