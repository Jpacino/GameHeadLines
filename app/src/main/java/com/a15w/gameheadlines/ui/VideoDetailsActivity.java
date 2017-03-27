package com.a15w.gameheadlines.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.bean.NewsDetailsBean;
import com.a15w.gameheadlines.bean.VideoDetailsBean;
import com.a15w.gameheadlines.presenter.PressenterImplNewsDetails;
import com.a15w.gameheadlines.presenter.PressenterVideoDetails;
import com.a15w.gameheadlines.utils.DoLog;
import com.a15w.gameheadlines.view.IViewNewsDetails;
import com.a15w.gameheadlines.view.IViewVideoDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/13.
 */
public class VideoDetailsActivity extends AppCompatActivity implements View.OnClickListener,IViewVideoDetails{
    @BindView(R.id.detais_video_back_btn)
    ImageButton backBtn;
    @BindView(R.id.detais_video_share_btn)
    ImageButton shareBtn;
    @BindView(R.id.details_video_webview)
    WebView webView;
    @BindView(R.id.details_video_title_tv)
    TextView titleTv;
    @BindView(R.id.details_video_time_tv)
    TextView timeTv;
    private String url = "http://182.254.110.107/vhot2.qqvideo.tc.qq.com/j0325tda7q2.m701.mp4?sha=1E7F053E3324EDC76F896AABFDC9F0BDF0AA06B8&vkey=C590DA02A84D92A908993C83AFAF23ACA3B504A416BE6FACAD1BF123ADB928A5A76133F19E3370DEC6C2E438DEB38710E2106AA313C1CE98903B46D645747E5588B9E409EA87D989AC35589EBF9D048594C368F0EEBAA140&ocid=3734028042";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            webView.loadDataWithBaseURL(null,htmlDataStr,"text/html","UTF-8",null);

        }

    };
    private String htmlDataStr = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_video_activity);
        ButterKnife.bind(this);
        String dataId = getIntent().getStringExtra("dataId");
        PressenterVideoDetails pressenterVideoDetails = new PressenterVideoDetails(dataId, this);
        pressenterVideoDetails.dealVideoDetailsData();
        DoLog.doLog(dataId+"details");
        initView();
    }

    private void initView() {
        backBtn.setOnClickListener(this);
        shareBtn.setOnClickListener(this);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//         设置WebView属性，能够执行Javascript脚本
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setVisibility(View.VISIBLE);
        webView.getSettings().setUseWideViewPort(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detais_video_back_btn:
                finish();
                break;
            case R.id.detais_video_share_btn:
                shareShowDialog();
                break;
            default:
                break;
        }
    }

    private void shareShowDialog() {

    }


    @Override
    public void setVideoDetails(VideoDetailsBean videoDetailsBean) {
        VideoDetailsBean.DataBean data = videoDetailsBean.getData();
        String content = data.getContent();
        htmlDataStr = content;
        DoLog.doLog(htmlDataStr+"  ");
        String title = data.getTitle();
        titleTv.setText(title);
        String time = data.getTime();
        timeTv.setText(time);
        handler.sendEmptyMessage(1);
    }
}
