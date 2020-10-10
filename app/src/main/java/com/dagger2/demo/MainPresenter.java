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

    /**
     * 通过构造函数注入参数
     * @param view
     * @param bundle
     */
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
     * @Inject 用在方法上，当创建好MainPresenter后，会从module种拿到OnClickListener注入进来
     * @param onClickListener  该参数必须能通过module提供
     */
    @Inject
    public  void  setOnClickListener(View.OnClickListener onClickListener){

    }
}
