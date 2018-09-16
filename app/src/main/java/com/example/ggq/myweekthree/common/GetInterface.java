package com.example.ggq.myweekthree.common;

import com.example.ggq.myweekthree.entity.NewsEntity;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface GetInterface {
    @POST("searchProducts")
    @FormUrlEncoded
    Observable<NewsEntity> getResponse(@Field("keywords") String keywords, @Field("page") String page);
}
