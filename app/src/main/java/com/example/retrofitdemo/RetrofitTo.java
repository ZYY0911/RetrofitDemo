package com.example.retrofitdemo;

import com.google.gson.Gson;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by 张瀛煜 on 2020-05-07 ：）
 */
public class RetrofitTo extends Thread {
    private JSONObject jsonObject = new JSONObject();
    private String Url = "http://118.190.26.201:8080/traffic/";
    private boolean isLoop;
    private int time;
    private UserClient userClient;
    private String api;
    private RetrofitLo retrofitLo;

    public RetrofitTo setRetrofitLo(RetrofitLo retrofitLo) {
        this.retrofitLo = retrofitLo;
        return this;
    }

    public interface RetrofitLo {
        void onResponse(String jsonObject);
        void onFailure(Call<Object> call, Throwable t);
    }

    public RetrofitTo setApi(String api) {
        this.api = api;
        return this;
    }

    public RetrofitTo setLoop(boolean loop) {
        isLoop = loop;
        return this;
    }

    public RetrofitTo setTime(int time) {
        this.time = time;
        return this;
    }

    public RetrofitTo setJsonObject(String k, Object v) {
        try {
            jsonObject.put(k, v);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public RetrofitTo() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        userClient = retrofit.create(UserClient.class);
    }

    @Override
    public void run() {
        super.run();
        do {
            final RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type ,application/json"), jsonObject.toString());
            Call<Object> call = userClient.cellTraffic(api, requestBody);
            call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    retrofitLo.onResponse(new Gson().toJson(response.body()));
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    retrofitLo.onFailure(call, t);
                }
            });
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (isLoop);
    }
}
