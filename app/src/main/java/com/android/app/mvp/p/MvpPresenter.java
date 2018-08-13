package com.android.app.mvp.p;

import com.android.app.dengzhaojun.inspiring.entity.Inspiring_Json;
import com.android.app.mvp.m.DataModule;
import com.android.app.mvp.m.ModuleInterface;
import com.android.app.mvp.v.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */

public class MvpPresenter implements ModuleInterface {

    private MvpView mvpView;

    //获取Module实例，执行数据处理方法。
    DataModule dataModule = new DataModule(this);;
    public MvpPresenter(MvpView mvpView){
        this.mvpView = mvpView;

    }


    public void handledata() {
        mvpView.showLoading();
        dataModule.GetData();
    }

    public void onItemClick(int position){
        mvpView.showMessage("点击了item"+position);
    }

    //数据传过来之后，继续执行逻辑

    @Override
    public void LoadSuccess(List<Inspiring_Json.ShowapiResBodyBean.DataBean> data) {
        mvpView.hideLoading();
        mvpView.setListItem(data);
    }

    @Override
    public void LoadFailed() {
        //处理失败后View的操作
        mvpView.failed();
    }
}
