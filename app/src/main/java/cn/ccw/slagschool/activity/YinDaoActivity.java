package cn.ccw.slagschool.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.fragment.YinDao1Fragment;
import cn.ccw.slagschool.fragment.YinDao2Fragment;
import cn.ccw.slagschool.fragment.YinDao3Fragment;
import cn.ccw.slagschool.fragment.YinDao4Fragment;

/**
 * Created by 陈传稳_95 on 2016/3/9.
 */
public class YinDaoActivity extends FragmentActivity{
//    private ViewPager mViewPager ;
//    private List<Fragment> mList ;
//    private ImageView mImageView ;
    private AlphaAnimation mAlphaAnimation ;
//    private boolean flag ;

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
//        if(flag){
//            mViewPager.setVisibility(View.VISIBLE);
//            mImageView.setVisibility(View.INVISIBLE);
//            mList = new ArrayList<>() ;
//            mList.add(new YinDao1Fragment()) ;
//            mList.add(new YinDao2Fragment()) ;
//            mList.add(new YinDao3Fragment()) ;
//            mList.add(new YinDao4Fragment()) ;
//            mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
//
//        }else{
//            mViewPager.setVisibility(View.INVISIBLE);
//            mImageView.setVisibility(View.VISIBLE);
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            Intent intent = new Intent(YinDaoActivity.this,MainActivity.class) ;
            startActivity(intent);
                    finish();
                }
            }.start();


//        }
    }

    /**
     * 加载视图
     *
     */
    private void initViews() {
//        mViewPager = (ViewPager) findViewById(R.id.viewpager);
//        mImageView = (ImageView) findViewById(R.id.act_welcome_image);
        mAlphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this,R.anim.yindao_anim);
    }

   /* public class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }*/

    /**
     * 点击事件
     * @param view
     */
   /* public void nextClick(View view){
        switch (view.getId()){
            case R.id.yin1_next:
                mViewPager.setCurrentItem(1);
                break ;
            case R.id.yin2_next:
                mViewPager.setCurrentItem(2);
                break ;
            case R.id.yin3_next:
                mViewPager.setCurrentItem(3);
                break ;
            case R.id.yin4_btn:
                Intent intent = new Intent(YinDaoActivity.this,MainActivity.class) ;
                startActivity(intent);
                break ;
        }
    }*/
}
