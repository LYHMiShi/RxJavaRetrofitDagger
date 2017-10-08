package jiyun.com.rxjavaretrofitdagger.ui.modules.home;


import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import jiyun.com.rxjavaretrofitdagger.R;
import jiyun.com.rxjavaretrofitdagger.base.BaseFragment;
import jiyun.com.rxjavaretrofitdagger.model.entity.LiveChina;

public class HomeFragment extends BaseFragment implements HomeContract.View {


    @BindView(R.id.list_view)
    ListView listView;

    ArrayList<LiveChina.LiveBean> liveChinas;
    HomeContract.Presenter presenter;
    private HomeAdapter homeAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        liveChinas = new ArrayList<>();
        homeAdapter = new HomeAdapter(getActivity(),liveChinas);
        listView.setAdapter(homeAdapter);
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLiveChina(LiveChina bean) {
        liveChinas.addAll(bean.getLive());
        homeAdapter.notifyDataSetChanged();
    }
}
