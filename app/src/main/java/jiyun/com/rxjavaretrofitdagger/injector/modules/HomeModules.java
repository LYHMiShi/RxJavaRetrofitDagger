package jiyun.com.rxjavaretrofitdagger.injector.modules;


import dagger.Module;
import dagger.Provides;
import jiyun.com.rxjavaretrofitdagger.ui.modules.home.HomeFragment;

@Module
public class HomeModules {

    HomeFragment homeFragment;
    public HomeModules(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @Provides
    HomeFragment provideHomeFragment(){
        return homeFragment;
    }
}
