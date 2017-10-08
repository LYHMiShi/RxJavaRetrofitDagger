package jiyun.com.rxjavaretrofitdagger.net;


import io.reactivex.Observable;
import jiyun.com.rxjavaretrofitdagger.config.Urls;
import jiyun.com.rxjavaretrofitdagger.model.entity.LiveChina;
import retrofit2.http.GET;

public interface Api {
    @GET(Urls.LIVECHIAN)
    Observable<LiveChina> getLiveChina();
}