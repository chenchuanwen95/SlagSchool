package cn.ccw.slagschool.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.base.BaseActivity;
import cn.ccw.slagschool.base.BaseInteface;

/**
 * Created by 陈传稳_95 on 2016/3/27.
 */
public class SearchSchool extends BaseActivity implements BaseInteface,View.OnClickListener {
    private Button search_btn ;
    private ImageView search_image_goBye ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.search_school_layout);
        setBac(this);
        initViews();
        initDatas();
        initViewOper();
    }

    @Override
    public void initViews() {
        search_btn = (Button) findViewById(R.id.search_btn);
        search_image_goBye = (ImageView) findViewById(R.id.search_image_goBye);
        search_btn.setOnClickListener(this);
        search_image_goBye.setOnClickListener(this);
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initViewOper() {

    }

    /**
     *
     * @param v 是传过来的参数
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_image_goBye:
                SearchSchool.this.finish();
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout) ;
                break ;
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setBac(null);
    }
}
