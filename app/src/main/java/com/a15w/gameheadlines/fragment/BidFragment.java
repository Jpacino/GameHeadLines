package com.a15w.gameheadlines.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a15w.gameheadlines.R;

/**
 * Created by Jpacino on 2016/9/5.
 */
public class BidFragment extends Fragment {
    public static BidFragment newInstance(){
        return new BidFragment();
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
        View view = inflater.inflate(R.layout.fragment_bid_main_layout,container,false);
        return view;
    }


}
