package cn.ccw.slagschool.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.ccw.slagschool.R;
import cn.ccw.slagschool.schoolcloud.SampleSchoolCloud;
import cn.ccw.slagschool.adapter.MyRecyclerViewAdapter;
import cn.ccw.slagschool.base.BaseActivity;
import cn.ccw.slagschool.base.BaseInteface;
import cn.ccw.slagschool.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import cn.ccw.slagschool.utils.RecyclerViewStateUtils;
import cn.ccw.slagschool.vo.SchoolInfo;
import cn.ccw.slagschool.weight.LoadingFooter;
import cn.ccw.slagschool.weight.PullRefreshLayout;

public class MainActivity extends BaseActivity implements BaseInteface {
    private PullRefreshLayout mPullRefreshLayout ;
    private RecyclerView mRecyclerView ;
    private View layout ;
    private PopupWindow pw ;
    private boolean flag ;
    private LinearLayoutManager mLinearLayoutManager ;
    private MyRecyclerViewAdapter adapter  ;
    private HeaderAndFooterRecyclerViewAdapter mAdapter ;
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
         *这里是在对PullRefreshLayout进行初始化
         */
        layout = getLayoutInflater().inflate(R.layout.home_activity,null) ;
        mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullrefreshlayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        mPullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_WATER_DROP);
        //设置每个Item的高度是固定的，可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this) ;
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void initDatas() {
        View mView = getLayoutInflater().inflate(R.layout.popupwindow_layout,null) ;
        pw = new PopupWindow(mView, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT, true) ;
        pw.setTouchable(true);
        pw.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });
        pw.setAnimationStyle(R.style.popupAnim);
        pw.setBackgroundDrawable(getResources().getDrawable(R.mipmap.bg));

//设置RecylerView的填充组件
        initSchoolInfo() ;
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
        mAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter) ;
        mRecyclerView.setAdapter(mAdapter);
        /**
         * 设置显示页尾
         */
        RecyclerViewStateUtils.setFooterViewState(this,mRecyclerView,5,LoadingFooter.State.TheEnd,null);
        mRecyclerView.scrollToPosition(0);
    }
    /**
     * 这里是titleBar上面的图片点击事件
     * @param view
     */
    public void imageOnClick(View view){
        switch (view.getId()){
            case R.id.more:
                backgroundAlpha(0.3f);
                pw.showAtLocation(layout, Gravity.CENTER,0,0);
                break;
            case R.id.setting:
                Toast.makeText(MainActivity.this, "点击了设置按钮", Toast.LENGTH_SHORT).show();
                break ;
            case R.id.search_layout:
                Intent intent = new Intent(MainActivity.this,SearchSchool.class) ;
                startActivity(intent);
                pw.dismiss();
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout) ;
                break ;
            case R.id.yun_layout:
                Intent intent1 = new Intent(MainActivity.this, SampleSchoolCloud.class) ;
                startActivity(intent1);
                pw.dismiss();
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                break ;
        }
    }

    @Override
    public void initViewOper() {
        mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        //这里是RecylerView的滑动事件
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            //用来标记是否正在向最后一个滑动，既是否向右滑动或向下滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager manager = (LinearLayoutManager)recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem == (totalItemCount -1) && isSlidingToLast) {
                        //加载更多功能的代码
                        Toast.makeText(MainActivity.this,"加载更多",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if(dx > 0){
                    //大于0表示，正在向右滚动
                    isSlidingToLast = true;
                }else{
                    //小于等于0 表示停止或向左滚动
                    isSlidingToLast = false;
                }

            }
        });
    }

    /**
     * 这里是让当前的界面变透明
     */
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    @Override
    public void onBackPressed() {
        if(flag){
            super.onBackPressed();
        }else{
            toastS("再次点击退出");
            flag = true ;
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        toastS("退出异常");
                    }
                    flag = false ;
                }
            }.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setBac(null);
    }
}
