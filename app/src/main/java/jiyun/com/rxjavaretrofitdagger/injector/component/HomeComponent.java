package jiyun.com.rxjavaretrofitdagger.injector.component;

import dagger.Component;
import jiyun.com.rxjavaretrofitdagger.MainActivity;
import jiyun.com.rxjavaretrofitdagger.injector.modules.HomeModules;

@Component(modules = HomeModules.class)
public interface HomeComponent {
    void inject(MainActivity mainActivity);
}
