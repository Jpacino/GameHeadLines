package com.a15w.gameheadlines.fragmentContest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.bean.ContestDetailBean;
import com.a15w.gameheadlines.http.HttpUtils;
import com.a15w.gameheadlines.ui.ContestDetailVideoActivity;
import com.a15w.gameheadlines.utils.DoLog;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jpacino on 2016/9/5.
 */
public class ContestDetailVideoFragment extends Fragment {
    @BindView(R.id.fragment_contest_detail_video_rv)
    RecyclerView recyclerView;
    private View view;
    private String dataId;
    private MyRvAdapter myRvAdapter;
    private List<ContestDetailBean.DataBean.RelateVideosBean> RelateVideosBeans = new ArrayList<>();

    public static ContestDetailVideoFragment newInstance(){
        return new ContestDetailVideoFragment();
    }
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contest_main_detail_video_layout,container,false);
        initView();
        return view;
    }

    private void initView() {
        ButterKnife.bind(this,view);
        Bundle bundle = getArguments();
        dataId = bundle.getString("dataId");
        initData();
        myRvAdapter = new MyRvAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(myRvAdapter);
    }

    private void initData() {
        HttpUtils.init().getContestDetailBean(dataId).enqueue(new Callback<ContestDetailBean>() {
            @Override
            public void onResponse(Call<ContestDetailBean> call, Response<ContestDetailBean> response) {
                RelateVideosBeans.addAll(response.body().getData().getRelateVideos());
                myRvAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ContestDetailBean> call, Throwable t) {

            }
        });
    }


    class MyRvViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fragment_contest_detail_video_title_tv)
        TextView titleTv;
        @BindView(R.id.fragment_contest_detail_video_img_iv)
        ImageView imageView;
        @BindView(R.id.fragment_contest_detail_video_time_tv)
        TextView timeTv;

        public MyRvViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
    class MyRvAdapter extends RecyclerView.Adapter<MyRvViewHolder>{

        private MyRvViewHolder myRvViewHolder;

        @Override
        public MyRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_contest_main_detail_video_rv_item, parent, false);
            myRvViewHolder = new MyRvViewHolder(view);
            return myRvViewHolder;
        }

        @Override
        public void onBindViewHolder(MyRvViewHolder holder, int position) {
            holder.titleTv.setText(RelateVideosBeans.get(position).getTitle());
            Picasso.with(mContext).load(RelateVideosBeans.get(position).getThumbnail()).into(holder.imageView);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date(RelateVideosBeans.get(position).getUpdateTime()*1000L));
            holder.timeTv.setText(date);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,ContestDetailVideoActivity.class);
                    startActivity(intent);
                    DoLog.doLog("------------------");
                }
            });
        }

        @Override
        public int getItemCount() {
            return RelateVideosBeans == null ? 0 :RelateVideosBeans.size();
        }
    }
}
