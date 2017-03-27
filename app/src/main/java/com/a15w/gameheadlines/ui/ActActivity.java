package com.a15w.gameheadlines.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.a15w.gameheadlines.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.share_toolbar)
    View toolBarView;
    private ShareToolBarViewHolder shareToolBarViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);
        initView();

    }

    private void initView() {
        ButterKnife.bind(this);
        shareToolBarViewHolder = new ShareToolBarViewHolder(toolBarView);
        shareToolBarViewHolder.backBtnIv.setOnClickListener(this);
        shareToolBarViewHolder.shareBtnIv.setOnClickListener(this);
        shareToolBarViewHolder.titleTv.setText("活动中心");
        shareToolBarViewHolder.titleTv.setTextColor(Color.WHITE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back_btn_iv:
                finish();
                break;
            case R.id.toolbar_share_btn_iv:

                break;
        }


    }

    class ShareToolBarViewHolder {
        @BindView(R.id.toolbar_back_btn_iv)
        ImageView backBtnIv;
        @BindView(R.id.toolbar_title_tv)
        TextView titleTv;
        @BindView(R.id.toolbar_share_btn_iv)
        ImageView shareBtnIv;

        public ShareToolBarViewHolder(View toolbarView) {
            ButterKnife.bind(this, toolbarView);

        }
    }
}
