package cn.ccw.slagschool.application;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by 陈传稳_95 on 2016/3/9.
 */
public class MyApplication extends Application {
    private static MyApplication app ;

    @Override
    public void onCreate() {
        super.onCreate();
        setApp(this);
        AVOSCloud.initialize(this, "23sAIMYnIaoxBFWFYIYyBGpV-gzGzoHsz", "PU8k4HM5kCWFEEwnG7n2SX7G");
    }

    private static MyApplication getApp() {
        return app;
    }

    private static void setApp(MyApplication app) {
        MyApplication.app = app;
    }

}
