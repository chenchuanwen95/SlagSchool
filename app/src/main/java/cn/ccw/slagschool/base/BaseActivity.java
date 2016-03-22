package cn.ccw.slagschool.base;

import android.app.Activity;

/**
 * Created by 陈传稳_95 on 2016/3/9.
 */
public class BaseActivity extends Activity {
    private BaseActivity bac ;

    public BaseActivity getBac() {
        return bac;
    }

    public void setBac(BaseActivity bac) {
        this.bac = bac;
    }
}
