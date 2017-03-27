package com.a15w.gameheadlines;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.a15w.gameheadlines.bean.ADBean;
import com.a15w.gameheadlines.http.HttpUtils;
import com.a15w.gameheadlines.ui.AdActivity;
import com.a15w.gameheadlines.ui.MainActivity;
import com.a15w.gameheadlines.utils.DoLog;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.welcome_activity_main_iv)
    ImageView mainIv;
    @BindView(R.id.welcome_activity_skip_btn)
    Button skipBtn;
    private Intent intent;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        intent = new Intent(WelcomeActivity.this, MainActivity.class);
        mHandler.sendEmptyMessageDelayed(1, 2000);
        mainIv.setOnClickListener(this);
        skipBtn.setOnClickListener(this);
        HttpUtils.init().getADBean().enqueue(new Callback<ADBean>() {
            @Override
            public void onResponse(Call<ADBean> call, Response<ADBean> response) {
                DoLog.doLog("url : "+response.body().getData().getUrl());
                Picasso.with(WelcomeActivity.this).load(response.body().getData().getCover()).into(mainIv);
            }

            @Override
            public void onFailure(Call<ADBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.welcome_activity_skip_btn:
                startActivity(intent);
                finish();
                break;
            case R.id.welcome_activity_main_iv:
                Intent intent1 = new Intent(WelcomeActivity.this, AdActivity.class);
                startActivity(intent1);
                finish();
        }
    }

    @Override
    protected void onDestroy() {
        mHandler.removeMessages(1);
        super.onDestroy();
    }
}
