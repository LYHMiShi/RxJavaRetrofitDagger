package jiyun.com.rxjavaretrofitdagger.ui.modules.home;


import jiyun.com.rxjavaretrofitdagger.base.BasePresenter;
import jiyun.com.rxjavaretrofitdagger.base.BaseView;
import jiyun.com.rxjavaretrofitdagger.model.entity.LiveChina;

public interface HomeContract {
    interface Presenter extends BasePresenter{

    }
    interface View extends BaseView<Presenter>{
        void showLiveChina(LiveChina bean);
    }
}
