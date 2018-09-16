package com.example.ggq.myweekthree.di;

import android.util.Log;
import com.example.ggq.myweekthree.entity.NewsEntity;
import com.example.ggq.myweekthree.utils.Retrofit_RXJava;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import rx.android.schedulers.AndroidSchedulers;

public class ModelImpl implements Icontract.IModel {
    private static final String TAG = "ModelImpl";

    @Override
    public void requestdata(final onCallBackListener onCallBackListener, String keywords,String page) {
        //.unsubscribeOn(Schedulers.io())
        Observable<NewsEntity> observable = Retrofit_RXJava.getInstance().getInterface().getResponse(keywords, page);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage().toString());
                    }

                    @Override
                    public void onNext(NewsEntity newsEntity) {
                        Log.d(TAG, "onNext: "+newsEntity.getPage()+"---"+newsEntity.getData());
                        onCallBackListener.responsemsg(newsEntity.getData());
                    }
                });
    }
}
