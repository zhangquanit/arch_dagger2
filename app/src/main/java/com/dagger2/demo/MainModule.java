package com.dagger2.demo;

import android.os.Bundle;
import android.view.View;

import dagger.Module;
import dagger.Provides;

/**
 * 提供对外需要的依赖
 */
@Module
public class MainModule {
    private final MainContract.View mView;
    private final Bundle mBundle;
    private  View.OnClickListener mOnClickListener;

    public MainModule(MainContract.View view, Bundle bundle) {
        mView = view;
        mBundle=bundle;
    }
    public void setOnClickListener(View.OnClickListener onClickListener){
        mOnClickListener=onClickListener;
    }

    @Provides
    MainContract.View provideMainView() {
        return mView;
    }
    @Provides
    Bundle provideBundle(){
        return mBundle;
    }
    @Provides
    View.OnClickListener getOnClickListener(){
        return mOnClickListener;
    }
}