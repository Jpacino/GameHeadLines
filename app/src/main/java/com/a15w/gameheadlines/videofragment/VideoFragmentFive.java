package com.a15w.gameheadlines.videofragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.bean.NesOneDataBean;
import com.a15w.gameheadlines.presenter.PressenterIpmlVideoFive;
import com.a15w.gameheadlines.presenter.PressenterIpmlVideoFour;
import com.a15w.gameheadlines.ui.NewsDetailsActivity;
import com.a15w.gameheadlines.ui.VideoDetailsActivity;
import com.a15w.gameheadlines.view.IViewNewsOne;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/12.
 */
public class VideoFragmentFive extends Fragment implements IViewNewsOne{

    private Context mContext;
    @BindView(R.id.fragment_video_main_one_list_lv)
    RecyclerView mListView;
    @BindView(R.id.fragment_video_main_swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int sType;
    private int lastTime;
    private String lastDataId = 0+"";
    private List<NesOneDataBean.DataBean.ListBean> recyclerList = new ArrayList<>();
    private VideoLVAdapter adapter = new VideoLVAdapter();
    private Handler mHandler = new Handler (){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mListView.setAdapter(adapter);
        }
    };
    public static VideoFragmentFive newInstance(){
        return  new VideoFragmentFive();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_main_one_layout, container, false);
        ButterKnife.bind(this,view);
        mListView.setLayoutManager(new LinearLayoutManager(mContext));
        PressenterIpmlVideoFive pressenterIpmlNewsOne = new PressenterIpmlVideoFive(this,lastDataId, sType,lastTime);
        pressenterIpmlNewsOne.newsGetTabTitleFromModel();
        sType = sType + 1;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                PressenterIpmlVideoFive pressenterIpmlNewsOne = new PressenterIpmlVideoFive(VideoFragmentFive.this,lastDataId,sType,lastTime);
                pressenterIpmlNewsOne.newsGetTabTitleFromModel();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }


    @Override
    public void newsOneGetData(NesOneDataBean dataBean) {
        NesOneDataBean.DataBean data = dataBean.getData();
        List<NesOneDataBean.DataBean.ListBean> list = data.getList();
        recyclerList.addAll(list);
        mHandler.sendEmptyMessage(1);
    }

    class VideoLVViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fragment_video_main_item_big_iv)
        ImageView bigIv;
        @BindView(R.id.fragment_video_main_item_title_tv)
        TextView titleTv;
        @BindView(R.id.fragment_video_main_item_content_tv)
        TextView contentTv;
        public VideoLVViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class VideoLVAdapter extends RecyclerView.Adapter<VideoLVViewHolder>{

        @Override
        public VideoLVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_video_main_item_layout, parent, false);
            return new VideoLVViewHolder(view);
        }

        @Override
        public void onBindViewHolder(VideoLVViewHolder holder, int position) {
            NesOneDataBean.DataBean.ListBean listBean = recyclerList.get(position);
            String thumbnail = listBean.getThumbnail();
            Picasso.with(mContext).load(thumbnail).into(holder.bigIv);
            String title = listBean.getTitle();
            holder.titleTv.setText(title);
            String excerpt = listBean.getExcerpt();
            holder.contentTv.setText(excerpt);
            holder.itemView.setOnClickListener(new ListOnClickLinsener(listBean));
        }

        @Override
        public int getItemCount() {
            return recyclerList == null ? 0 : recyclerList.size();
        }
    }
    public class ListOnClickLinsener implements View.OnClickListener {
        private NesOneDataBean.DataBean.ListBean listBean;
        public ListOnClickLinsener(NesOneDataBean.DataBean.ListBean listBean){
            this.listBean = listBean;
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,VideoDetailsActivity.class);
            String dataId = listBean.getDataId();
            intent.putExtra("dataId",dataId);
            mContext.startActivity(intent);
        }
    }
}
