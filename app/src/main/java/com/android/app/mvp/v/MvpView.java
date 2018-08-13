package com.android.app.mvp.v;

import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */

public interface MvpView {
    void showLoading();
    void hideLoading();
    void setListItem(List<Inspiring_Json.ShowapiResBodyBean.DataBean> data);
    void failed();
    void showMessage(String message);
}
