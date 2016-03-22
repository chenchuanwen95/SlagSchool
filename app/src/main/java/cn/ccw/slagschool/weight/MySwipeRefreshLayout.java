package cn.ccw.slagschool.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;

import cn.ccw.slagschool.R;

/**
 * Created by 陈传稳_95 on 2016/3/20.
 */
public class MySwipeRefreshLayout extends SwipeRefreshLayout {
    private static final String TAG = MySwipeRefreshLayout.class.getCanonicalName() ;
    //控件ID
    private int mScrollableChildId ;
    //子控件
    private View childView ;

    public MySwipeRefreshLayout(Context context) {
        super(context,null);
    }

    public MySwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取监听子控件的ID
        TypedArray mTypeArray = context.obtainStyledAttributes(attrs, R.styleable.MySwipeRefreshLayout) ;
        mScrollableChildId = mTypeArray.getResourceId(R.styleable.MySwipeRefreshLayout_scrollableChildId,0) ;
        childView = findViewById(mScrollableChildId) ;
    }
    //在自定义SwipRefreshLayout的时候一定要重写canChildScrollUp方法
    @Override
    public boolean canChildScrollUp() {
        ifChildId();
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (childView instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) childView;
                return absListView.getChildCount() > 0
                        && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0)
                        .getTop() < absListView.getPaddingTop());
            } else {
                return childView.getScrollY() > 0;
            }
        } else {
            return ViewCompat.canScrollVertically(childView, -1);
        }
    }
    public void ifChildId(){
        if(childView == null){
            childView = findViewById(mScrollableChildId) ;
        }
    }
}
