package com.dagger2.demo;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

/**
 * 多个构造函数，只能一个用@Inject
 */
public class MainPresenter implements MainContract.presenter {
    private MainContract.View mView;
    private Bundle mBundle;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Inject
    public MainPresenter(MainContract.View view, Bundle bundle) {
        mView = view;
        mBundle = bundle;
    }

    @Override
    public void loadData() {
        mView.updateUI();
    }

    /**
     * @Inject用来方法上
     * @param onClickListener
     */
    @Inject
    public  void  setOnClickListener(View.OnClickListener onClickListener){

    }
}
