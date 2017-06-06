package com.dagger2.demo;

import android.os.Bundle;
import android.view.View;

import dagger.Module;
import dagger.Provides;

/**
 * 之所以有Module类主要是为了提供那些没有构造函数的类的依赖，这些类无法用@Inject标注，比如第三方类库，系统类
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