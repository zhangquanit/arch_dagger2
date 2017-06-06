package com.dagger2.demo;

public interface MainContract {
    public interface View{
       void updateUI();
    }
    public interface presenter{
        void loadData();
    }

}
