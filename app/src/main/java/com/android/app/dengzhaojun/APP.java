package com.android.app.dengzhaojun;

import com.android.app.mylibrary.BaseApp;
import com.android.app.mylibrary.util.MLog;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by Administrator on 2018/7/24.
 */

public class APP extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        /*
         注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调用初始化接口
         （如需要使用AndroidManifest.xml中配置好的appkey和channel值，
          UMConfigure.init调用中appkey和channel参数请置为null）。*/
        UMConfigure.init(this, "5b56ecb4f43e48607900021f", "GUANFANG", 0, "5b46cd5f565c3b8fdc17d70a5d03c33f");

        MobclickAgent.setSecret(this, "EScenarioType.E_DUM_NORMAL");

        // 打开统计SDK调试模式
        UMConfigure.setLogEnabled(true);

        //友盟手动统计开关
        MobclickAgent.openActivityDurationTrack(false);

        //推送服务
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                MLog.e("app", "注册成功");
            }

            @Override
            public void onFailure(String s, String s1) {
                MLog.e("app", "注册出错");
            }
        });

        MobclickAgent.setDebugMode(true);
    }
}
