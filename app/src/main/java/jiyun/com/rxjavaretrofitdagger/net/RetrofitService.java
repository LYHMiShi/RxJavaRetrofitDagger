package jiyun.com.rxjavaretrofitdagger.net;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import jiyun.com.rxjavaretrofitdagger.config.Urls;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;

    private RetrofitService() {
    }

    public static Api getInstance(){
        if(retrofit == null) {
            synchronized (RetrofitService.class){
                if(retrofit == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//打印日志
                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .connectTimeout(5, TimeUnit.SECONDS)
                            .writeTimeout(5,TimeUnit.SECONDS)
                            .readTimeout(5,TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(client)
                            .build();
                }
            }
        }
        return retrofit.create(Api.class);
    }
}
