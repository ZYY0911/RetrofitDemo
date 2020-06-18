package com.example.retrofitdemo;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Create by 张瀛煜 on 2020-05-07 ：）
 */
public interface UserClient {
    @POST("{user}")
    Call<Object> cellTraffic(@Path("user") String api, @Body RequestBody requestBody);
}
