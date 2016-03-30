package cn.ccw.slagschool.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.utils.FileIsSaveUtils;

/**
 * Created by 陈传稳_95 on 2016/3/9.
 */
public class YinDaoActivity extends FragmentActivity{
    private AlphaAnimation mAlphaAnimation ;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.yindao_act);
        initViews() ;
        initDatas() ;

    }

    /**
     * 判断是否是第一次进入  这个判断暂时先不做
     */
    private void initDatas() {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(FileIsSaveUtils.isSaveFile(YinDaoActivity.this)){
                    String text = FileIsSaveUtils.getFiles(YinDaoActivity.this) ;
                    if("".equals(text)||text == null){
                        intent = new Intent(YinDaoActivity.this,SelectSchoolOrStudent.class) ;
                    }else if("MY NAME IS STUDENT".equals(text)){
                        intent = new Intent(YinDaoActivity.this,MainActivity.class) ;
                    }else if("MY NAME IS SCHOOL".equals(text)){
                        intent = new Intent(YinDaoActivity.this,ConfirmSchoolInfo.class);
                    }
                }else{
                    intent = new Intent(YinDaoActivity.this,SelectSchoolOrStudent.class) ;
                }
                startActivity(intent);
                finish();
            }
        }.start();
    }

    /**
     * 加载视图
     *
     */
    private void initViews() {
        mAlphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this,R.anim.yindao_anim);
    }

    @Override
    public void onBackPressed() {
    }
}
