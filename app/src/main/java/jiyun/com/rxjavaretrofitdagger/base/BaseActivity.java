package jiyun.com.rxjavaretrofitdagger.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import jiyun.com.rxjavaretrofitdagger.app.App;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLayout());
        ButterKnife.bind(this);
        init();
    }

    protected abstract int getLayout();
    protected abstract void init();
}
