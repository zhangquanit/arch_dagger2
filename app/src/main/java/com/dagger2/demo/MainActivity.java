package com.dagger2.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * http://www.jianshu.com/p/39d1df6c877d
 */
public class MainActivity extends AppCompatActivity implements MainContract.View{
    /**
     * 注解@Inject，表明MainPresenter是需要注入到MainActivity中
     * 使用@Inject时，不能用private修饰符修饰类的成员属性。
     * MainPresenter的构造函数上同样加了@Inject注解,这样MainActivity里的mainPresenter与他的构造函数建立了某种联系
     */
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void updateUI() {
        Toast.makeText(this,"show",Toast.LENGTH_SHORT).show();
        System.out.println("updateUI");
    }

    View.OnClickListener onClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {

        }
    };

    public void fun(View view) {
        MainModule mainModule = new MainModule(this, new Bundle());
        mainModule.setOnClickListener(onClickListener);
        DaggerMainComponent.builder()
                .mainModule(mainModule)
                .build()
                .inject(this);

        //调用Presenter方法加载数据
        mainPresenter.loadData();
    }
}
