package com.a15w.gameheadlines.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.bean.ContestDetailBean;
import com.a15w.gameheadlines.fragmentContest.ContestDetailNewsFragment;
import com.a15w.gameheadlines.fragmentContest.ContestDetailVideoFragment;
import com.a15w.gameheadlines.customView.CustomProgressDialog;
import com.a15w.gameheadlines.http.HttpUtils;
import com.a15w.gameheadlines.utils.DoLog;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContestDtailActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private CustomProgressDialog dialog;
    private RatioProgress leftRatioProgress;
    private RatioProgress rightRatioProgress;
    private ShareToolBarViewHolder shareToolBarViewHolder;
    @BindView(R.id.share_toolbar)
    View toolBarView;
    @BindView(R.id.activity_contest_detail_radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.activity_contest_detail_team1_name_tv)
    TextView team1NameTv;
    @BindView(R.id.activity_contest_detail_team2_name_tv)
    TextView team2NameTv;
    @BindView(R.id.activity_contest_detail_team1_like_tv)
    TextView team1LikeTv;
    @BindView(R.id.activity_contest_detail_team2_like_tv)
    TextView team2likeTv;
    @BindView(R.id.activity_contest_detail_team1_logo_iv)
    ImageView team1LogoIv;
    @BindView(R.id.activity_contest_detail_team2_logo_iv)
    ImageView team2LogoIv;
    @BindView(R.id.activity_contest_detail_score_tv)
    TextView scoreTv;
    @BindView(R.id.activity_contest_detail_time_tv)
    TextView timeTv;
    @BindView(R.id.activity_contest_detail_discuss_iv)
    ImageView discussIv;
    private int team1Num;
    private int team2Num;


    @BindView(R.id.activity_contest_detail_main_ll)
    LinearLayout linearLayout;
    private ContestDetailVideoFragment contestDetailVideoFragment;
    private ContestDetailNewsFragment contestDetailNewsFragment;
    private FragmentManager fragmentManager;
    private Fragment showFragment;
    private String dataId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.toolbar_red);
        }
        setContentView(R.layout.activity_contest_dtail);
        initView();
        initFragment();
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        contestDetailVideoFragment = ContestDetailVideoFragment.newInstance();
        contestDetailNewsFragment = ContestDetailNewsFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("dataId",dataId);
        contestDetailVideoFragment.setArguments(bundle);
        contestDetailNewsFragment.setArguments(bundle);
        controlFragment(contestDetailVideoFragment);

    }

    private void controlFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (showFragment != null && showFragment.isAdded()) {
            fragmentTransaction.hide(showFragment);
        }
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.activity_contest_detail_fl, fragment);
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
        showFragment = fragment;
    }

    private void initView() {
        ButterKnife.bind(this);
        linearLayout.setVisibility(View.GONE);
        dataId = getIntent().getStringExtra("dataId");
        initData();
        dialog = new CustomProgressDialog(this, R.style.DialogStyle, "", R.drawable.loading_anim);
        dialog.show();
        shareToolBarViewHolder = new ShareToolBarViewHolder(toolBarView);
        shareToolBarViewHolder.backBtnIv.setOnClickListener(this);
        shareToolBarViewHolder.shareBtnIv.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        discussIv.setOnClickListener(this);


    }

    private void initData() {
        DoLog.doLog("dataId"+dataId);
        HttpUtils.init().getContestDetailBean(dataId).enqueue(new Callback<ContestDetailBean>() {
            @Override
            public void onResponse(Call<ContestDetailBean> call, Response<ContestDetailBean> response) {
                DoLog.doLog("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                team1NameTv.setText(response.body().getData().getTeamA().getName());
                team2NameTv.setText(response.body().getData().getTeamB().getName());
                team1LikeTv.setText(response.body().getData().getTeamA().getSupport_numbber());
                team2likeTv.setText(response.body().getData().getTeamB().getSupport_numbber());
                scoreTv.setText(response.body().getData().getTeamA().getScore() + ":" + response.body().getData().getTeamB().getScore());
                timeTv.setText(response.body().getData().getGameTime());
                Picasso.with(ContestDtailActivity.this).load(response.body().getData().getTeamA().getLogo()).into(team1LogoIv);
                Picasso.with(ContestDtailActivity.this).load(response.body().getData().getTeamB().getLogo()).into(team2LogoIv);
                team1Num = Integer.valueOf(response.body().getData().getTeamA().getSupport_numbber());
                team2Num = Integer.valueOf(response.body().getData().getTeamB().getSupport_numbber());
                controlRatioProgress();
                dialog.dismiss();
                linearLayout.setVisibility(View.VISIBLE);


            }

            @Override
            public void onFailure(Call<ContestDetailBean> call, Throwable t) {

            }
        });
    }

    private void controlRatioProgress() {
        WindowManager manager = ((WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE));

        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        final int w = dm.widthPixels;

        leftRatioProgress = (RatioProgress) findViewById(R.id.left_ratio_progress);
        LayoutParams lp = leftRatioProgress.getLayoutParams();
        rightRatioProgress = (RatioProgress) findViewById(R.id.right_ratio_progress);
        LayoutParams lp1 = rightRatioProgress.getLayoutParams();
        lp.width = team1Num == 0 ? 0 : w * team1Num/(team1Num+team2Num);
        lp1.width = team2Num == 0 ? 0 : w * team2Num/(team1Num+team2Num);
        leftRatioProgress.setLayoutParams(lp);
        rightRatioProgress.setLayoutParams(lp1);
        int speed1 = team1Num == 0 ? 0 : 6 *team2Num/(team1Num+team2Num);
        int speed2 = team2Num == 0 ? 0 : 6 *team1Num/(team1Num+team2Num);
        leftRatioProgress.setSleepDelay(speed1);
        rightRatioProgress.setSleepDelay(speed2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_back_btn_iv:
                finish();
                break;
            case R.id.toolbar_share_btn_iv:

                break;
            case R.id.activity_contest_detail_discuss_iv:
                Intent intent = new Intent(this, DiscussActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.activity_contest_detail_video_rb:
                controlFragment(contestDetailVideoFragment);
                break;
            case R.id.activity_contest_detail_news_rb:
                controlFragment(contestDetailNewsFragment);
                break;
        }

    }

    class ShareToolBarViewHolder {
        @BindView(R.id.toolbar_back_btn_iv)
        ImageView backBtnIv;
        @BindView(R.id.toolbar_share_btn_iv)
        ImageView shareBtnIv;

        public ShareToolBarViewHolder(View toolbarView) {
            ButterKnife.bind(this, toolbarView);

        }
    }
}

