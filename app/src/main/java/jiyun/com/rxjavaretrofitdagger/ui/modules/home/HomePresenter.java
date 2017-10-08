package jiyun.com.rxjavaretrofitdagger.ui.modules.home;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.rxjavaretrofitdagger.model.entity.LiveChina;
import jiyun.com.rxjavaretrofitdagger.net.RetrofitService;

public class HomePresenter implements HomeContract.Presenter{

    HomeFragment view;

    @Inject
    public HomePresenter(HomeFragment view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        RetrofitService.getInstance()//获取Api对象
                .getLiveChina()//被观察者
                .subscribeOn(Schedulers.io())//被观察者执行在io线程中
                .observeOn(AndroidSchedulers.mainThread())//返回的数据在主线程中
                .subscribe(new Consumer<LiveChina>() {
                    @Override
                    public void accept(LiveChina liveChina) throws Exception {
                        view.showLiveChina(liveChina);
                    }
                });
    }
}
