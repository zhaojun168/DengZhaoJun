package com.android.app.mvp.m;

import android.widget.Toast;

import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;
import com.android.app.dengzhaojun.inspiring.utils.RetrofitService;
import com.android.app.dengzhaojun.utils.Constants;
import com.android.app.mylibrary.util.MLog;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/8/7.
 */

public class DataModule {

    private ModuleInterface mCallback;

    public DataModule(ModuleInterface moduleInterface){
        this.mCallback = moduleInterface;
    }


    public void GetData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<Inspiring_Json> call = service.getSearchBook(Constants.SHOWAPI_APPID,Constants.SHWAPI_SIGN,Constants.SHOWAPI_TIMESTAMP,Constants.COUNT);
        call.enqueue(new Callback<Inspiring_Json>() {
            @Override
            public void onResponse(Call<Inspiring_Json> call, Response<Inspiring_Json> response) {
//                mList.addAll(response.body().getShowapi_res_body().getData());
//                mAdapter.notifyDataSetChanged();
//                MLog.e(TAG,mList.size());
                mCallback.LoadSuccess(response.body().getShowapi_res_body().getData());
            }

            @Override
            public void onFailure(Call<Inspiring_Json> call, Throwable t) {
//                Toast.makeText(mContext, "系统错误", Toast.LENGTH_SHORT).show();
                mCallback.LoadFailed();
            }
        });
    }
}
