package cn.ccw.slagschool.application;

import android.app.Application;

/**
 * Created by 陈传稳_95 on 2016/3/9.
 */
public class MyApplication extends Application {
    private static MyApplication app ;

    @Override
    public void onCreate() {
        super.onCreate();
        setApp(this);
    }

    private static MyApplication getApp() {
        return app;
    }

    private static void setApp(MyApplication app) {
        MyApplication.app = app;
    }

}
