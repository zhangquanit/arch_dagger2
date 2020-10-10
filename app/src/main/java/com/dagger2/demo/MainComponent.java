package com.dagger2.demo;

import dagger.Component;

/**
 * 一个Component类可以包含多个Module类，用来提供依赖。
 */
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);//注入到MainActivity中
}