package cn.ccw.slagschool.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.base.BaseActivity;
import cn.ccw.slagschool.base.BaseInteface;
import cn.ccw.slagschool.fragment.SchoolDetailsFragment;
import cn.ccw.slagschool.fragment.SchoolMaintainFragment;

/**
 * Created by 陈传稳_95 on 2016/3/31.
 */
public class SchoolActivity extends BaseActivity implements BaseInteface {
    private TextView[] tv = new TextView[2];
    private boolean flag ;
    private ViewPager vp_school ;
    private List<Fragment> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setBac(this);
        setContentView(R.layout.school_activity);
        initViews();
        initDatas();
        initViewOper();
    }

    @Override
    public void initViews() {
        tv[0] = (TextView) findViewById(R.id.school_activity_linear2_text1);
        tv[1] = (TextView) findViewById(R.id.school_activity_linear2_text2);
        vp_school = (ViewPager) findViewById(R.id.school_activity_viewpager);
    }

    @Override
    public void initDatas() {
        lists = new ArrayList<>() ;
        lists.add(new SchoolDetailsFragment()) ;
        lists.add(new SchoolMaintainFragment()) ;
        vp_school.setAdapter(new MyViewpagerAdapter(getSupportFragmentManager()));
        vp_school.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                cutView(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initViewOper() {

    }

    /**
     * 这里是TextView的点击事件
     */
    public void textOnClick(View v){
        switch (v.getId()){
            case R.id.school_activity_linear2_text1:
                cutView(0) ;
                vp_school.setCurrentItem(0);
                break;
            case R.id.school_activity_linear2_text2:
                cutView(1) ;
                vp_school.setCurrentItem(1);
                break ;
        }
    }

    /**
     * 切换视图
     * @param cut 位置坐标
     */
    private void cutView(int cut) {
        for(int i = 0;i<2;i++){
            if(i==cut){
                tv[i].setTextColor(getResources().getColor(R.color.green1));
                tv[i].setBackgroundColor(getResources().getColor(R.color.write));
            }else{
                tv[i].setTextColor(getResources().getColor(R.color.write));
                tv[i].setBackgroundColor(getResources().getColor(R.color.green1));
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setBac(null);
    }
    class MyViewpagerAdapter extends FragmentPagerAdapter{

        public MyViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }

        @Override
        public int getCount() {
            return lists.size();
        }
    }
}
