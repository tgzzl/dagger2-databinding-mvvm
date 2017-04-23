package com.tanner.repo.di.module;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;
import com.tanner.repo.domain.service.DailyService;
import com.tanner.repo.domain.service.StoryService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module
public class AppModule {
    static final String ENDPOINT = "http://news-at.zhihu.com/api/4/";
    final Retrofit retrofit;

    public AppModule() {
        retrofit = createRetrofit();
    }

    private Retrofit createRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(LoganSquareConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public DailyService provideDailyService() {
        return retrofit.create(DailyService.class);
    }

    @Provides
    @Singleton
    public StoryService provideStoryService() {
        return retrofit.create(StoryService.class);
    }
}
