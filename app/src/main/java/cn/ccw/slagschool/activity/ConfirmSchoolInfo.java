package cn.ccw.slagschool.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.base.BaseActivity;
import cn.ccw.slagschool.base.BaseInteface;
import cn.ccw.slagschool.utils.FileIsSaveUtils;

/**
 * Created by 陈传稳_95 on 2016/3/30.
 */
public class ConfirmSchoolInfo extends BaseActivity implements BaseInteface,View.OnClickListener {
    private Button btn_gobye ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setBac(this);
        setContentView(R.layout.confirm_school_info_layout);
        initViews();
    }

    @Override
    public void initViews() {
        btn_gobye = (Button) findViewById(R.id.confirm_school_info_gobye);
        btn_gobye.setOnClickListener(this);
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initViewOper() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm_school_info_gobye:
                FileIsSaveUtils.setFiles(getBac(),"");
                Intent intent = new Intent(ConfirmSchoolInfo.this,SelectSchoolOrStudent.class) ;
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                break ;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setBac(null);
    }
}
