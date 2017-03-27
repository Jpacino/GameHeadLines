package com.a15w.gameheadlines.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.ui.AboutActivity;
import com.a15w.gameheadlines.ui.IdealActivity;
import com.a15w.gameheadlines.ui.LoginActivity;
import com.a15w.gameheadlines.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jpacino on 2016/9/5.
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    public static MineFragment newInstance(){
        return new MineFragment();
    }
    private Context mContext;
    private View view;
    private Intent loginIntent;
    private Intent aboutIntent;
    private Intent idealIntent;
    @BindView(R.id.mine_fragment_login_iv)
    ImageView loginIv;
    @BindView(R.id.mine_fragment_login_tv)
    TextView loginTv;
    @BindView(R.id.fragment_mine_main_setting_ll)
    LinearLayout settingLl;
    @BindView(R.id.fragment_mine_main_ideal_ll)
    LinearLayout idealLl;
    @BindView(R.id.fragment_mine_main_clean_ll)
    LinearLayout cleanLl;
    @BindView(R.id.fragment_mine_main_update_ll)
    LinearLayout updateLl;
    @BindView(R.id.fragment_mine_main_about_ll)
    LinearLayout aboutLl;
    private Toast toast;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine_main_layout,container,false);
        initView();

        return view;
    }

    private void initView() {
        ButterKnife.bind(this,view);
        loginIv.setOnClickListener(this);
        loginTv.setOnClickListener(this);
        settingLl.setOnClickListener(this);
        idealLl.setOnClickListener(this);
        cleanLl.setOnClickListener(this);
        updateLl.setOnClickListener(this);
        aboutLl.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_fragment_login_tv:
                loginIntent = new Intent(mContext, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case  R.id.mine_fragment_login_iv:
                loginIntent = new Intent(mContext, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.fragment_mine_main_setting_ll:
                loginIntent = new Intent(mContext, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.fragment_mine_main_ideal_ll:
                idealIntent = new Intent(mContext, IdealActivity.class);
                startActivity(idealIntent);
                break;
            case R.id.fragment_mine_main_clean_ll:
                toast = Toast.makeText(mContext, "已清理 0 KB", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;
            case R.id.fragment_mine_main_update_ll:
                toast = Toast.makeText(mContext, "已经是最新版本", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;
            case R.id.fragment_mine_main_about_ll:
                aboutIntent = new Intent(mContext, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }

    }
}
