package jiyun.com.rxjavaretrofitdagger.app;


import android.app.Application;

import jiyun.com.rxjavaretrofitdagger.base.BaseActivity;

public class App extends Application{
    public static BaseActivity context = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
