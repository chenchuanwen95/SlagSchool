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
 * Created by 陈传稳_95 on 2016/3/29.
 */
public class SelectSchoolOrStudent extends BaseActivity implements BaseInteface,View.OnClickListener {
    private Button select_layout_student ,select_layout_school ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBac(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.select_schoolorstudent_layout);
        initViews();
        initDatas();
        initViewOper();
    }

    @Override
    public void initViews() {
        select_layout_student = (Button) findViewById(R.id.select_layout_student);
        select_layout_student.setOnClickListener(this);
        select_layout_school = (Button) findViewById(R.id.select_layout_school);
        select_layout_school.setOnClickListener(this);
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initViewOper() {

    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()){
            case R.id.select_layout_student:
                intent = new Intent(getBac(),MainActivity.class) ;
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                FileIsSaveUtils.setFiles(getBac(),"MY NAME IS STUDENT");
                break ;
            case R.id.select_layout_school:
                toastS("点击了学校版");
                FileIsSaveUtils.setFiles(getBac(), "MY NAME IS SCHOOL");
                break ;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setBac(null);
    }
}
