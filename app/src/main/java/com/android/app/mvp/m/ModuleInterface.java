package com.android.app.mvp.m;

import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */

public interface ModuleInterface {
    //获取数据状态回调的接口
    void LoadSuccess(List<Inspiring_Json.ShowapiResBodyBean.DataBean> data);

    void LoadFailed();
}
