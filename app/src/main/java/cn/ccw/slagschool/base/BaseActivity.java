package cn.ccw.slagschool.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by 陈传稳_95 on 2016/3/9.
 */
public class BaseActivity extends AppCompatActivity {
    private BaseActivity bac ;

    public BaseActivity getBac() {
        return bac;
    }

    public void setBac(BaseActivity bac) {
        this.bac = bac;
    }
    public void toastS(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
