package com.android.app.dengzhaojun.inspiring.utils;

import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/7/31.
 */

public interface RetrofitService {
    @GET("1211-1")
    Call<Inspiring_Json> getSearchBook(@Query("showapi_appid") String id,
                                       @Query("showapi_sign") String sign,
                                       @Query("showapi_timestamp") String timestamp,
                                       @Query("count") int count);
}
