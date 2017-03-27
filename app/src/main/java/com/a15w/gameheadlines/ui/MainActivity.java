package com.a15w.gameheadlines.ui;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a15w.gameheadlines.R;
import com.a15w.gameheadlines.fragment.BidFragment;
import com.a15w.gameheadlines.fragment.ContestFragment;
import com.a15w.gameheadlines.fragment.MineFragment;
import com.a15w.gameheadlines.fragment.NewsFragment;
import com.a15w.gameheadlines.fragment.VideoFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity {
    private long exitTime;
    @BindView(R.id.activity_main_radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.activity_main_rb_news)
    RadioButton newsRb;
    @BindView(R.id.activity_main_rb_video)
    RadioButton videoRb;
    @BindView(R.id.activity_main_rb_contest)
    RadioButton contestRb;
    @BindView(R.id.activity_main_rb_bid)
    RadioButton bidRb;
    @BindView(R.id.activity_main_rb_mine)
    RadioButton mineRb;
    @BindView(R.id.activity_main_framlayout)
    FrameLayout framlayout;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTranstaction;
    private static Fragment currentFragment;
    private Fragment newsFragment = NewsFragment.newInstance();
    private Fragment bidFragment = BidFragment.newInstance();
    private Fragment contestFragment = ContestFragment.newInstance();
    private Fragment mineFragment = MineFragment.newInstance();
    private Fragment videoFragment = VideoFragment.newInstance();
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                window.setNavigationBarColor(Color.TRANSPARENT);
                SystemBarTintManager tintManager = new SystemBarTintManager(this);
                tintManager.setStatusBarTintEnabled(true);
                tintManager.setStatusBarTintResource(R.color.toolbar_red);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        ctrlFragment(newsFragment);
    }
    private void initView() {
        mFragmentManager = getSupportFragmentManager();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.activity_main_rb_news:
                        ctrlFragment(newsFragment);
                        break;
                    case R.id.activity_main_rb_video:
                        ctrlFragment(videoFragment);
                        break;
                    case R.id.activity_main_rb_contest:
                        ctrlFragment(contestFragment);
                        break;
                    case R.id.activity_main_rb_bid:
                        ctrlFragment(bidFragment);
                        break;
                    case R.id.activity_main_rb_mine:
                        ctrlFragment(mineFragment);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    private void ctrlFragment(Fragment fragment){
        mTranstaction = mFragmentManager.beginTransaction();
        if(currentFragment!=null&&currentFragment.isAdded()){
            mTranstaction.hide(currentFragment);
        }
        if(fragment.isAdded()){
            mTranstaction.show(fragment);
        }else{
            mTranstaction.add(R.id.activity_main_framlayout,fragment);
        }
        mTranstaction.commit();
        currentFragment = fragment;

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (System.currentTimeMillis() - exitTime > 3000){
                toast = Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                exitTime = System.currentTimeMillis();
            }
            else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
