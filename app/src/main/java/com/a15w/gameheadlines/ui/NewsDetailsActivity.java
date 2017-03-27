package com.a15w.gameheadlines.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.bean.NewsDetailsBean;
import com.a15w.gameheadlines.presenter.PressenterImplNewsDetails;
import com.a15w.gameheadlines.utils.DoLog;
import com.a15w.gameheadlines.view.IViewNewsDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/13.
 */
public class NewsDetailsActivity extends AppCompatActivity implements View.OnClickListener,IViewNewsDetails{
    @BindView(R.id.detais_news_back_btn)
    ImageButton backBtn;
    @BindView(R.id.detais_news_share_btn)
    ImageButton shareBtn;
    @BindView(R.id.details_news_webview)
    WebView webView;
    @BindView(R.id.details_news_title_tv)
    TextView titleTv;
    @BindView(R.id.details_news_time_tv)
    TextView timeTv;

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
        setContentView(R.layout.details_news_activity);
        ButterKnife.bind(this);
        String dataId = getIntent().getStringExtra("dataId");
        PressenterImplNewsDetails pressenterImplNewsDetails = new PressenterImplNewsDetails(this, dataId);
        pressenterImplNewsDetails.dealNewsDetalsData();
        DoLog.doLog(dataId+"details");
        initView();
    }

    private void initView() {
        backBtn.setOnClickListener(this);
        shareBtn.setOnClickListener(this);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detais_news_back_btn:
                finish();
                break;
            case R.id.detais_news_share_btn:
                shareShowDialog();
                break;
            default:
                break;
        }
    }

    private void shareShowDialog() {

    }

    @Override
    public void newsOneGetData(NewsDetailsBean dataBean) {
        NewsDetailsBean.DataBean data = dataBean.getData();
        String content = data.getContent();
        htmlDataStr = content;
        String title = data.getTitle();
        titleTv.setText(title);
        String time = data.getTime();
        timeTv.setText(time);
        handler.sendEmptyMessage(1);
    }
}
