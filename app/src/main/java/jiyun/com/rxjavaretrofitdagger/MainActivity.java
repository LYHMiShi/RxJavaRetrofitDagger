package jiyun.com.rxjavaretrofitdagger;

import javax.inject.Inject;

import jiyun.com.rxjavaretrofitdagger.base.BaseActivity;
import jiyun.com.rxjavaretrofitdagger.injector.component.DaggerHomeComponent;
import jiyun.com.rxjavaretrofitdagger.injector.modules.HomeModules;
import jiyun.com.rxjavaretrofitdagger.manager.FragmentBuilder;
import jiyun.com.rxjavaretrofitdagger.ui.modules.home.HomeFragment;
import jiyun.com.rxjavaretrofitdagger.ui.modules.home.HomePresenter;

public class MainActivity extends BaseActivity {

    @Inject
    HomePresenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        HomeFragment homeFragment = (HomeFragment) FragmentBuilder.changeFragment(HomeFragment.class, R.id.myFrame, false, null, true);
        DaggerHomeComponent.builder()
                .homeModules(new HomeModules(homeFragment))
                .build()
                .inject(this);
    }
}
