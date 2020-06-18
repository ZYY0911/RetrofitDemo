package com.example.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitTo retrofitTo = new RetrofitTo();
        retrofitTo.setApi("get_all_car_peccancy")
                .setLoop(true)
                .setTime(3000)
                .setJsonObject("UserName", "user1")
                .setRetrofitLo(new RetrofitTo.RetrofitLo() {
                    @Override
                    public void onResponse(String jsonObject) {
                        Bean bean = new Gson().fromJson(jsonObject, Bean.class);
                        textView.setText(bean.toString());
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
                    }
                }).start();
        initView();
    }

    private void initView() {
        textView = findViewById(R.id.text_view);
    }
}
