package cn.ccw.slagschool.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.adapter.MyRecyclerViewAdapter;
import cn.ccw.slagschool.base.BaseActivity;
import cn.ccw.slagschool.base.BaseInteface;
import cn.ccw.slagschool.vo.SchoolInfo;
import cn.ccw.slagschool.weight.MySwipeRefreshLayout;

public class MainActivity extends BaseActivity implements BaseInteface {
    private SwipeRefreshLayout mSwipeRefreshLayout ;
    private RecyclerView mRecyclerView ;
    private LinearLayoutManager mLinearLayoutManager ;
    private MyRecyclerViewAdapter adapter  ;
    private List<SchoolInfo> lists ;
    private SchoolInfo mSchoolInfo ;
    private int lastVisibleItem = 0;
    //以下是模拟数据
    private String schoolName[] = {"山东信息职业技术学院","山东大学","北京大学","清华大学","复旦大学"} ;
    private String dizhi[] = {"山东","山东","北京","北京","上海"} ;
    private String guomin[] = {"国办高校","国办高校","国办高校","国办高校","国办高校"} ;
    private String zhuanben[] = {"普通专科","211/958高校","211/958高校","211/958高校","211/958高校"} ;
    private String score[] = {"180","文400/理380","文630/理610","文620/理600","文610/理600"} ;
    private String yuzhao[] = {"1200","800","400","600","1000"} ;
    private String shengnyu[] = {"200","80","100","100","64"} ;
    private String cutTime[] = {"8月25日","8月25日","8月20日","8月15日","8月20日"} ;
    private String jianxiaoTime[] = {"2002年7月","1901年","1898年7月3日","1911年4月26日","1905年9月14日"} ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setBac(this);
        initViews();
        initDatas();
        initViewOper();
    }

    @Override
    public void initViews() {
        /**
         *这里是在对SwipeRefreshlayout进行初始化
         */
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this) ;
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        //设置每个Item的高度是固定的，可以提高性能
        mRecyclerView.setHasFixedSize(true);

    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void initDatas() {


        //这里是RecylerView的滑动事件
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == adapter.getItemCount()) {
                    mSwipeRefreshLayout.setRefreshing(true);
                    // 此处在现实项目中，请换成网络请求数据代码，sendRequest .....
//                    handler.sendEmptyMessageDelayed(0, 3000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
            }

        });
        //这里是对SwipeRefreshlayout组件进行设置 一些背景颜色和大小
        mSwipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED);
//        mSwipeRefreshLayout.setProgressViewEndTarget(true, 300);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    //模拟数据
    private void initSchoolInfo() {
        lists = new ArrayList<SchoolInfo>();
        for (int i = 0;i<5;i++){
            mSchoolInfo = new SchoolInfo() ;
            mSchoolInfo.setSchoolName(schoolName[i]);
            mSchoolInfo.setAddress(dizhi[i]);
            mSchoolInfo.setIsNotional(guomin[i]);
            mSchoolInfo.setIsDegree(zhuanben[i]);
            mSchoolInfo.setScore(score[i]);
            mSchoolInfo.setPrepareNumber(yuzhao[i]);
            mSchoolInfo.setRemainNumber(shengnyu[i]);
            mSchoolInfo.setCutTime(cutTime[i]);
            mSchoolInfo.setFoundedTime(jianxiaoTime[i]);
            lists.add(mSchoolInfo) ;
        }
        adapter = new MyRecyclerViewAdapter(this,lists);
        mRecyclerView.setAdapter(adapter);
    }
    /**
     * 这里是titleBar上面的图片点击事件
     * @param view
     */
    public void imageOnClick(View view){
        ImageView iv = (ImageView) view;
        switch (iv.getId()){
            case R.id.more:
                View mView = getLayoutInflater().inflate(R.layout.popupwindow_layout,null) ;
                PopupWindow pw = new PopupWindow(mView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true) ;
                pw.setTouchable(true);
                pw.setTouchInterceptor(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                    }
                });
                pw.setAnimationStyle(R.style.popupAnim);
                pw.setBackgroundDrawable(getResources().getDrawable(R.mipmap.bg));
                pw.showAsDropDown(iv);
                break;
            case R.id.setting:
                Toast.makeText(MainActivity.this, "点击了设置按钮", Toast.LENGTH_SHORT).show();
                break ;
        }
    }

    @Override
   public void initViewOper() {
        //设置RecylerView的填充组件
        initSchoolInfo() ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setBac(null);
    }
}
